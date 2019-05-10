package com.meyoung.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendEmailTest {

    WebDriver driver;


    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.get("https://mail.163.com/");
    }

    @Test
    public void sendEmail(){
        LoginTest.loginPo(driver,"tanxueqi1","weibudianzi123456");
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")));
        driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();

        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("535223120@qq.com");
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("我是中国人1");
        driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\T\\Desktop\\selenium_html\\aa.html");
        driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));
        driver.findElement(By.xpath("/html/body")).sendKeys("内容");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='发送']")).click();

        //显示等待
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='发送成功']")));
        boolean b = driver.findElement(By.xpath("//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(b);
    }
}
