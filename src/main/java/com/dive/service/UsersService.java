package com.dive.service;

import java.util.List;

import com.dive.entity.Users;

/**
 * @desc
 * @author HZW
 * @date   2017年6月12日 下午3:28:09
 */
public interface UsersService {
	
	/**
	 * 查询用户
	 * @return
	 */
	Users QueryUsers(String userName,String password);
	
	/**
	 * @Desc   查询用户  
	 * @author HZW
	 * @Date   2017年10月26日 下午5:08:55 
	 * @param user
	 * @return
	 */
	Users QueryUser(Users user);
	
	/**
	 * 拿到所有用户
	 * @return
	 */
	List<Users> GetUserList(); 
	
	void insertUsers(Users user);
	
	boolean addUsers(List<Users> listuser);
	
}


