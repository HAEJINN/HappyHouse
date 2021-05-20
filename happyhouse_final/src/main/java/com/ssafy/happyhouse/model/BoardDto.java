package com.ssafy.happyhouse.model;

public class BoardDto {
	int boardid;
	String title;
	String userid;
	String time;
	public int getNo() {
		return boardid;
	}
	public void setNo(int no) {
		this.boardid = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTimestamp() {
		return time;
	}
	public void setTimestamp(String timestamp) {
		this.time = timestamp;
	}
	@Override
	public String toString() {
		return "BoardDto [no=" + boardid + ", title=" + title + ", userid=" + userid + ", timestamp=" + time
				+ ", getNo()=" + getNo() + ", getTitle()=" + getTitle() + ", getUserid()=" + getUserid()
				+ ", getTimestamp()=" + getTimestamp() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
