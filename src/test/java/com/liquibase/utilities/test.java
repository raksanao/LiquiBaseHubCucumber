package com.liquibase.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    public static void main(String[] args) {
//        int num = 1234;
//
//        int rev = 0;
//        while (num != 0) {
//            int digit = num % 10;
//          rev=  rev * 10 + digit;
//            num /= 10;
//        }
//            System.out.println("rev = " + rev);

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("http://google.com");
    }
}
