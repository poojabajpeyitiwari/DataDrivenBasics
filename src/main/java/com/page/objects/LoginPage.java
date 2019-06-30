package com.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	By username = By.xpath("//*[@id='email']");
	By password = By.xpath("//*[@id='pass']");
	By login = By.xpath("//*[@id='u_0_a']");

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getUsername() {
		return driver.findElement(username);

	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}
}
