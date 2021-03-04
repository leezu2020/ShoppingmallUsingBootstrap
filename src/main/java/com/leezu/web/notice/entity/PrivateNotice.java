package com.leezu.web.notice.entity;

import java.util.Date;

public class PrivateNotice {
	private String content;
	private Date regDate;
	
	public PrivateNotice() {
		// TODO Auto-generated constructor stub
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

	public PrivateNotice(String content, Date regDate) {
		super();
		this.content = content;
		this.regDate = regDate;
	}


	
}
