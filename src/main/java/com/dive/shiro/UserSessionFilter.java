package com.dive.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.dive.entity.Users;
import com.dive.service.UsersService;

/**
 * @desc
 * @author HZW
 * @date 2017年10月26日 下午4:50:30
 */
public class UserSessionFilter extends AccessControlFilter {
	Logger logger = Logger.getLogger(UserSessionFilter.class);

	@Autowired
	private UsersService usersService;

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		logger.info("进入到了判断session内的Current是否存在");

	        Subject currentUser = SecurityUtils.getSubject();
	        //判断用户是通过记住我功能自动登录,此时session失效
	        if(!currentUser.isAuthenticated() && currentUser.isRemembered()){
	        	logger.info("进入了用户是通过记住我功能自动登录,但是session失效");
	            try {
	            	Users users = new Users();
	            	users.setUserName(currentUser.getPrincipals().toString());
	                Users user = usersService.QueryUser(users);
	                //对密码进行加密后验证
	                UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword(),currentUser.isRemembered());
	                //把当前用户放入session
	                currentUser.login(token);
	                logger.info("结束了。。。。。");
	            }catch (Exception e){
	                //自动登录失败,跳转到登录页面
	                return false;
	            }
	            if(!currentUser.isAuthenticated()){
	                //自动登录失败,跳转到登录页面
	                return false;
	            }
	        }
	        return true;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		return true;
	}
}
