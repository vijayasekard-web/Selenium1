package test.java.com.econvergance.testng;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DocumentManagerSuccessHandler {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();
  
  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

    @Parameters({"serverURL","adminLoginEmail","adminPassword"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String serverURL, String loginEmail, String password) throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(serverURL);
    driver.findElement(By.id("login_password")).clear();
    driver.findElement(By.id("login_password")).sendKeys(password);
    driver.findElement(By.id("login_username")).clear();
    driver.findElement(By.id("login_username")).sendKeys(loginEmail);
    driver.findElement(By.id("login-submit")).click();
    //driver.findElement(By.linkText("ECONVEYANCE")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDocManager() throws Exception {
    
    driver.findElement(By.linkText("TestingEFS")).click();
    driver.findElement(By.linkText("DOCUMENT MANAGER")).click();
    driver.findElement(By.linkText("Select Documents")).click();
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.xpath(".//*[@id='155']/td[1]/div")).click();
    driver.findElement(By.xpath(".//*[@id='tabSelect']/table/tbody/tr[2]/td[2]/div/input[2]")).click();
    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[1]/table/tbody/tr[2]/td[3]/div/div/div[7]/table/tbody/tr/td[1]/div")).click();
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.className("generate_now_logo")).click();
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.linkText("Parameters Required...")).click();
    driver.findElement(By.id("634__cInvoiceNumber")).clear();
    driver.findElement(By.id("634__cInvoiceNumber")).sendKeys("2413543432132");
    driver.findElement(By.id("25470__dyear")).click();
    driver.findElement(By.id("25470__dyear")).clear();
    driver.findElement(By.cssSelector("select.ui-datepicker-month")).click();
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
    driver.findElement(By.cssSelector("a.ui-state-default.ui-state-hover")).click();
    driver.findElement(By.id("635__lcomp_date")).click();
    driver.findElement(By.xpath("html/body/div[4]/div[4]/form/div[5]/a[1]")).click();
    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/ul/li[3]/a/span")).click();
   
    try {
        assertTrue(driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/div/div[3]/div/div/div[7]/table/tbody/tr[1]/td[2]/div/a")).isDisplayed());
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
      driver.findElement(By.linkText("Account Buyer")).click();
      
      
    
    try {
      assertTrue(isAlertPresent());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
   driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


}
