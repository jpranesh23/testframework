package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

		public WebDriver driver;
		public Properties prop;
		
		/**
		 * This method is used to initialie the driver. WIll take care of both local+remote webdriver.
		 * @param browserName
		 * @return
		 */
		public WebDriver init_driver(Properties prop) {
		
			String browserName = prop.getProperty("browser");
			String URL = prop.getProperty("URL");			
	 		System.out.println("Expected browser = "+browserName);
			
			if(browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
			}else {
				System.out.println("The said browser name is incorrect. Kindly verify...!!!"+browserName);
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().window().fullscreen();
			driver.get(URL);
			return driver;
		}
		
		/**
		 * This method will load config.prop file on bases of given env and load it.
		 * ENV can be QA/DEV/PROD/UAT
		 * @return Properties
		 */
		public Properties init_prop() {
			
			prop = new Properties();
			try {
				FileInputStream fis = new FileInputStream("./scr/test/resources/config/config.properties");
				prop.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prop;
		}
}
