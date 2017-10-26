package com.dive.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @desc   用户资源
 * @author HZW
 * @date   2017年6月21日 下午12:05:26
 */
public class Resources implements Serializable{
	private int resId;//菜单id
	private int parentId;//上级菜单id  0：一级菜单  其他：子菜单
	private String resName;//菜单名称
	private String resUrl;//地址
	private int resType;//类型
	private Timestamp createtime;//创建时间
	private int createby;//创建人
	private Timestamp updatetime;//更新时间
	private int updateby;//更新人
	
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResUrl() {
		return resUrl;
	}
	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}
	public int getResType() {
		return resType;
	}
	public void setResType(int resType) {
		this.resType = resType;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public int getCreateby() {
		return createby;
	}
	public void setCreateby(int createby) {
		this.createby = createby;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public int getUpdateby() {
		return updateby;
	}
	public void setUpdateby(int updateby) {
		this.updateby = updateby;
	}
	
}


