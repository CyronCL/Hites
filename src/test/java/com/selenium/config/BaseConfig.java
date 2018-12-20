package com.selenium.config;

import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseConfig {

  public WebDriver driver;

  @BeforeMethod()/*
   public RemoteWebDriver getDriver() throws Exception {
    if (driver == null) {

      DesiredCapabilities browser = new DesiredCapabilities();
      

      browser.setBrowserName("chrome");
      browser.setVersion("latest");
      browser.setCapability("name", "https://www.sodimac.cl/sodimac-cl/" + " Test:" + getClass().getSimpleName());
      browser.setCapability("enableVNC", true);
      browser.setCapability("enableVideo", false);
      browser.setCapability ("webdriver.chrome.verboseLogging", true);
      browser.setCapability ("--no-sandbox",true);
      browser.setCapability ("--disable-dev-shm-usage",true);
      try {
        driver = new RemoteWebDriver(URI.create("http://192.168.1.110:4444/wd/hub").toURL(), browser);
        driver.manage().window().maximize();
        driver.get("https://www.sodimac.cl/sodimac-cl/");
      } catch (MalformedURLException e) {
        System.out.println("error " + e.getMessage());
        e.printStackTrace();
      }
    }
    return driver;
  }*/
  
  
  public void getDriver() {
	
    System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
    ChromeOptions option = new ChromeOptions();
    option.addArguments("--headless");    
    option.addArguments("--disable-dev-shm-usage");
    option.addArguments("--no-sandbox");
    driver = new ChromeDriver(option);
    //
    driver.manage().deleteAllCookies();
    driver.navigate().to("https://www.sodimac.cl/sodimac-cl/");
    //
    
    System.out.println("Successfully opened the website https://www.sodimac.cl/sodimac-cl/");
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod()
  public void teardownTest() {
    // Close browser and end the session
    driver.quit();
  }
}
