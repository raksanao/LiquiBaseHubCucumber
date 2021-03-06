package com.liquibase.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

//    private Driver() { }
//
//    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
//
//
//    public static WebDriver getDriver() {
//        if (driverPool.get() == null) {
//
//            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
//            // this is for terminal command  to change browser
//            // the command in the terminal will override the configurationReader browser
//            if (System.getProperty("browser")!=null){
//                browser=System.getProperty("browser");
//            }
//            switch (browser) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driverPool.set(new ChromeDriver());
//                    break;
//                case "chrome-headless":
//                    WebDriverManager.chromedriver().setup();
//                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driverPool.set(new FirefoxDriver());
//                    break;
//                case "firefox-headless":
//                    WebDriverManager.firefoxdriver().setup();
//                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
//                    break;
//                case "ie":
//                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
//                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
//                    WebDriverManager.iedriver().setup();
//                    driverPool.set(new InternetExplorerDriver());
//                    break;
//
//                case "edge":
//                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
//                        throw new WebDriverException("Your OS doesn't support Edge");
//                    WebDriverManager.edgedriver().setup();
//                    driverPool.set(new EdgeDriver());
//                    break;
//
//                case "safari":
//                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
//                        throw new WebDriverException("Your OS doesn't support Safari");
//                    WebDriverManager.getInstance(SafariDriver.class).setup();
//                    driverPool.set(new SafariDriver());
//                    break;
//
//                case "remote-chrome":
//                    try {
//                        URL url = new URL("http://52.87.204.4:4444/wd/hub");
//                        ChromeOptions chromeOptions = new ChromeOptions();
//                        driverPool.set(new RemoteWebDriver(url, chromeOptions));
//                    } catch (MalformedURLException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                case "remote-firefox":
//                    try {
//                        URL url = new URL("http://52.87.204.4:4444/wd/hub");
//                        FirefoxOptions firefoxOptions = new FirefoxOptions();
//                        driverPool.set(new RemoteWebDriver(url, firefoxOptions));
//                    } catch (MalformedURLException e) {
//                        e.printStackTrace();
//                    }
//            }
//        }
//        return driverPool.get();
//    }
//
//    public static void closeDriver() {
//        if (driverPool.get() != null) {
//            driverPool.get().quit();
//            driverPool.remove();
//        }
//    }

    //same for everyone
    private static WebDriver driver;

    //so no one can create object of Driver class
    //everyone should call static getter method instead
    private Driver() {

    }

    public static WebDriver getDriver() {
        //if webdriver object doesn't exist
        //create it
        if (driver == null) {
            //specify browser type in configuration.properties file
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
