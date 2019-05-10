package com.meyoung.day02;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
    WebDriver driver;


    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars");
        driver=new ChromeDriver(options);
    }

    /**
     * 我要点击百度首页的新闻链接
     * 那么我打开了新闻页面
     */

    @Test
    public void clickTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement newsLink = driver.findElement(By.xpath("//*[@id=\"u_sp\"]/a[1]"));//*[@id="u_sp"]/a[1]
        newsLink.click();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();


    }

    /**
     * 打开百度首页
     * 输入关键字selenium
     * 点击百度一下进行搜索
     * 校验title是否等于"selenium_百度搜素"
     */
    @Test
    public void sendKeysTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        WebElement button = driver.findElement(By.id("su"));
        button.click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    @Test
    public void clearTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        Thread.sleep(3000);
        keys.clear();
        Thread.sleep(5000);

    }

    /**
     *
     */
    @Test
    public void getTextTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement keys = driver.findElement(By.name("tj_trnews"));
        keys.sendKeys("selenium");
        String text = keys.getText();

        Assert.assertEquals(text,"新闻");

    }

    /**
     *打开百度首页
     * 获取文本框得tagname
     * 校验是否为input
     */
    @Test
    public void getTagNameTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        String tagName = driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input");
    }

    /**
     *打开百度首页
     * 判断按钮显示得文本值为  百度一下
     * 校验是否为input
     */
    @Test
    public void getATest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        String attribute = driver.findElement(By.id("su")).getAttribute("type");
        System.out.println(attribute);
        Assert.assertEquals(attribute,"submit");
    }

    /**
     *打开百度首页
     * 判断是否显示 百度一下 按钮
     */
    @Test
    public void isDisplayedTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        boolean b = driver.findElement(By.id("su")).isDisplayed();
        System.out.println(b);
        Assert.assertTrue(b);
    }

    /**
     *打开测试首页
     * 判断volvo单选框被选中
     */
    @Test
    public void isSelectedTest() throws InterruptedException {
        driver.get("C:\\Users\\T\\Desktop\\demo1.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
        Thread.sleep(3000);
        element.click();
        Thread.sleep(3000);
        boolean b = element.isSelected();
        System.out.println(b);
        Assert.assertTrue(b);

    }


    /**
     *打开测试首页
     * 判断submit按钮处于未激活状态
     */
    @Test
    public void isEnabledTest() throws InterruptedException {
        driver.get("C:\\Users\\T\\Desktop\\demo1.html");
        boolean b = driver.findElement(By.xpath("//*[@id=\"button\"]/input")).isEnabled();
        Assert.assertFalse(b);


    }

    /**
     * 截图百度首页
     */
    @Test
    public void shotTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        File srcFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(srcFile,new File("f:\\screenfile.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @AfterMethod
    public void closedBrowser(){
        driver.quit();
    }
}
