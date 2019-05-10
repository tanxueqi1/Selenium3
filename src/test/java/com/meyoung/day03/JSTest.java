package com.meyoung.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSTest {

    WebDriver driver;


    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
    }


    @Test
    public void jsTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"driver\")");


    }


    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
