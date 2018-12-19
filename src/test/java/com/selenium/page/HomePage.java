package com.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.config.BaseConfig;

public class HomePage extends BaseConfig {

  public HomePage(RemoteWebDriver driver) {
    super();
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  //create Element 
  
  @FindBy(id = "searchBoxInput")
  private WebElement searchBoxInpt; 
  
  @FindBy(xpath = "//div[@class='searchIcon_-xI-Ide9']")
  private WebElement searchIconBtn; 
  
  @FindBy(xpath = "(//*[@onclick='closePopUp();'])[2]")
  private WebElement cerrar;
  
  //create method
  
  public PDPPage searchSKU(String producto) {
    searchBoxInpt.sendKeys(producto);
    searchIconBtn.click();
    return new PDPPage(driver);
  }
  
  public PDPPage searchProduct() {
    searchBoxInpt.sendKeys("111338-0");
    searchIconBtn.click();
    return new PDPPage(driver);
 }
  public void cerrar()
  {
	  
	   cerrar.click();
	  
	    }  
}
