package com.dive.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @desc   用户类
 * @author HZW
 * @date   2017年6月12日  下午3:27:34
 */
public class Users implements Serializable{
	private int userId;//用户id
	private String userName;//用户名
	private String password;//密码
	private String userPhone;//联系方式
	private String userAddress;//地址
	private int userAge;//年龄
	private String userEmail;//邮箱
	private int state;//用户状态  0:可用  1：禁用
	private String remark;
	private Timestamp createtime;//创建时间
	private int createby;//创建人
	private Timestamp updatetime;//更新时间
	private int updateby;//更新人
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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


