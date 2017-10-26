package com.dive.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.dive.entity.Resources;

/**
 * @desc
 * @author HZW
 * @date   2017年6月21日 下午12:13:21
 */
@Repository
public interface ResourcesService {
	
	/**
	 * @desc  根据用户名查询对应菜单
	 * @param userName
	 * @return
	 */
	public Set<String> queryResourcesByUser(String userName);
	
	/**
	 * @desc  根据用户id查询菜单
	 * @param userName
	 * @return
	 */
	public List<Resources> queryResourcesByUserId(int userId);
	
	/**
	 * @desc  根据用户名查询对应菜单
	 * @param userName
	 * @return
	 */
	public List<Resources> queryResourcesByUserName(String userName);
	
}


