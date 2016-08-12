package com.cxocx.guguji.entity;
/**
 * 获取纸条打印状态
 * @author DIMON
 */
public class printStatus {
	private String printcontentid;//传入打印内容唯一ID
	private int showapi_res_code; //返回标志，1 为成功，其他为失败。
	private String showapi_res_error;//Ak 错误信息的显示
	private int printflag;//返回标志，1 为已打印，其他为未打印。
	private String printcontentID;//返回传出打印内容的唯一 ID
	public String getPrintcontentid() {
		return printcontentid;
	}
	public void setPrintcontentid(String printcontentid) {
		this.printcontentid = printcontentid;
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
	public int getPrintflag() {
		return printflag;
	}
	public void setPrintflag(int printflag) {
		this.printflag = printflag;
	}
	public String getPrintcontentID() {
		return printcontentID;
	}
	public void setPrintcontentID(String printcontentID) {
		this.printcontentID = printcontentID;
	}
	@Override
	public String toString() {
		return "printStatus [printcontentID=" + printcontentID
				+ ", printcontentid=" + printcontentid + ", printflag="
				+ printflag + ", showapi_res_code=" + showapi_res_code
				+ ", showapi_res_error=" + showapi_res_error
				+ ", getPrintcontentID()=" + getPrintcontentID()
				+ ", getPrintcontentid()=" + getPrintcontentid()
				+ ", getPrintflag()=" + getPrintflag()
				+ ", getShowapi_res_code()=" + getShowapi_res_code()
				+ ", getShowapi_res_error()=" + getShowapi_res_error()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
