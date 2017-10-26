package com.dive.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dive.dao.ResourcesDao;
import com.dive.entity.Resources;
import com.dive.service.ResourcesService;

/**
 * @desc
 * @author HZW
 * @date   2017年6月21日 下午12:15:26
 */
@Service
@Transactional
public class ResourcesServiceImpl implements ResourcesService {
	@Autowired
	private ResourcesDao resourcesDao;

	@Override
	public Set<String> queryResourcesByUser(String userName) {
		return resourcesDao.queryResourcesByUser(userName);
	}

	@Override
	public List<Resources> queryResourcesByUserId(int userId) {
		return resourcesDao.queryResourcesByUserId(userId);
	}

	@Override
	public List<Resources> queryResourcesByUserName(String userName) {
		return resourcesDao.queryResourcesByUserName(userName);
	}
	
	

}


