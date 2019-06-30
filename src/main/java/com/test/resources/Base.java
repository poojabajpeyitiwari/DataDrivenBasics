package com.test.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream(
				"E:\\Homework\\Workspace\\DataDrivenMavenProject\\src\\main\\java\\data.properties");

		prop = new Properties();
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		// general chrome profile
		//DesiredCapabilities ch = new DesiredCapabilities();
		
		// add capability to our local browser
		ChromeOptions c = new ChromeOptions();
		c.addArguments("--disable-notifications");
		//c.merge(ch);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:/Homework/Workspace/DataDrivenMavenProject/Browsers/chromedriver.exe");
			driver = new ChromeDriver(c);

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"E:/Homework/Workspace/DataDrivenMavenProject/Browsers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.gecko.driver",
					"E:/Homework/Workspace/DataDrivenMavenProject/Browsers/MicrosoftWebDriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}
}
