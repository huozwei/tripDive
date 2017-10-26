package com.dive.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dive.dao.RoleDao;
import com.dive.entity.Role;
import com.dive.service.RoleService;

/**
 * @desc
 * @author HZW
 * @date   2017年6月21日 下午12:14:23
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Set<String> queryRolesByUser(String userName) {
		return roleDao.queryRolesByUser(userName);
	}

	@Override
	public List<Role> queryRolesByUsers(String userName) {
		System.out.println("userName:"+userName);
		return roleDao.queryRolesByUsers(userName);
	}
	
}


