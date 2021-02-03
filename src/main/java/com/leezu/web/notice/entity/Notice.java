package com.leezu.web.notice.entity;

import java.util.Date;

public class Notice {
	private int noticeID;
	private String title;
	private String content;
	private Date regDate;
	private Date modDate;
	private String writerID;
	
	public Notice() {
		// TODO Auto-generated constructor stub
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

	public Notice(int noticeID, String title, String content, Date regDate, Date modDate, String writerID) {
		super();
		this.noticeID = noticeID;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
		this.writerID = writerID;
	}

	@Override
	public String toString() {
		return "Notice [noticeID=" + noticeID + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", modDate=" + modDate + ", writerID=" + writerID + "]";
	}
	
	
}
