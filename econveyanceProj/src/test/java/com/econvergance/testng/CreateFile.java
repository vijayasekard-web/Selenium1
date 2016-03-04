package com.econvergance.testng;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFile {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@Parameters({"serverURL","adminLoginEmail","adminPassword"})
	@BeforeClass(alwaysRun = true)
	public void setUp (String serverURL, String loginEmail, String password) throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(serverURL);
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys(password);
		driver.findElement(By.id("login_username")).clear();
		driver.findElement(By.id("login_username")).sendKeys(loginEmail);
		driver.findElement(By.id("login-submit")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Parameters ({"lawyername", "filenumber", "filetype"})
	@Test
	public void testCreatefile(String lawyerName, String fileNumber, String fileType ) throws Exception {


		driver.findElement(By.linkText("FILE")).click();
		driver.findElement(By.linkText ("Create File")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("ec_file_lawyer_file_number")).clear();
		driver.findElement(By.id("ec_file_lawyer_file_number")).sendKeys(fileNumber);
		Select droplist2 = new Select(driver.findElement(By.id("ec_file_lawyer_individual_id")));   
		droplist2.selectByVisibleText(lawyerName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select droplist1 = new Select(driver.findElement(By.id("new_file_param_lawyer_type")));   
		droplist1.selectByVisibleText(fileType);  
		driver.findElement(By.xpath("(//a[contains(text(),'Next')])[2]")).click();
		assertTrue(isElementPresent(By.cssSelector("li.non-link")));
		assertTrue(isElementPresent(By.id("divPageTitle")));
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
