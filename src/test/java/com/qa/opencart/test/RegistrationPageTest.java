package com.qa.opencart.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{
	
	
//	@DataProvider
//	public Object[][] getData(){
//		return new Object[][] {
//			{"Ram","M"},{"Laxman","M"}
//		};
//}
	

	@DataProvider
	public Object[][] getDataFromExcel() {
		Object regData[][] = ExcelUtil.getTestData("data1");
		return regData;
	}	

@Test(dataProvider="getDataFromExcel")
public void getData(String name , String gender , String age , String mob) {
	System.out.println(name +"---"+gender+"---"+age+"---"+mob);
}


}