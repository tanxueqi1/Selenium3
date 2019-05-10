package com.meyoung.day03;

import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

public class LoginTest {

    static WebDriver driver;


    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.get("https://mail.163.com/");
    }

    /**
     * 163邮箱注册
     */

    @Test
    public void loginSuccess() throws InterruptedException {
        loginPo(driver,"tanxueqi1","weibudianzi12345");
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));

        String text = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(text,"退出");


    }

    @Test
    public static void loginFail() throws InterruptedException {
        loginPo(driver,"tanxueqi1","weisdfsf");
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));

        String text = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(text,"请先进行验证");


    }

    public void info(){
       loginPo(driver,"sdf","sdfsd");
    }

    public  static void loginPo(WebDriver driver,String email,String password){
        //控制权转交给iframe里面
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.passwordInput).sendKeys(password);
        driver.findElement(LoginPage.loginButton).click();

    }


    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
