package com.packt.datastructuresandalg.lesson3.activity.project;

import java.util.TreeMap;

public class MemberDataNewSolution {
	
	private TreeMap<String, MemberAccountNew> accounts;
	
	public MemberDataNewSolution() {
		super();
		accounts = new TreeMap<>();
	}

	public TreeMap<String, MemberAccountNew> getAccounts() {
		return accounts;
	}



	public void addAccount(MemberAccountNew account) {
		this.accounts.put(account.getLoginEmail(), account);
	}
	
	public MemberAccountNew getAccount(String loginEmail) {
		return accounts.get(loginEmail);
	}

}
