package com.wx.springmvc.bean;

public class Sdept {

	private String sdeptId;
	private String sdeptName;
	public String getSdeptId() {
		return sdeptId;
	}
	public void setSdeptId(String sdeptId) {
		this.sdeptId = sdeptId;
	}
	public String getSdeptName() {
		return sdeptName;
	}
	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}
	@Override
	public String toString() {
		return "Sdept [sdeptId=" + sdeptId + ", sdeptName=" + sdeptName + "]";
	}
	
}
