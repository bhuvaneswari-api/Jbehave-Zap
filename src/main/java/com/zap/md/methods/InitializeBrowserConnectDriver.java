package com.zap.md.methods;

import com.zap.md.DataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class InitializeBrowserConnectDriver {
    public static WebDriver driver;
    private static DataProvider dataProvider = new DataProvider();
    String browserName="";
    public static void openSpecifiedBrowser(String browserType){
        switch (browserType){
            case "Chrome":
                WebDriverManager.chromedriver().browserVersion("84.0.4147.30").setup();
                driver = new ChromeDriver();
                break;
            case "FireFox":
                WebDriverManager.firefoxdriver().browserVersion("70.0.0").setup();
                driver = new FirefoxDriver();
                break;
            case "Safari":
//                driver = new HtmlUnitDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(dataProvider.readFromHashMap("zapUrl"));
    }

    public WebDriver getDriver(){
        if(driver == null){
            try{
                browserName = System.getProperty("browser");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            InitializeBrowserConnectDriver.openSpecifiedBrowser(browserName);
            return driver;
        }
        else{
            return driver;
        }
    }
}