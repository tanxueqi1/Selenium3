package com.meyoung.day03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;

public class GridTest {

    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //创建一个DesiredCapabilities类型
        DesiredCapabilities dc=DesiredCapabilities.chrome();

        //实例化一个driver  dc是启动哪个浏览器
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.112:4444/wd/hub"),dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }

    @DataProvider(name="data4")
    public Object[][] test1(){
        return new Object[][]{
                {"firefox","http://192.168.1.102:7797"},
                {"chrome","http://192.168.1.102:3681"}
        };
    }

    @Test(dataProvider = "data4")
    public void testGrid2(String browser,String url) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc=null;
        if (browser.equals("firefox")){
            dc=DesiredCapabilities.firefox();
        }else if (browser.equals("chrome")){
            dc=DesiredCapabilities.chrome();
        }else {
            System.out.println("error");
        }
        WebDriver driver=new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }



}
