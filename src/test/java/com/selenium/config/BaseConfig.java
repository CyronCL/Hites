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

  public RemoteWebDriver driver;

  @BeforeMethod()
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
        driver = new RemoteWebDriver(URI.create("http://127.0.0.1:4444/wd/hub").toURL(), browser);
        driver.manage().window().maximize();
        driver.get("https://www.sodimac.cl/sodimac-cl/");
      } catch (MalformedURLException e) {
        System.out.println("error " + e.getMessage());
        e.printStackTrace();
      }
    }
    return driver;
  }
  

  @AfterMethod()
  public void teardownTest() {
    // Close browser and end the session
    driver.quit();
  }
}
