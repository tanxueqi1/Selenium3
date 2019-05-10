package com.po.page;

import org.openqa.selenium.By;

public class LoginPage {
   //定义email文本框的定位方式
    public static By emailInput=By.name("email");
    public static By passwordInput=By.name("password");
    public static By loginButton=By.id("dologin");
    public static By registerButton=By.id("changepage");
}
