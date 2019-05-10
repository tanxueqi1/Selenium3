package com.meyoung.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {

    WebDriver driver;


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
    public void RegisterTest() throws InterruptedException {
        //控制权转交给iframe里面
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        //点击注册按钮
        driver.findElement(By.id("changepage")).click();
        //获取当前driver所在的handle值
        String currentHandle = driver.getWindowHandle();
        //driver切换到新的window页面
        for (String handle:driver.getWindowHandles()) {
            if(handle.equals(currentHandle)){
                continue;
            }else {
                driver.switchTo().window(handle);
            }
        }

        String time = String.valueOf(System.currentTimeMillis()/100);

        driver.findElement(By.id("nameIpt")).sendKeys("txq"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("fsdfsd");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("fsdfsd");
        driver.findElement(By.id("vcodeIpt")).sendKeys("werwr");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        driver.findElement(By.id("mainRegA")).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_vcode\"]/span")));
        String text = driver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span")).getText();
        Assert.assertEquals(text,"  验证码不正确，请重新填写");

    }


    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
