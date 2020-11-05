package com.liquibase.page;

import com.liquibase.utilities.BrowserUtils;
import com.liquibase.utilities.ConfigurationReader;
import com.liquibase.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//span[.='Log In']")
    protected WebElement login;
    @FindBy(xpath="(//input[@name='username'])[2]")
    protected WebElement username;
    @FindBy(xpath="(//input[@placeholder='Password'])[2]")
    protected WebElement password;
    @FindBy ( name= "cognitoAsfData")
    protected WebElement signIn;
    @FindBy(xpath = "//span[.='close']")
    protected  WebElement popupX;

    @FindBy(xpath = "//span[.='Log Out'] ")
    protected WebElement logOut;


    public LoginPage() {
        //to connect our webdriver, page class and page factory
        //PageFactory - used to use @FindBy annotations
        //PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // public String getWarningMessageText() {
    // return warningMessage.getText();
    //   }

    /**
     * Method to login, version #1
     * Login as a specific user
     *
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue) {
        login.click();
        BrowserUtils.wait(5);
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);

        BrowserUtils.waitForPageToLoad(10);

    }
    //
//    /**
//     * Method to login, version #2
//     * Login as a default user
//     * Credentials will be retrieved from configuration.properties file
//     */
    public void login() {
        login.click();
        BrowserUtils.wait(4);
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(4);

    }
    public void closePopUp(){
        popupX.click();
    }
    //}
    public void logOut() {
        logOut.click();

    }

}
