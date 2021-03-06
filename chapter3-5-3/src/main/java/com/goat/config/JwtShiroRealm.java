package com.goat.config;

import com.goat.dto.UserDto;
import com.goat.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


/**
 * 自定义身份认证
 * 基于HMAC（ 散列消息认证码）的控制域
 */

public class JwtShiroRealm extends AuthorizingRealm {

    protected UserService userService;

    public JwtShiroRealm(UserService userService){
        this.userService = userService;
        this.setCredentialsMatcher(new JwtCredentialsMatcher()); //这里使用我们自定义的Matcher
    }

    /**
     * 限定这个Realm只支持我们自定义的JWT Token
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        System.out.println("进入 JwtShiroRealm---supports() 操作。。。。。。。。。。。。。。");
        return token instanceof JwtToken;
    }

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     *  跟controller登录一样，也是获取用户的salt值，给到shiro，由shiro来调用matcher来做认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        System.out.println("进入 JwtShiroRealm---doGetAuthenticationInfo() 认证操作。。。。。。。。。。。。。。");
        JwtToken jwtToken = (JwtToken) authcToken;
        String token = jwtToken.getToken();
        UserDto user = userService.getJwtTokenInfo(JwtUtils.getUsername(token));
        if(user == null)
            throw new AuthenticationException("token过期，请重新登录");
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getSalt(), "jwtRealm");
        return authenticationInfo;
    }

    /**在JWT Realm里面，因为没有存储角色信息，所以直接返回空就可以了：*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("进入 JwtShiroRealm---doGetAuthorizationInfo() 授权操作。。。。。。。。。。。。。。");
        return new SimpleAuthorizationInfo();
    }
}
