package com.bjdreamtech.dmt.bean;

/**
 * 管理员登录后存储在session中的bean对象
 * @author duanwu
 *
 */
public class DMTSessionBean {
	
	//管理员ID
	private String adminid;
	//员工编号
	private String staffno;
	//机构编号
	private String branchid;
	//用户名
	private String username;
	//角色ID
	private String roleid;
	//角色名称
	private String rolename;
	//真实姓名
	private String realname;
	//是否强制修改密码 0否  1是
	private String mark;
	//手机号码
	private String phone;
	//上次登录时间
	private String lasttime;
	//本次登录时间
	private String time;
	//本次登陆IP
	private String ip;

	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBranchid() {
		return branchid;
	}
	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStaffno() {
		return staffno;
	}
	public void setStaffno(String staffno) {
		this.staffno = staffno;
	}
	
	
}
