package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
//	@Description("accounts Page Title Test")
//	@Severity(SeverityLevel.NORMAL)
	public void accountsPageTitleTest() {
		String actAccountPageTitle = accPage.getAccountsPageTitle();
		System.out.println("Acc page title : " + actAccountPageTitle);
		Assert.assertEquals(actAccountPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test
//	@Description("accounts Page header Test")
//	@Severity(SeverityLevel.NORMAL)
	public void accPageHeaderTest() {
		Assert.assertTrue(accPage.isAccountsPageHeaderExist());
	}

	@Test
//	@Description("search Exist Test")
//	@Severity(SeverityLevel.CRITICAL)
	public void searchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}

	@Test
//	@Description("acc Sections Test")
//	@Severity(SeverityLevel.NORMAL)
	public void accSectionsTest() {
		List<String> actSecList = accPage.getAccountsPageSectionsList();
		System.out.println("Accounts Sections list = " + actSecList);
		Assert.assertEquals(actSecList, Constants.ACCOUNTS_SECTIONS_LIST);
	}

//	@Test
//	@Description("Search Header Test")
//	@Severity(SeverityLevel.NORMAL)
//	public void searchHeaderTest() {
//		searchResultsPage = accPage.doSearch("Macbook");
//		String actSearchHeader = searchResultsPage.getResultsPageHeaderValue();
//		Assert.assertTrue(actSearchHeader.contains("Macbook"));
//	}

//	@Test
//	@Description("check product count test after search")
//	@Severity(SeverityLevel.CRITICAL)
//	public void searchProductCountTest() {
//		searchResultsPage = accPage.doSearch("iMac");
//		int actProductCount = searchResultsPage.getProductSearchCount();
//		Assert.assertEquals(actProductCount, Constants.IMAC_PRODUCT_COUNT);
//	}

	//@Test
//	@Description("check product list test after search")
//	@Severity(SeverityLevel.CRITICAL)
//	public void getSearchProductListTest() {
//		searchResultsPage = accPage.doSearch("iMac");
//		List<String> actProductList = searchResultsPage.getProductResultsList();
//		System.out.println(actProductList);
//	}

	
}
