package com.zap.md.methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;



import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class InitializeBrowser {
    public static WebDriver driver;
    public static void openSpecifiedBrowser(String browserType){
        switch (browserType){
            case "Chrome":
                WebDriverManager.chromedriver().version("80.0.3987.16").setup();
                driver = new ChromeDriver();
                break;
            case "FireFox":
                WebDriverManager.firefoxdriver().version("70.0.0").setup();
                driver = new FirefoxDriver();
                break;
            case "Headless":
                driver = new HtmlUnitDriver();
        }
    }
}