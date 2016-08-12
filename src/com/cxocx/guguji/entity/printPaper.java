package com.cxocx.guguji.entity;

/**
 * 纸条打印回执对象
 * @author DIMON
 *
 */
public class printPaper {
	private int showapi_res_code; //返回标志，1 为成功，其他为失败。 
	private String showapi_res_error;//Ak 错误信息的显示  如:AK不正确
	private int result; //返回标志，1 为已打印，其他为未打印。 
	private String smartGuid;//返回打印设备编号
	private String printcontentID; //返回打印内容的唯一 ID 
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
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getPrintcontentID() {
		return printcontentID;
	}
	public void setPrintcontentID(String printcontentID) {
		this.printcontentID = printcontentID;
	}
	public String getSmartGuid() {
		return smartGuid;
	}
	public void setSmartGuid(String smartGuid) {
		this.smartGuid = smartGuid;
	}
	@Override
	public String toString() {
		return "printPaper [printcontentID=" + printcontentID + ", result="
				+ result + ", showapi_res_code=" + showapi_res_code
				+ ", showapi_res_error=" + showapi_res_error + ", smartGuid="
				+ smartGuid + ", getPrintcontentID()=" + getPrintcontentID()
				+ ", getResult()=" + getResult() + ", getShowapi_res_code()="
				+ getShowapi_res_code() + ", getShowapi_res_error()="
				+ getShowapi_res_error() + ", getSmartGuid()=" + getSmartGuid()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
