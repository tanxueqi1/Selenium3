package com.meyoung.day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {

    @Test
    public void assertEqualTest(){
        String a=null;
        String b="asdf12";
        Assert.assertNotNull(a);
    }
}
