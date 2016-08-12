package com.cxocx.guguji.entity;
/**
 * Bing壁纸实体类
 * @author DIMON
 *
 */
public class bingWallpaper {
	private String bing_url="http://cn.bing.com/HPImageArchive.aspx?n=1&format=js&Idx=";
	private String startdate;
	private String fullstartdate;
	private String enddate;
	private String url;
	private String urlbase;
	private String copyright;
	private String copyrightlink;
	private String hsh;
	public String getBing_url() {
		return bing_url;
	}
	public String setBing_url(String bingUrl) {
		bing_url += bingUrl;
		return bing_url;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getFullstartdate() {
		return fullstartdate;
	}
	public void setFullstartdate(String fullstartdate) {
		this.fullstartdate = fullstartdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlbase() {
		return urlbase;
	}
	public void setUrlbase(String urlbase) {
		this.urlbase = urlbase;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getCopyrightlink() {
		return copyrightlink;
	}
	public void setCopyrightlink(String copyrightlink) {
		this.copyrightlink = copyrightlink;
	}
	public String getHsh() {
		return hsh;
	}
	public void setHsh(String hsh) {
		this.hsh = hsh;
	}
}
