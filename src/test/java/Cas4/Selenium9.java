package Cas4;

import org.testng.annotations.*;

public class Selenium9 {

    @BeforeClass
    public void method1() {
        System.out.println("-----------------");
        System.out.println("ISPIS IZ BEFORE CLASS");
        System.out.println("-----------------");
    }

    @BeforeMethod
    public void method2() {
        System.out.println("//////////////////");
        System.out.println("ISPIS IZ BEFORE METHOD");
        System.out.println("//////////////////");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("******************");
        System.out.println("TEST 1");
        System.out.println("******************");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("******************");
        System.out.println("TEST 2");
        System.out.println("******************");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("******************");
        System.out.println("TEST 3");
        System.out.println("******************");
    }

    @AfterMethod
    public void method3() {
        System.out.println("-------------------");
        System.out.println("ISPIS IZ AFTER METHOD");
        System.out.println("-------------------");
    }

    @AfterClass
    public void method4() {
        System.out.println("####################");
        System.out.println("ISPIS IZ AFTER CLASS");
        System.out.println("####################");
    }





}
