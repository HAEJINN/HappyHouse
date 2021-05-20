package com.ssafy.happyhouse.model;

public class HouseInfoDto{
	int no;
	String dong;
	String aptname;
	String code;
	String buildyear;
	String jibun;
	String lat;
	String lng;
	String dealamount; 
	String area;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptname() {
		return aptname;
	}
	public void setAptname(String aptname) {
		this.aptname = aptname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBuildyear() {
		return buildyear;
	}
	public void setBuildyear(String buildyear) {
		this.buildyear = buildyear;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getDealamount() {
		return dealamount;
	}
	public void setDealamount(String dealamount) {
		this.dealamount = dealamount;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "HouseInfoDto [no=" + no + ", dong=" + dong + ", aptname=" + aptname + ", code=" + code + ", buildyear="
				+ buildyear + ", jibun=" + jibun + ", lat=" + lat + ", lng=" + lng + ", dealamount=" + dealamount
				+ ", area=" + area + "]";
	}
	
}