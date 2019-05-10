package com.meyoung.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionsTest2 {



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
     * 在百度一下按钮上右键
     */

    @Test
    public void rightClickTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        //实例化Actions
        Actions actions = new Actions(driver);
        //在百度一下按钮   右键
        actions.contextClick(buttonBaidu).perform();


    }

    /**
     * 打开百度页面
     * 在百度一下按钮上双键
     */

    @Test
    public void doubleClickTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        //实例化Actions
        Actions actions = new Actions(driver);
        //在百度一下按钮   双击
        actions.doubleClick(buttonBaidu).perform();


    }

    /**
     * 打开测试页面
     * 鼠标移动到action按钮
     * 那么显示hello world
     */

    @Test
    public void moveTest() throws InterruptedException {
        driver.get("file:///C:/Users/T/Desktop/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        //实例化Actions
        Actions actions = new Actions(driver);
        //在百度一下按钮   双击
        actions.moveToElement(element).perform();

        String text = driver.findElement(By.xpath("//*[text()=\"Hello World!\"]")).getText();
        Assert.assertEquals(text,"Hello World!");


    }

    /**
     * 打开测试页面
     * 鼠标移动到action按钮
     * 那么显示hello world
     */

    @Test
    public void dragAndDropTest() throws InterruptedException {
        driver.get("C:\\Users\\T\\Desktop\\selenium_html\\dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        //实例化Actions
        Actions actions = new Actions(driver);

        actions.dragAndDropBy(element,500,500).perform();
        Thread.sleep(3000);


    }

    @Test
    public void dragAndDropTest1() throws InterruptedException {
        driver.get("C:\\Users\\T\\Desktop\\selenium_html\\dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        WebElement element1 = driver.findElement(By.xpath("/html/body/h1"));
        Thread.sleep(2000);
        //实例化Actions
        Actions actions = new Actions(driver);
        //将元素放到指定元素的中间位置
        actions.clickAndHold(element).moveToElement(element1).release(element).perform();
        Thread.sleep(3000);


    }

    @Test
    public void moreSelectTest() throws InterruptedException {
        driver.get("C:\\Users\\T\\Desktop\\selenium_html\\index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));

        Actions actions = new Actions(driver);
        actions.click(list.get(0)).keyDown(Keys.CONTROL).click(list.get(2)).keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);


    }


    @Test
    public void saveHtml() throws InterruptedException, AWTException {
        driver.get("https://www.baidu.com");

        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_S);
        int i =(int) new Character('S');
        robot.keyPress(i);

        robot.keyPress(KeyEvent.VK_ENTER);


    }

    @Test
    public void uploadTest() throws InterruptedException, AWTException {
        driver.get("file:///C:/Users/T/Desktop/selenium_html/index.html");

       driver.findElement(By.id("load")).sendKeys("C:\\Users\\T\\Desktop\\周考3_平安软件测试工程师笔试试题.docx");

        Thread.sleep(3000);
    }






    @AfterMethod
    public void closedBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
