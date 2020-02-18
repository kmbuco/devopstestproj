package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//http://34.69.4.133:8082/content/about-us.php
public class TestAboutPage {
	WebDriver driver;

	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver","/var/lib/jenkins/workspace/chromedriver");
		ChromeOptions chromeOptions= new ChromeOptions();
    	chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		driver.get("http://34.69.4.133:8082/content/about-us.php");
		driver.manage().window().maximize();
	}

	@Test
	public void verify() {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/p[1]/b")).getText(), "about");
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
