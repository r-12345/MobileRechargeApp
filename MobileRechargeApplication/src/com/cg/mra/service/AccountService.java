package com.cg.mra.service;

import com.cg.mra.beans.Account;

public interface AccountService {

	public Account getAccountDetails(String mobileNo);
	public double rechargeAccount(String mobileNo, Double rechargeAmount);
	
	boolean validateMobileNo(String mobileNo);
	boolean validateRechargeAmount(Double rechargeAmount);
	

}
