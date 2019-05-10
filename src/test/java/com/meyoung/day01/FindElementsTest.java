package com.meyoung.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars");
        driver=new ChromeDriver(options);
    }

    /**
     * 打开百度页面
     * 通过Id定位搜索文本框
     */
    @Test
    public void byIDTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField = driver.findElement(By.id("kw"));
    }
    /**
     * 打开百度页面
     * 通过name定位搜索文本框
     */
    @Test
    public void byNameTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField = driver.findElement(By.name("wd"));
    }

    /**
     * 打开百度页面
     * 通过class定位搜索文本框
     */
    @Test
    public void byClassTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField = driver.findElement(By.className("btn self-btn bg s_btn"));
    }

    /**
     * 打开百度页面
     * 通过linkText定位搜索文本框
     */
    @Test
    public void byLinkTextTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField = driver.findElement(By.linkText("新闻"));
    }

    /**
     * 打开百度页面
     * 通过partialLinkText定位搜索文本框
     */
    @Test
    public void byPartialLinkTextTest(){
        driver.get("https://www.baidu.com");
        WebElement keyField = driver.findElement(By.partialLinkText("新"));
    }

    /**
     * 打开百度页面
     * 通过tagname定位搜索文本框
     */

    @Test
    public void byTagNameTest(){
        driver.get("https://www.baidu.com");
        List<WebElement> list = driver.findElements(By.tagName("input"));
        System.out.println(list.size());
        list.get(0).sendKeys("我是中国人");

    }

    /**
     * 打开百度页面
     * 通过xpath定位搜索文本框
     */

    @Test
    public void byXpathTest(){
        driver.get("https://www.baidu.com");
        driver.findElement(By.xpath("//*[@id=\"su\"]"));

    }

    /**
     * 打开百度页面
     * 通过css定位搜索百度图片
     */

    @Test
    public void byCssTest(){
        driver.get("https://www.baidu.com");
        driver.findElement(By.cssSelector("#lg > map:nth-child(3) > area:nth-child(1)"));

    }

    @AfterMethod
    public void closedBrowser(){
        driver.quit();
    }


}
