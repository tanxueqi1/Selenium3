package com.meyoung.day01;

import org.testng.annotations.*;

public class TestNGDemo1 {

    @Test
    public void testCase1(){
        System.out.println("这是@Test注解,case1");
    }

    @Test
    public void testCase2(){
        System.out.println("这是@Test注解，case2");
    }

    @BeforeTest
    public void beforeTest01(){
        System.out.println("这是BeforeTest注解");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是BeforeMethod注解");
    }
    @AfterTest
    public void AfterTest01(){
        System.out.println("这是AfterTest注解");
    }
    @AfterMethod
    public void AfterMethod01(){
        System.out.println("这是AfterMethod注解");
    }
}
