package com.cg.mra.ui;


import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountserviceImpl;



public class Main {
    
    @SuppressWarnings("resource")
	public static void main(String args[]) {
        AccountService service = new AccountserviceImpl();
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        int ch = 0;
        do{
        System.out.println("\nEnter Choice :\n");
        System.out.println("1. Get Account Details :\n");
        System.out.println("2. Recharge Account :\n");
        System.out.println("3. Exit\n");
        ch = sc.nextInt();
        switch(ch) {
        case 1:
            System.out.println("Enter Mobile No:");
            String mobileno = sc.next();
            
            account = service.getAccountDetails(mobileno);
            if(account == null)
                System.out.println("ERROR: Given Account Id Does Not Exists");
            else{
                
                    
                    System.out.println("Your Current Balance is Rs." +account.getAccountBalance());
                }
            
                break;
        case 2:
            System.out.println("Enter Mobile No:");
            mobileno = sc.next();
            System.out.println("Enter Recharge Amount");
            double rechargeAmount = sc.nextDouble();
            account = service.getAccountDetails(mobileno);
            double recharge = service.rechargeAccount(mobileno, rechargeAmount);
            if(account == null){
                System.out.println("ERROR: Cannot Recharge Account as Given Mobile No Does Not Exists");
            }
            else{
                account.setAccountBalance(account.getAccountBalance());
                System.out.println("Your Account Recharged Successfully");
                System.out.println("Hello "+account.getCustomerName() + ","+"Available Balance is "+account.getAccountBalance());
                
            }
            break;
        case 3:
            exit(0);
           break;
            
            }
        
            
        }while(ch!=3);
        
    }

    private static String exit(int i) {
        // TODO Auto-generated method stub
        return null;
    }

}

