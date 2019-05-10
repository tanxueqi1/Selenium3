package com.meyoung.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {

    //火狐默认安装
    @Test
    public void openFireFox(){
        WebDriver webDriver=new FirefoxDriver();
    }

    //火狐指定安装
    @Test
    public void openFireFox1(){
        System.setProperty("webdriver.gecko.driver","D:\\IdeaProjects\\SeleniumDemo\\drivers\\geckodriver.exe");
        WebDriver webDriver=new FirefoxDriver();
    }

    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\SeleniumDemo\\drivers\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars");
        WebDriver webDriver=new ChromeDriver(options);
        webDriver.get("https://www.baidu.com");
    }

    @Test
    public void openIE(){
        System.setProperty("webdriver.ie.driver","D:\\IdeaProjects\\SeleniumDemo\\drivers\\IEDriverServer.exe");
        WebDriver webDriver=new InternetExplorerDriver();
    }

    @Test
    public void openEdge(){
        System.setProperty("webdriver.edge.driver","D:\\IdeaProjects\\SeleniumDemo\\drivers\\MicrosoftWebDriver.exe");
        WebDriver webDriver=new EdgeDriver();
    }



}
