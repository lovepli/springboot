package com.goat.doit.system.controller;


import com.goat.doit.system.service.UserService;
import com.goat.doit.util.ResultUtil;
import com.goat.doit.system.vo.UserOnlineVo;
import com.goat.doit.system.vo.UserSessionVo;
import com.goat.doit.system.vo.base.PageResultVo;
import com.goat.doit.system.vo.base.ResponseVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;



@Controller
@RequestMapping("/online/user")
public class OnlineUserController {
    @Autowired
    private UserService userService;

    // 在线用户列表
    @PostMapping("/list")
    @ResponseBody
    public PageResultVo onlineUsers(UserOnlineVo user, Integer limit, Integer offset){
        List<UserOnlineVo> userList = userService.selectOnlineUsers(user);
        int endIndex = (offset+limit) > userList.size() ? userList.size() : (offset+limit);
        return ResultUtil.table(userList.subList(offset,endIndex),(long)userList.size());
    }

    // 强制踢出用户
    @PostMapping("/kickout")
    @ResponseBody
    public ResponseVo kickout(String sessionId, String username) {
        try {
            if(SecurityUtils.getSubject().getSession().getId().equals(sessionId)){
                return ResultUtil.error("不能踢出自己");
            }
            userService.kickout(sessionId,username);
            return ResultUtil.success("踢出用户成功");
        } catch (Exception e) {
            return ResultUtil.error("踢出用户失败");
        }
    }

    // 批量强制踢出用户
    @PostMapping("/batch/kickout")
    @ResponseBody
    public ResponseVo kickout(@RequestBody List<UserSessionVo> sessions) {
        try {
            //要踢出的用户中是否有自己
            boolean hasOwn=false;
            Serializable sessionId = SecurityUtils.getSubject().getSession().getId();
            for (UserSessionVo sessionVo : sessions) {
                if(sessionVo.getSessionId().equals(sessionId)){
                    hasOwn=true;
                }else{
                    userService.kickout(sessionVo.getSessionId(),sessionVo.getUsername());
                }


            }
            if(hasOwn){
                return ResultUtil.success("不能踢出自己");
            }
            return ResultUtil.success("踢出用户成功");
        } catch (Exception e) {
            return ResultUtil.error("踢出用户失败");
        }
    }
}
