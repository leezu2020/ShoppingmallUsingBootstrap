package com.leezu.web.notice.entity;

public class preNotice {

	private String title;
	private String content;
	private String writerID;
	
	public preNotice() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriterID() {
		return writerID;
	}

	public void setWriterID(String writerID) {
		this.writerID = writerID;
	}

	public preNotice(String title, String content, String writerID) {
		super();
		this.title = title;
		this.content = content;
		this.writerID = writerID;
	}
	
}
