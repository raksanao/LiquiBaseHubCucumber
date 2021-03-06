package com.liquibase.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataProviderExample {
  //  public static void main(String[] args) {
       // WebDriverManager.chromedriver().setup();
    @Test
        public void test(String url,String title) {
        System.setProperty("webdriver.chrome.driver", "user.dir" + "/chromdriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Assert.assertTrue(title, driver.getTitle().contains(title));
//    }
//    @DataProvider(name,"testdata")
//    public Object[][]testData(){  {"http://google.com"},
//        {"http://amazon.com"}
//    };
    }
}
