package com.meyoung.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionsTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars");
        driver=new ChromeDriver(options);
    }
    /**
     * 打开chrome浏览器
     * 打开  百度首页
     * 等待5s
     * 关闭浏览器
     */

    @Test
    public void getTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
    }

    /**
     * 打开chrome浏览器
     * 打开  百度首页
     * 等待3s
     * 后退
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void backTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
    }

    /**
     * 打开chrome浏览器
     * 打开  百度首页
     * 等待3s
     * 后退
     * 等待3s
     * 前进
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void forwardTest() throws InterruptedException {
        driver.get("https://baidu.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
    }

    /**
     * 打开chrome浏览器
     * 打开  google首页
     * 等待3s
     * 刷新
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void refreshTest() throws InterruptedException {
        //get方法一定会等页面加载完成，才往下执行
        driver.get("https://www.google.com.hk/");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);

    }

    /**
     * 打开chrome浏览器
     * 设置窗口大小  300*300
     * 等待3s
     * 最大化窗口
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void windowTest() throws InterruptedException {
        Dimension dimension=new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    /**
     * 打开chrome浏览器
     * 打开 百度首页
     * 获取当前页面的url
     * 等待3s
     * 校验当前首页url是不是百度地址
     * 关闭浏览器
     */
    @Test
    public void getURLTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Thread.sleep(3000);
        Assert.assertEquals(url,"https://www.baidu.com/");


    }

    @AfterMethod
    public void closedBrowser(){
        driver.quit();
    }





}
