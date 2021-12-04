package com.packt.datastructuresandalg.lesson3.activity.project;

import java.util.LinkedList;

public class MemberAccountOld {
	
	private String loginEmail;
	private String password;
	private long memberID;
	private LinkedList<Long> watchedList; //will contained id of watched videos
	
	
	
	public MemberAccountOld(String loginEmail, String password, long memberID) {
		super();
		this.loginEmail = loginEmail;
		this.password = password;
		this.memberID = memberID;
		this.watchedList = new LinkedList<>();
	}

	public String getLoginEmail() {
		return loginEmail;
	}
	
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getMemberID() {
		return memberID;
	}
		
	public LinkedList<Long> getWatchedList() {
		return watchedList;
	}
	
	public void addWatchedVideo(Long watchedVideoID) {
		watchedList.add(watchedVideoID);
	}
		
}
