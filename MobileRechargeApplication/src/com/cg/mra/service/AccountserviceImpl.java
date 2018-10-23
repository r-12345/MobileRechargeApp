package com.cg.mra.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.MobileRechargeException;

public class AccountserviceImpl implements AccountService {

	AccountDao dao;
	
	public AccountserviceImpl() {
		// TODO Auto-generated constructor stub
		dao = new AccountDaoImpl();
	}
	
	@Override
	public Account getAccountDetails(String mobileNo) {
		// TODO Auto-generated method stub
		
		return dao.getAccountDetails(mobileNo);
	}

	@Override
	public double rechargeAccount(String mobileNo, Double rechargeAmount) {
		// TODO Auto-generated method stub
		return dao.rechargeAccount(mobileNo, rechargeAmount);
	}

	@Override
	public boolean validateMobileNo(String mobileNo) throws MobileRechargeException {
		// TODO Auto-generated method stub
		 if(mobileNo == null)
	            throw new MobileRechargeException("Null value found");
	        Pattern p = Pattern.compile("[6789][0-9]{9}");
	        Matcher m = p.matcher(mobileNo);
	        return m.matches();
	}

	@Override
	public boolean validateRechargeAmount(Double rechargeAmount) {
		// TODO Auto-generated method stub
		if(rechargeAmount == null)
            throw new MobileRechargeException("Null value found");
        String ra = rechargeAmount.toString();
        return (ra.matches("\\d{2,9}\\.\\d{0,4}"));
	}
	
	
	
	

}
