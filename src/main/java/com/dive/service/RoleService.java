package com.dive.service;

import java.util.List;
import java.util.Set;

import com.dive.entity.Role;

/**
 * @desc
 * @author HZW
 * @date   2017年6月21日 下午12:13:00
 */
public interface RoleService {
	
	/**
	 * @desc   根据用户名查询用户角色
	 * @param userName
	 * @return
	 */
	public Set<String> queryRolesByUser(String userName);
	
	/**
	 * @desc   根据用户名查询用户角色
	 * @param userName
	 * @return
	 */
	public List<Role> queryRolesByUsers(String userName);
	
	
}


