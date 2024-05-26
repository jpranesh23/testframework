package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest{

	@Test
	public void getTitle() {
		String acttitle = loginPage.getLoginPageTitle();
		System.out.println("Page title is = "+acttitle);
		Assert.assertEquals(acttitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void loginPageURL() {
		String loginPageURL = loginPage.getLoginPageUrl();
		Assert.assertEquals(loginPageURL, Constants.LOGIN_PAGE_URL);
	}
	
	@Test
	public void doLogin() {
		loginPage.doLogin(prop.getProperty("UN"), prop.getProperty("PWD"));
	}
	
	@DataProvider
	public Object[][] getDataForLoginTest() {
		return new Object[][] {
			{"Nitesh",123455,"Yes"},
			{"RAM",765447,"Yes"}
		};
	}
	
	@Test(dataProvider="getDataForLoginTest")	
	public void isRegisterLinkExist(String Name,String PhoneNumber,String YesOrNo) {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	
	
	
	
}
