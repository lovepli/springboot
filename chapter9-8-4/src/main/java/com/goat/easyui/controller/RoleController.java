package com.goat.easyui.controller;


import com.github.pagehelper.PageInfo;
import com.goat.easyui.domain.QueryRequest;
import com.goat.easyui.domain.Role;
import com.goat.easyui.resultmodel.RestResult;
import com.goat.easyui.resultmodel.ResultGenerator;
import com.goat.easyui.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController  {

    private final ResultGenerator generator = new ResultGenerator();
	@Autowired
	private IRoleService roleService;


    @RequestMapping("/list")
    @ResponseBody
    public RestResult roleList(QueryRequest request, Role role) {
        List<Role> list = roleService.findByPage(request.getPage(), request.getRows());
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return generator.getSuccessUiResult("datang", pageInfo.getList(), pageInfo.getTotal());
    }
//    @RequestMapping("/list")
//    public RestResult userList(QueryRequest request) {
//        //        PageHelper.startPage(request.getPage(), request.getRows());
//        List<User> list = userService.findByPage(request.getPage(), request.getRows());
//        PageInfo<User> pageInfo = new PageInfo<>(list);
//        return generator.getSuccessUiResult("datang", pageInfo.getList(), pageInfo.getTotal());
//    }

	
//	@RequestMapping("role/getRole")
//	@ResponseBody
//	public ResponseBo getRole(Long roleId) {
//		try {
//			Role role = this.roleService.findRoleWithMenus(roleId);
//			return ResponseBo.ok(role);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("获取角色信息失败，请联系网站管理员！");
//		}
//	}

//	@RequestMapping("role/checkRoleName")
//	@ResponseBody
//	public boolean checkRoleName(String roleName, String oldRoleName) {
//		if (StringUtils.isNotBlank(oldRoleName) && roleName.equalsIgnoreCase(oldRoleName)) {
//			return true;
//		}
//		Role result = this.roleService.findByName(roleName);
//		if (result != null)
//			return false;
//		return true;
//	}
//
//	@Log("新增角色")
//	@RequiresPermissions("role:add")
//	@RequestMapping("role/add")
//	@ResponseBody
//	public ResponseBo addRole(Role role, Long[] menuId) {
//		try {
//			this.roleService.addRole(role, menuId);
//			return ResponseBo.ok("新增角色成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("新增角色失败，请联系网站管理员！");
//		}
//	}
//
//	@Log("删除角色")
//	@RequiresPermissions("role:delete")
//	@RequestMapping("role/delete")
//	@ResponseBody
//	public ResponseBo deleteRoles(String ids) {
//		try {
//			this.roleService.deleteRoles(ids);
//			return ResponseBo.ok("删除角色成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("删除角色失败，请联系网站管理员！");
//		}
//	}
//
//	@Log("修改角色")
//	@RequiresPermissions("role:update")
//	@RequestMapping("role/update")
//	@ResponseBody
//	public ResponseBo updateRole(Role role, Long[] menuId) {
//		try {
//			this.roleService.updateRole(role, menuId);
//			return ResponseBo.ok("修改角色成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("修改角色失败，请联系网站管理员！");
//		}
//	}
}
