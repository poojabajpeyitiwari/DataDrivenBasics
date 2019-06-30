package com.test.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.page.objects.LandingFacebookPage;
import com.page.objects.LoginPage;
import com.test.resources.Base;

public class HomePageTest extends Base {
	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		initializeDriver();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("bajpeyipooja@gmail.com");
		lp.getPassword().sendKeys("jc_306671y");
		Thread.sleep(3000);
		lp.getLogin().click();
		//driver.switchTo().alert().dismiss();
	
		LandingFacebookPage fp = new LandingFacebookPage(driver);
		fp.getProfile().click();
		//WebElement sendIssue=fp.getprofilePhoto();
		/*WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(fp.getprofilePhoto()));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", fp.getprofilePhoto());
		fp.getprofilePhoto().click();
		//sendIssue.click();
*/		
		driver.get("https://www.facebook.com/photo.php?fbid=1453425114717847&set=a.134941086566263&type=3&source=11&referrer_profile_id=100001511186503");
		}
	/*@AfterTest
	public void tearDown(){
		driver.close();
*/
	//}
}
