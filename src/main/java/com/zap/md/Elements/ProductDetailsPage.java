package com.zap.md.Elements;

import com.zap.md.methods.InitializeBrowserConnectDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//This class holds all the locators in CartPage of Zap Website
public class ProductDetailsPage {
    //creating object for InitializeBrowserConnectDriver Class to use it to get the driver during initElements action in the constructor
    InitializeBrowserConnectDriver initializeBrowserConnectDriver = new InitializeBrowserConnectDriver();
    @FindBy(how = How.XPATH, using = ".//div[@class='product-title']//h1")
    protected WebElement ProductDetailsText;
    @FindBy(how = How.ID, using = "add-to-cart")
    protected WebElement AddToBasketButton;
    @FindBy(how = How.CSS, using = "div.container")
    protected WebElement MiniCartOverLay;
    @FindBy(how = How.CSS, using = "div.container>div.header")
    protected WebElement MiniCartOverLayHeader;
    @FindBy(how = How.CSS, using = "span.cart-icon")
    protected WebElement CartIcon;
    public ProductDetailsPage(){
        //Above created object is used for getting driver instance, so that the elements can be located in the page during test run
        PageFactory.initElements(initializeBrowserConnectDriver.getDriver(), this);
    }
}
