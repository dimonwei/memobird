package com.cxocx.guguji.entity;

/**
 * 用户关联实体类
 * @author DIMON
 */
public class user {
	private String memobirdID; //咕咕机的设备编号(双击设备吐出来的设备编号)
	private String useridentifying; //与咕咕平台进行关联的用户唯一标识符 (用户自定义字符串)
	private int showapi_res_code; //返回标志，1 为成功，其他为失败。
	private String showapi_res_error; //Ak 错误信息的显示
	private int showapi_userid; //用户ID
	public String getMemobirdID() {
		return memobirdID;
	}
	public void setMemobirdID(String memobirdID) {
		this.memobirdID = memobirdID;
	}
	public String getUseridentifying() {
		return useridentifying;
	}
	public void setUseridentifying(String useridentifying) {
		this.useridentifying = useridentifying;
	}
	public int getShowapi_res_code() {
		return showapi_res_code;
	}
	public void setShowapi_res_code(int showapiResCode) {
		showapi_res_code = showapiResCode;
	}
	public String getShowapi_res_error() {
		return showapi_res_error;
	}
	public void setShowapi_res_error(String showapiResError) {
		showapi_res_error = showapiResError;
	}
	public int getShowapi_userid() {
		return showapi_userid;
	}
	public void setShowapi_userid(int showapiUserid) {
		showapi_userid = showapiUserid;
	}
	@Override
	public String toString() {
		return "user [memobirdID=" + memobirdID + ", showapi_res_code="
				+ showapi_res_code + ", showapi_res_error=" + showapi_res_error
				+ ", showapi_userid=" + showapi_userid + ", useridentifying="
				+ useridentifying + ", getMemobirdID()=" + getMemobirdID()
				+ ", getShowapi_res_code()=" + getShowapi_res_code()
				+ ", getShowapi_res_error()=" + getShowapi_res_error()
				+ ", getShowapi_userid()=" + getShowapi_userid()
				+ ", getUseridentifying()=" + getUseridentifying()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
