package com.econvergance.testng;



import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginSuccessHandler {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  private boolean isElementPresent1(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent1() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;}
	    }
	  

	  private String closeAlertAndGetItsText1() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
  
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  /* 
   * To test the login functionality of the server
   * */
  @Parameters({"serverURL","loginEmail","password"})
  @Test
  public void isLoginSuccess(String serverURL, String loginEmail, String password) throws Exception {
    driver.get(serverURL + "/");
    driver.findElement(By.id("login_password")).clear();
    driver.findElement(By.id("login_password")).sendKeys(password);
    driver.findElement(By.id("login_username")).clear();
    driver.findElement(By.id("login_username")).sendKeys(loginEmail);
    driver.findElement(By.id("login-submit")).click();
    assertTrue(isElementPresent1(By.cssSelector("li.non-link")));
    assertTrue(isElementPresent1(By.id("divPageTitle")));
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.xpath(".//*[@id='top-header']/div[2]/ul/li[1]/a/span[1]")).click();
    driver.findElement(By.linkText("logout")).click();
  }

  
  
  @AfterClass(alwaysRun = true)
  public void tearDown1() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


}
  


 
