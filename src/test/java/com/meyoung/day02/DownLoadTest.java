package com.meyoung.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DownLoadTest {

    WebDriver driver;


    @BeforeMethod
    public void openBrowser() {
        String downLoadFilepath="f:\\";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups",0);
        chromePrefs.put("download.default_directory",downLoadFilepath);

        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",chromePrefs);
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
    }

    @Test
    public void downLoad() throws InterruptedException {
        driver.get("https://pc.qq.com/detail/0/detail_1300.html");
        driver.findElement(By.className("detail-install-normal")).click();
        Thread.sleep(30000);
    }

    @AfterMethod
    public void closedBrowser() {
        driver.quit();
    }
}

