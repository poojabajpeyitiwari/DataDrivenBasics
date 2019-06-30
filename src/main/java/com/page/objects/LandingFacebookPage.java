package com.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingFacebookPage {
	WebDriver driver;
	By profile = By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span/span");
	By profilePhoto = By.xpath("//img[@class='_11kf img']");

	public LandingFacebookPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getProfile() {
		return driver.findElement(profile);
	}

	public WebElement getprofilePhoto() {
		return driver.findElement(profilePhoto);
	}

}
