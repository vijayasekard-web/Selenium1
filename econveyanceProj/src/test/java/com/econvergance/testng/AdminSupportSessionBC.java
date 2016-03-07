package test.java.com.econvergance.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminSupportSessionBC {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  /*@BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://portal-test3.econveyancepro.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  */  
    
	@BeforeMethod
	@Parameters({"serverURL","loginEmail","password"})
	@BeforeClass(alwaysRun = true)
	
	public void setUp (String serverURL, String loginEmail, String password) throws Exception {
		driver = (WebDriver) new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(serverURL);
		driver.findElement(By.id("login_password")).clear();
		driver.findElement(By.id("login_password")).sendKeys(password);
		driver.findElement(By.id("login_username")).clear();
		driver.findElement(By.id("login_username")).sendKeys(loginEmail);
		driver.findElement(By.id("login-submit")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("ECONVEYANCE")).click();
	}
    

  @Test
  public void testUntitled() throws Exception {
    /*driver.get(baseUrl + "/");
    driver.findElement(By.id("login_username")).clear();
    driver.findElement(By.id("login_username")).sendKeys("pd18611");
    driver.findElement(By.id("login_password")).clear();
    driver.findElement(By.id("login_password")).sendKeys("WeAreGreat12");
    driver.findElement(By.id("login-submit")).click();
    driver.findElement(By.linkText("ECONVEYANCE")).click();
    */
    
    driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/ul/li[2]/a/span[1]")).click();
    driver.findElement(By.linkText("admin")).click();
    driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/ul/li[2]/a/span[1]")).click();
    driver.findElement(By.linkText("start support session")).click();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("student law");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.xpath("html/body/div[4]/div[4]/div/div[2]/div/div/div[8]/div/input[2]")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.xpath("html/body/div[4]/div[4]/div/div[2]/div/div/div[7]/table/tbody/tr[1]/td[1]/div/a")).click();
    AssertJUnit.assertTrue(isElementPresent(By.xpath("html/body/div[1]/div[1]/div[1]/ul/li[1]/span")));
    AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='top-header']/div/ul/li[2]")));
  
    
  }

  @AfterMethod
@AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
	driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/ul/li[1]/a/span[1]")).click();
	driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/ul/li[1]/ul/li[2]/a")).click();
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
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

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
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
}
