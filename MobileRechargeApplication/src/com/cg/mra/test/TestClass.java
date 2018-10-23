package com.cg.mra.test;
import org.junit.Assert;
import org.junit.Test;

import com.cg.mra.exception.MobileRechargeException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountserviceImpl;



public class TestClass {
    AccountService service = new AccountserviceImpl();
    boolean result;
    @Test(expected=MobileRechargeException.class)
    public void test_validateMobileNo_Null()throws MobileRechargeException{
        result = service.validateMobileNo(null);
        
    }
    
    @Test
    public void test_ValidateMobileNo_v1()throws MobileRechargeException{
        result = service.validateMobileNo("0123456789");
        Assert.assertEquals(false, result);
        
    }
    
    
    @Test
    public void test_ValidateMobileNo_v2()throws MobileRechargeException{
        result = service.validateMobileNo("8912434354dsf");
        Assert.assertEquals(false, result);
        
    }
    
    @Test
    public void test_ValidateMobileNo_v3()throws MobileRechargeException{
        result = service.validateMobileNo("8978063079");
        Assert.assertEquals(true, result);
        
    }
    
    
    @Test(expected=MobileRechargeException.class)
    public void test_ValidateRechargeAmount_Null()throws MobileRechargeException{
        result = service.validateRechargeAmount(null);
        Assert.assertEquals(false, result);
    }
    
    
    @Test
    public void test_ValidateSalary_v1()throws MobileRechargeException{
        result = service.validateRechargeAmount(250.0);
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void test_ValidateSalary_v2()throws MobileRechargeException{
        result = service.validateRechargeAmount(250000000000.0);
        Assert.assertEquals(false, result);
    }
    
    @Test
    public void test_ValidateSalary_v3()throws MobileRechargeException{
        result = service.validateRechargeAmount(2.0);
        Assert.assertEquals(false, result);
    }

    @Test
    public void test_ValidateSalary_v4()throws MobileRechargeException{
        result = service.validateRechargeAmount(250.436750);
        Assert.assertEquals(false, result);
    }
    

}

