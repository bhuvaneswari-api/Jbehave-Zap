package com.zap.md.Elements;

import com.zap.md.methods.InitializeBrowserConnectDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//This class holds all the locators in CartPage of Zap Website
public class SearchPage {
    //creating object for InitializeBrowserConnectDriver Class to use it to get the driver during initElements action in the constructor
    InitializeBrowserConnectDriver initializeBrowserConnectDriver = new InitializeBrowserConnectDriver();
    @FindBy(how = How.ID, using = "edit-keys")
    protected WebElement SearchBar;
    @FindBy(how = How.XPATH, using = ".//div[@id='title']/h1")
    protected  WebElement SearchResultHeader;
    @FindBy(how = How.XPATH, using = ".//ul[contains(@class, 'product-filter-options')]//li[1]/a")
    protected WebElement categoryAll;
    @FindBy(how = How.XPATH, using = ".//ul[contains(@class, 'product-filter-options')]//li[2]/a")
    protected WebElement category1;
    @FindBy(how = How.XPATH, using = ".//ul[contains(@class, 'product-filter-options')]//li[3]/a")
    protected WebElement category2;
    @FindBy(how = How.XPATH, using = ".//ul[contains(@class, 'product-filter-options')]//li[4]/a")
    protected WebElement category3;
    @FindBy(how = How.XPATH, using = ".//table[@class='views-view-grid']//tr[1]//td[1]")
    protected WebElement firstProductInList;
    @FindBy(how = How.XPATH, using = ".//table[@class='views-view-grid']//tr[1]//td[1]//div[contains(@class, 'field-title')]//a")
    protected WebElement firstProductName;
    public SearchPage(){
        //Above created object is used for getting driver instance, so that the elements can be located in the page during test run
        PageFactory.initElements(initializeBrowserConnectDriver.getDriver(), this);
    }
}
