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

public class WindowSelectTest {

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
     * 点击open new window
     * 点击baidu
     */

    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///C:/Users/T/Desktop/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        //当前driver所在的页面的   句柄值
        String currentHandle = driver.getWindowHandle();
        System.out.println(currentHandle);
        //for 循环判断    获取到的handle是否等于currentHandle
        for (String handle:driver.getWindowHandles()) {
            if(handle.equals(currentHandle)){
                System.out.println(currentHandle);
                continue;
            }else {
                driver.switchTo().window(handle);
                System.out.println(handle);
            }
        }
        driver.findElement(By.linkText("baidu")).click();

    }



    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
