package com.ssafy.happyhouse.model;

public class NewsDto {
	String title;
	String url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "NewsDto [title=" + title + ", url=" + url + "]";
	}
}
