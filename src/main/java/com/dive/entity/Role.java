package com.dive.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @desc
 * @author HZW
 * @date   2017年6月21日 下午12:02:55
 */
public class Role implements Serializable{
	private int roleId;//角色id
	private String roleName;//角色名称
	private String remark;//描述
	private Timestamp createtime;//创建时间
	private int createby;//创建人
	private Timestamp updatetime;//更新时间
	private int updateby;//更新人
	
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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


