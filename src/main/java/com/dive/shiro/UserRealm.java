package com.dive.shiro;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.dive.entity.Users;
import com.dive.service.ResourcesService;
import com.dive.service.RoleService;
import com.dive.service.UsersService;

/**
 * @desc
 * @author HZW
 * @date 2017年6月19日 上午10:32:37
 */
public class UserRealm extends AuthorizingRealm {
	private static final Logger logger = Logger.getLogger(UserRealm.class);
	@Autowired
	private UsersService usersService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourcesService resourcesService;

	/**
	 * 用户权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection prin) {
		logger.info("进入到用户权限认证");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 拿到用户对应的角色
		Set<String> roles = roleService.queryRolesByUser(prin.getPrimaryPrincipal().toString());
		Iterator<String> it = roles.iterator();
		while (it.hasNext()) {
			logger.info("获取到的角色为：" + it.next());
		}
		// 将查到的角色放入shiro
		authorizationInfo.setRoles(roles);
		// 拿到角色对应的菜单
		Set<String> permissions = resourcesService.queryResourcesByUser(prin.getPrimaryPrincipal().toString());
		Iterator<String> its = permissions.iterator();
		while (its.hasNext()) {
			logger.info("获取到的资源为：" + its.next());
		}
		// 将查到的菜单放入shiro
		authorizationInfo.setStringPermissions(permissions);

		return authorizationInfo;
	}

	/**
	 * 用户登录认证
	 */
	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("进入到用户登录认证");
		String userName = token.getPrincipal().toString();// 用户名
		String password = new String((char[]) token.getCredentials());// 密码
		logger.info("用户名为：" + userName + "   密码为：" + password);
		Users currentUser = usersService.QueryUsers(userName, password);
		logger.info("查到的用户大小为：" + currentUser.getUserName());

		if (currentUser == null) {
			throw new UnknownAccountException(); // 如果用户名错误
		}
		if (!currentUser.getPassword().equals(password)) {
			throw new IncorrectCredentialsException(); // 如果密码错误
		}

		if (currentUser != null) {
			logger.info("当前用户不为空");
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, password, getName());
			this.setSession("currentUser", currentUser);
			return authenticationInfo;
		} else {
			logger.info("未找到对应用户");
			return null;
		}
	}

	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * 
	 * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			logger.info("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

}
