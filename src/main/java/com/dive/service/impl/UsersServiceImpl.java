package com.dive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dive.dao.UsersDao;
import com.dive.entity.Users;
import com.dive.service.UsersService;

/**
 * @desc
 * @author HZW
 * @date   2017年6月12日 下午3:28:35
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao userDao;
	
	@Override
	public Users QueryUsers(String userName,String password) {
		return userDao.QueryUsers(userName,password);
	}

	@Override
	public List<Users> GetUserList() {
		return userDao.GetUserList();
	}

	@Override
	public void insertUsers(Users user) {
		/*JSONObject json = new JSONObject();
		json.put("empName", user.getEmpName());
		json.put("password", user.getPassword());
		json.put("phone", user.getPhone());
		json.put("age", user.getAge());
		
		JSONObject returnJson = HttpClientPostJsonUtil.httpPost("http", json);
		user.setEmpName(returnJson.getString("empName"));
		user.setPassword(returnJson.getString("password"));
		user.setPhone(returnJson.getString("phone"));
		user.setAge(returnJson.getString("age"));
		*/
		userDao.insertUsers(user);
	}

	@Override
	public boolean addUsers(List<Users> listuser) {
		return userDao.addUsers(listuser);
	}

	@Override
	public Users QueryUser(Users user) {
		return userDao.QueryUser(user);
	}

}


