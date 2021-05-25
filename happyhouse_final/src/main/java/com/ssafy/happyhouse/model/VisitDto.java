package com.ssafy.happyhouse.model;

public class VisitDto {
	String time;
	int cnt;
	@Override
	public String toString() {
		return "VisitDto [time=" + time + ", cnt=" + cnt + "]";
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
