package com.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
	WebDriver driver;
	By searchBar= By.xpath("//input[@name='q']");
	
	public GooglePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getSearch(){
		return driver.findElement(searchBar);
	}

}
