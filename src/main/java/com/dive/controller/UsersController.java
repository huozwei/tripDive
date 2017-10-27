package com.dive.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dive.entity.Resources;
import com.dive.entity.Users;
import com.dive.service.ResourcesService;
import com.dive.service.UsersService;


/**
 * @desc
 * @author HZW
 * @date   2017年6月12日 下午3:18:52
 */
@Controller
@RequestMapping("/users")
public class UsersController extends BaseController{
	Logger logger = Logger.getLogger(UsersController.class);
	
	@Autowired
	private UsersService usersService;
	@Autowired
	private ResourcesService resourcesService;
	
	/**
	 * 查询用户
	 */
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public void queryUsers(String userName, String password,HttpServletRequest request,
			HttpServletResponse response){
		logger.info("jinruchengongle");
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
			token.setRememberMe(true);
			subject.login(token);
			
			PrintWriter pw = response.getWriter();
			pw.write(success().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/userlist")
	public String getUserList(ModelMap model,HttpServletRequest request){
		logger.info("进入到获取用户列表");
		List<Users> userList = usersService.GetUserList();
		model.addAttribute("userlist", userList);
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		logger.info("user是否有值："+userName);
		
		//加载菜单,根据用户名去加载对应用户的资源
		List<Resources> resList = resourcesService.queryResourcesByUserName(userName);
		
		List<Resources> resourceList = new ArrayList<>();
		
		//获取一级菜单
		for (Resources resources : resList) {
			logger.info("拿到的菜单的级别为："+resources.getParentId()+"   菜单名称为："+resources.getResName());
			//0表示为一级菜单
			if(resources.getParentId()==0){
				
			}
		}
		
		return "users/userlist";
	}
	
}


