package com.zap.md.Elements;

import com.zap.md.methods.InitializeBrowserConnectDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
//This class holds all the locators in CartPage of Zap Website
public class CartPage {
    //creating object for InitializeBrowserConnectDriver Class to use it to get the driver during initElements action in the constructor
    InitializeBrowserConnectDriver initializeBrowserConnectDriver = new InitializeBrowserConnectDriver();
    @FindBy(how = How.XPATH, using = ".//div[@class='cart-head' and contains(text(), 'Te')]")
    protected WebElement cartPageHeader;
    @FindBy(how = How.XPATH, using = ".//div[@class='cart-qty-control plus']")
    protected WebElement IncrementButton;
    @FindBy(how = How.XPATH, using = ".//td[@class='price']")
    protected WebElement ProductPrice;
    @FindBy(how = How.XPATH, using = ".//input[contains(@id, 'edit-prod') and (@class='form-text')]")
    protected WebElement quantityBox;
    @FindBy(how = How.XPATH, using = ".//td[@class='total']//b")
    protected WebElement ProductTotal;
    @FindBy(how = How.ID, using = "edit-user-name")
    protected WebElement UserNameField;
    @FindBy(how = How.ID, using = "edit-user-mail")
    protected WebElement UserEmailField;
    @FindBy(how = How.ID, using = "edit-user-tel1")
    protected WebElement UserTeleField;
    @FindBy(how = How.ID, using = "edit-user-address")
    protected WebElement UserAddressField;
    @FindBy(how = How.ID, using = "edit-submit")
    protected WebElement PlaceOrderButton;
    @FindBy(how = How.XPATH, using = ".//div[@class='messages success']")
    protected WebElement OrderSuccessMessage;
    public CartPage(){
        //Above created object is used for getting driver instance, so that the elements can be located in the page during test run
        PageFactory.initElements(initializeBrowserConnectDriver.getDriver(), this);
    }
}
