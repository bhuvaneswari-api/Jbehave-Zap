package com.zap.md.methods;

import com.zap.md.DataProvider;
import com.zap.md.steps.CommonInstance;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//This class contains all the common methods used all over the testcases
public class CommonMethods{
    InitializeBrowserConnectDriver initializeBrowserConnectDriver = new InitializeBrowserConnectDriver();
    public WebDriver driver = initializeBrowserConnectDriver.getDriver();
    public WebDriverWait wait = new WebDriverWait(driver, 60);;
    private DataProvider dataProvider = new DataProvider();
    private String pageTitle = dataProvider.readFromHashMap("homePageTitle");
    private String nameOfFirstProduct;
    private String productPrice;

    public void VerifyHomePageTitle(){
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }

    public void verifyElementDisplayed(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    }

    public String getElementTextFromPage(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        String text = element.getText().trim();
        return text;
    }
    public void verifyElementText(WebElement element, String expectedText){
        String text = getElementTextFromPage(element);
        Assert.assertTrue("The Text is not as expected, Actual: "+text+" Expected: "+expectedText, text.equals(expectedText));
    }
    public void verifyElementContainsText(WebElement element, String expectedText){
        String text = getElementTextFromPage(element);
        Assert.assertTrue("The Text does not contain the expected Text, Actual: "+text+" Expected: "+expectedText, text.contains(expectedText));
    }
    public String getAttributeText(WebElement element, String Attribute){
        wait.until(ExpectedConditions.visibilityOf(element));
        String attributeText = element.getAttribute(Attribute);
        return attributeText;
    }
    public void verifyAttributeText(WebElement element, String Attribute, String expectedText){
        String attributeText = getAttributeText(element, Attribute);
        Assert.assertTrue("The Attribute Text is not as expected, Actual: "+attributeText+" Expected: "+expectedText, attributeText.equals(expectedText));
    }

    public void typeInTextBox(WebElement element, String textToType){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(textToType);
    }

    public void verifyVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void pressKeyBoardKeys(WebElement element, String keyToPress){
        switch (keyToPress){
            case "ENTER":
                element.sendKeys(Keys.ENTER);
                break;
        }

    }

    public void compareTexts(String actual, String expected){
        Assert.assertTrue("The given texts does not match, Actual: "+actual+" Expected: "+expected, actual.equals(expected));
    }

    public void setNameOfFirstProduct(String nameOfFirstProduct){
        this.nameOfFirstProduct = nameOfFirstProduct;
    }

    public String getNameOfFirstProduct(){
        return nameOfFirstProduct;
    }


    public void setProductPrice(String productPrice){
        this.productPrice = productPrice;
    }

    public String getProductPrice(){
        return productPrice;
    }

    public void closeBrowser(){
        driver.quit();
    }
}
