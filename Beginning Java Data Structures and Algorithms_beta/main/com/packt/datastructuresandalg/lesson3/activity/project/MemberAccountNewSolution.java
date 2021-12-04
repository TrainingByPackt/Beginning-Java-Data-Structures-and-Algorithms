package com.packt.datastructuresandalg.lesson3.activity.project;

import java.util.TreeMap;

public class MemberAccountNewSolution {
	
	private String loginEmail;
	private String password;
	private long memberID;
	private TreeMap<Long, Long> watchedList; //will contained id of watched videos
	
	
	
	public MemberAccountNewSolution(String loginEmail, String password, long memberID) {
		super();
		this.loginEmail = loginEmail;
		this.password = password;
		this.memberID = memberID;
		this.watchedList = new TreeMap<>();
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
	
	public void addWatchedVideo(Long watchedVideoID) {
		watchedList.put(watchedVideoID, watchedVideoID);
	}
	
	public TreeMap<Long, Long> getWatchedList() {
		return this.watchedList;
	}
		
}
