package com.leezu.web.notice.entity;

import java.util.Date;

public class NoticeView {
	private int num;
	private int noticeID;
	private String title;
	private String content;
	private Date regDate;
	private Date modDate;
	private String writerID;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNoticeID() {
		return noticeID;
	}
	public void setNoticeID(int noticeID) {
		this.noticeID = noticeID;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getWriterID() {
		return writerID;
	}
	public void setWriterID(String writerID) {
		this.writerID = writerID;
	}
	public NoticeView(int num, int noticeID, String title, String content, Date regDate, Date modDate,
			String writerID) {
		super();
		this.num = num;
		this.noticeID = noticeID;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
		this.writerID = writerID;
	}
	
	
}
