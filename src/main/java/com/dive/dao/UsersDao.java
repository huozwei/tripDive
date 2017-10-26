package com.dive.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dive.entity.Users;

/**
 * @desc
 * @author HZW
 * @date   2017年6月12日 下午3:29:02
 */
@Repository
public interface UsersDao {
	Users QueryUsers(@Param("userName") String userName,@Param("password") String password);
	Users QueryUser(Users user);
	List<Users> GetUserList();
	void insertUsers(Users user);
	boolean addUsers(List<Users> listuser);
}


