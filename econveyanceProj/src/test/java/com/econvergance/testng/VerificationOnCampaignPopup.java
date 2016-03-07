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

public class VerificationOnCampaignPopup {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  
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
		
		//This line is only for test3, when using other url, comment it out
		driver.findElement(By.linkText("ECONVEYANCE")).click();
	}

  @Test
  public void testUntitled() throws Exception {
	  
	driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/ul/li[2]/a/span[1]")).click();  
    driver.findElement(By.linkText("admin")).click();
    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div[1]/div/ul[1]/li[7]/a/span")).click();
    driver.findElement(By.linkText("Marketing Campaigns")).click();
    AssertJUnit.assertTrue(isElementPresent(By.id("divPageTitle")));
    AssertJUnit.assertTrue(isElementPresent(By.xpath("//div[@id='divCampaignList']/div/ul/li/a/span")));
    AssertJUnit.assertTrue(isElementPresent(By.xpath("//table[@id='table_campaign_list']/tbody/tr/th[2]")));
    AssertJUnit.assertTrue(isElementPresent(By.xpath("//table[@id='table_campaign_list']/tbody/tr/th[3]")));
    AssertJUnit.assertTrue(isElementPresent(By.xpath("//table[@id='table_campaign_list']/tbody/tr/th[4]")));
    AssertJUnit.assertTrue(isElementPresent(By.xpath("//table[@id='table_campaign_list']/tbody/tr/th[5]")));
    AssertJUnit.assertTrue(isElementPresent(By.xpath("//table[@id='table_campaign_list']/tbody/tr/th[6]")));
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    
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

  
}








/*Toggle To Admin Site:
#navigate to admin site

Verifications on Campaigns Page:
#navigate to marketing campaign page
#verify the heading says "Marketing Campaigns"
#verify the tab name is "Campaigns"
#verify there is a link for Add New Campaign 
#verify there is a Campaign Name Column 
#verify there is a Start Date Column 
#verify there is a End Date Column 
#verify there is an Is Visible Column 
#verify there is an Editions Column 
#verify there is an Action Column
*/