package com.dive.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dive.entity.Role;

/**
 * @desc
 * @author HZW
 * @date   2017年6月21日 下午12:16:45
 */
@Repository
public interface RoleDao {
	/**
	 * @desc   根据用户名查询用户角色
	 * @param userName
	 * @return
	 */
	public Set<String> queryRolesByUser(@Param("userName") String userName);
	
	/**
	 * @desc   根据用户名查询用户角色
	 * @param userName
	 * @return
	 */
	public List<Role> queryRolesByUsers(@Param("userName") String userName);
}


