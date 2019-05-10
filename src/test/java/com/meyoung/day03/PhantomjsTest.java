package com.meyoung.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PhantomjsTest {

    @Test
    public void phantomjsTest() throws InterruptedException {
        System.setProperty("phantomjs.binary.path","D:\\IdeaProjects\\SeleniumDemo\\drivers\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(3000);
        driver.quit();
    }
}
