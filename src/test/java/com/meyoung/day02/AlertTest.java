package com.meyoung.day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {

    WebDriver driver;


    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars");
        driver=new ChromeDriver(options);
    }

    /**
     * 打开UI自动化测试 主页
     * 点击alert按钮
     * 在alert警告框点击确定按钮
     */
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///C:/Users/T/Desktop/selenium_html/index.html");
        Thread.sleep(3000);
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        //获取警告框文本
        String text = alert.getText();
        System.out.println(text);
        Assert.assertEquals(text,"请点击确定");
        alert.accept();

    }
    /**
     * 打开UI自动化测试 主页
     * 点击confirm按钮
     * 在confirm警告框点击取消按钮
     * 再次点击确定按钮
     */
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("file:///C:/Users/T/Desktop/selenium_html/index.html");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"confirm\"]/input")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();



    }
    /**
     * 打开UI自动化测试 主页
     * 点击prompt按钮
     * 在prompt 弹窗中，输入"这个是prompt"
     * 点击确定按钮
     * 再次点击确认按钮
     */
    @Test
    public void promptTest() throws InterruptedException {

        driver.get("file:///C:/Users/T/Desktop/selenium_html/index.html");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"prompt\"]/input")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        //google浏览器存在无法输入内容,火狐不存在该bug
        alert.sendKeys("这个是prompt");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
    }

    /**
     * 打开测试界面
     * 点击百度链接
     */
    @Test
    public void iframeTest() throws InterruptedException {

        driver.get("file:///C:/Users/T/Desktop/selenium_html/index.html");
        //传字符串的话，要么是id，要么是name
        driver.switchTo().frame("aa");
        driver.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
        Thread.sleep(3000);
        //将控制权转交给原来的页面
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
    }

    @Test
    public void iframeTest1() throws InterruptedException {

        driver.get("file:///C:/Users/T/Desktop/selenium_html/index.html");
        //传字符串的话，要么是id，要么是name
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
    }






    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
