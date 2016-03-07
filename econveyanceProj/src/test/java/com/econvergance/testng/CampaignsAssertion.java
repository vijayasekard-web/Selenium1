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

public class CampaignsAssertion {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod
@BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://portal-test3.econveyancepro.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled2() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("login_password")).clear();
    driver.findElement(By.id("login_password")).sendKeys("WeAreGreat11");
    driver.findElement(By.id("login_username")).clear();
    driver.findElement(By.id("login_username")).sendKeys("pd18611");
    driver.findElement(By.id("login_password")).clear();
    driver.findElement(By.id("login_password")).sendKeys("WeAreGreat12");
    driver.findElement(By.id("login-submit")).click();
    driver.findElement(By.linkText("ECONVEYANCE")).click();
    driver.findElement(By.linkText("Create File")).click();
    new Select(driver.findElement(By.id("ec_file_lawyer_individual_id"))).selectByVisibleText("Betts, Rebecca");
    driver.findElement(By.id("ec_file_lawyer_file_number")).clear();
    driver.findElement(By.id("ec_file_lawyer_file_number")).sendKeys("543513246");
    driver.findElement(By.id("new_file_param_lawyer_type")).click();
    new Select(driver.findElement(By.id("new_file_param_lawyer_type"))).selectByVisibleText("Buyer");
    driver.findElement(By.linkText("Seller Lawyer / Notary")).click();
    driver.findElement(By.id("txt_find_other_side_individual")).clear();
    driver.findElement(By.id("txt_find_other_side_individual")).sendKeys("shirr");
    driver.findElement(By.id("ui-active-menuitem")).click();
    driver.findElement(By.id("jqi_state0_buttonAdd")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Next')])[2]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Cancel')])[2]")).click();
    AssertJUnit.assertTrue(driver.findElement(By.cssSelector("#ad > span")).isDisplayed());
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