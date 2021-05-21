package com.ssafy.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "보드 정보")
public class BoardDto {
	@ApiModelProperty(value = "post, notice boardid")
	int boardid;
	String title;
	String userid;
	String time;
	String content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BoardDto [boardid=" + boardid + ", title=" + title + ", userid=" + userid + ", time=" + time
				+ ", content=" + content + ", getNo()=" + getNo() + ", getTitle()=" + getTitle() + ", getUserid()="
				+ getUserid() + ", getTimestamp()=" + getTimestamp() + ", getContent()=" + getContent()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
