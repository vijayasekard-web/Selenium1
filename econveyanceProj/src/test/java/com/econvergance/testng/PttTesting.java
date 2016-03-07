package test.java.com.econvergance.testng;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

  public class PttTesting {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	@Parameters({"serverURL","loginEmail","password"})
	
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
    @Parameters ({"lawyername", "filenumber", "username"})
	@Test

	public void testCreatefile(String lawyerName, String fileNumber, String username) throws Exception {

	  
    
    driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/ul/li[2]/a/span[1]")).click();
    driver.findElement(By.linkText("ON")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div[2]/div/ul/li[4]/a/span")).click();
	driver.findElement(By.xpath ("html/body/div[1]/div[2]/div[1]/div[2]/div/ul/li[4]/ul/li[1]/a")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.id("ec_file_lawyer_file_number")).clear();
	driver.findElement(By.id("ec_file_lawyer_file_number")).sendKeys(fileNumber);
	Select droplist2 = new Select(driver.findElement(By.id("ec_file_lawyer_individual_id")));   
	droplist2.selectByVisibleText(lawyerName);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Select droplist1 = new Select(driver.findElement(By.id("new_file_param_lawyer_type")));   
	droplist1.selectByVisibleText("Purchase");  
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("(//a[contains(text(),'Next')])[2]")).click();
	
	//this next line is for the file number that already exists
	driver.findElement(By.id("jqi_state0_buttonYes")).click();
	username = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/ul/li[1]")).getText();
	AssertJUnit.assertEquals(username, username);
	System.out.print("\n -> User logged in");
  
    driver.findElement(By.id("mortgage_list")).click();
    driver.findElement(By.linkText("Corporate Lender")).click();
    driver.findElement(By.linkText("Corporate Name")).click();
    driver.findElement(By.id("txt_find_lender_corporation")).clear();
    driver.findElement(By.id("txt_find_lender_corporation")).sendKeys("td");
    
    driver.findElement(By.id("ui-active-menuitem")).click();
    driver.findElement(By.id("jqi_state0_buttonAdd")).click();
    driver.findElement(By.id("jqi_state0_buttonAcknowledged and Agreed")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    driver.findElement(By.xpath(".//html/body/div[4]/div[4]/form/div[5]/a[1]|.//*html/body/div[4]/div[4]/form/div[3]/a[1]")).click();
    //driver.findElement(By.xpath(".//*[@id='buttons buttons_bottom']//*[class='clickOnce']|.//*[@id='buttons buttons_top']//*[class='clickOnce']")).click();
    //driver.findElement(By.xpath(".//*[@id='divContentInPopup']//*[class='clickOnce']|.//*[@id='divContentInPopup']/html/body/div[4]/div[4]/form/div[5]/a[1]")).click();
   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    new Select(driver.findElement(By.id("mortgage_rank"))).selectByVisibleText("First");
    driver.findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div[4]/form/div[5]/a[1]")).click();
    /*driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.clickOnce.check_and_submit")).click();
    driver.findElement(By.id("jqi_state0_buttonOK")).click();
    driver.findElement(By.id("property_list")).click();
    driver.findElement(By.linkText("Add New Property")).click();
    driver.findElement(By.id("property_pid")).clear();
    driver.findElement(By.id("property_pid")).sendKeys("002-003-004");
    driver.findElement(By.id("property_legal")).clear();
    driver.findElement(By.id("property_legal")).sendKeys("lot 45, plan 1");
    driver.findElement(By.id("property_suite")).clear();
    driver.findElement(By.id("property_suite")).sendKeys("1080");
    driver.findElement(By.id("property_street")).clear();
    driver.findElement(By.id("property_street")).sendKeys("1104");
    driver.findElement(By.id("property_country")).clear();
    driver.findElement(By.id("property_country")).sendKeys("Canada");
    driver.findElement(By.linkText("Save")).click();
    driver.findElement(By.xpath("//div[@id='divPropertyTabs']/ul/li[2]/a/span")).click();
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.rememberTab.editProperty")).click();
    driver.findElement(By.id("property_purchase_price")).clear();
    driver.findElement(By.id("property_purchase_price")).sendKeys("200000");
    driver.findElement(By.id("btnCopyPurchasePriceToConsideration")).click();
    driver.findElement(By.linkText("Save")).click();
    driver.findElement(By.xpath("//div[@id='divPropertyTabs']/ul/li[3]/a/span")).click();
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.rememberTab.editProperty")).click();
    driver.findElement(By.id("btnCalculatePTT")).click();
    driver.findElement(By.linkText("Save")).click();
    driver.findElement(By.xpath("//div[@id='divPropertyTabs']/ul/li[2]/a/span")).click();
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.rememberTab.editProperty")).click();
    driver.findElement(By.id("property_purchase_price")).clear();
    driver.findElement(By.id("property_purchase_price")).sendKeys("310000");
    driver.findElement(By.id("btnCopyPurchasePriceToConsideration")).click();
    driver.findElement(By.linkText("Save")).click();
    driver.findElement(By.xpath("//div[@id='divPropertyTabs']/ul/li[3]/a/span")).click();
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.rememberTab.editProperty")).click();
    driver.findElement(By.id("btnCalculatePTT")).click();
    driver.findElement(By.linkText("Save")).click();
    driver.findElement(By.xpath("//div[@id='divPropertyTabs']/ul/li[2]/a/span")).click();
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.rememberTab.editProperty")).click();
    driver.findElement(By.id("tabPriceAndGST")).click();
    driver.findElement(By.id("property_purchase_price")).clear();
    driver.findElement(By.id("property_purchase_price")).sendKeys("520000");
    driver.findElement(By.id("btnCopyPurchasePriceToConsideration")).click();
    driver.findElement(By.linkText("Save")).click();
    driver.findElement(By.xpath("//div[@id='divPropertyTabs']/ul/li[3]/a/span")).click();
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.rememberTab.editProperty")).click();
    driver.findElement(By.id("btnCalculatePTT")).click();
    driver.findElement(By.linkText("Save")).click();
    driver.findElement(By.xpath("//div[@id='divPropertyTabs']/ul/li[2]/a/span")).click();
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.rememberTab.editProperty")).click();
    driver.findElement(By.id("property_purchase_price")).clear();
    driver.findElement(By.id("property_purchase_price")).sendKeys("2000000");
    driver.findElement(By.id("btnCopyPurchasePriceToConsideration")).click();
    driver.findElement(By.linkText("Save")).click();
    driver.findElement(By.xpath("//div[@id='divPropertyTabs']/ul/li[3]/a/span")).click();
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.rememberTab.editProperty")).click();
    driver.findElement(By.id("btnCalculatePTT")).click();
    driver.findElement(By.linkText("Save")).click();
    driver.findElement(By.xpath("//div[@id='divPropertyTabs']/ul/li[2]/a/span")).click();
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.rememberTab.editProperty")).click();
    driver.findElement(By.id("property_purchase_price")).clear();
    driver.findElement(By.id("property_purchase_price")).sendKeys("2500000");
    driver.findElement(By.id("btnCopyPurchasePriceToConsideration")).click();
    driver.findElement(By.linkText("Save")).click();
    driver.findElement(By.xpath("//div[@id='divPropertyTabs']/ul/li[3]/a/span")).click();
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.rememberTab.editProperty")).click();
    driver.findElement(By.id("btnCalculatePTT")).click();
    driver.findElement(By.linkText("Save")).click();
    driver.findElement(By.linkText("DOCUMENT MANAGER")).click();
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("EFS_Form_PTT");
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    driver.findElement(By.cssSelector("td.sorted > div")).click();
    driver.findElement(By.xpath("//input[@value=' > ']")).click();
    driver.findElement(By.cssSelector("#5092476 > td > div")).click();
    driver.findElement(By.cssSelector("img.generate_now_logo")).click();
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a.clickOnce")).click();
    driver.findElement(By.id("generating_documents")).click();
    driver.findElement(By.linkText("Parameters Required...")).click();
    new Select(driver.findElement(By.id("13750__cPTTAccount"))).selectByVisibleText("Royal Bank of Canada - RBC Main - Main");
    driver.findElement(By.cssSelector("div.buttons.buttons_bottom > a")).click();
    driver.findElement(By.linkText("EFS_Form_PTT")).click();
    */
  }

  @AfterMethod
public void tearDown() throws Exception {
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
