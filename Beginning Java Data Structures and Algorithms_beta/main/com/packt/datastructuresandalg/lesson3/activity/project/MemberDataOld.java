package com.packt.datastructuresandalg.lesson3.activity.project;

import java.util.ArrayList;

public class MemberDataOld {
	
	private ArrayList<MemberAccountOld> accountsList;
	private ArrayList<String> emailList;
	
	

	public MemberDataOld() {
		super();
		accountsList = new ArrayList();
		emailList = new ArrayList();
	}
		
	public void addAccount(MemberAccountOld account) {
		this.accountsList.add(account);
		this.emailList.add(account.getLoginEmail());
	}
	
	public MemberAccountOld getAccount(String email) {
		int index = emailList.indexOf(email);
		return accountsList.get(index);
	}

}
