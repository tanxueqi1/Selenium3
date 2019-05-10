package com.meyoung.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ClosedBrowserTest {

    @Test
    public void closedChrome() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        //消除"正受到自动测试软件的控制"字样
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars");

        //实例化chromeDriver
        WebDriver driver=new ChromeDriver(options);
        Thread.sleep(5000);
        //关闭当前窗口，任务器里的chrome.exe仍在
        driver.close();
    }

    @Test
    public void closedChrome1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars");
        WebDriver driver=new ChromeDriver(options);
        Thread.sleep(5000);
        //完全退出浏览器，任务器里的chrome.exe不存在
        driver.quit();

    }
}
