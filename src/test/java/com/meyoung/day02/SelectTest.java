package com.meyoung.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {

    WebDriver driver;


    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars");
        driver=new ChromeDriver(options);
    }

    /**
     * 打开我们的测试界面
     * 下拉框选择vivo
     * 第二次选择huawei
     * 第三次选择iphone
     */

    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///C:/Users/T/Desktop/selenium_html/index.html");
        WebElement selectEl= driver.findElement(By.id("moreSelect"));
        Select select=new Select(selectEl);
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByValue("huawei");
        Thread.sleep(3000);
        select.selectByVisibleText("iphone");

    }






    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
