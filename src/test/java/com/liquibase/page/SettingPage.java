package com.liquibase.page;

import com.liquibase.utilities.BrowserUtils;
import com.liquibase.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SettingPage {

    @FindBy(xpath = "//div[2]/div[3]/div")
    protected WebElement settings;

    @FindBy(xpath = "//span[.='close']")
    protected WebElement popupX;

    @FindBy(xpath="(//div[@class='settings-tree__item'])[1]")
    protected WebElement userInfo;
    @FindBy(css="input[id='mat-input-3']" )
    protected WebElement firstName;

    @FindBy(css="input[id='mat-input-4']" )
    protected WebElement middleName;

    @FindBy(css="input[id='mat-input-5']" )
    protected WebElement lastName;

    @FindBy(css="input[id='mat-input-8']" )
    protected WebElement url;

    @FindBy(css="input[id='mat-input-9']" )
    protected WebElement company;

    @FindBy(id="mat-input-10")
    protected WebElement bio;
    @FindBy(xpath = "//span[.='Update Profile']")
    protected WebElement updateProfile;

    public void clickToSetting() {
        BrowserUtils.wait(2);
        //settings.click();
        BrowserUtils.wait(4);
        PageFactory.initElements(Driver.getDriver(), this);

        WebElement settingBtn = Driver.getDriver().findElement(By.xpath("//*[text()='settings']"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //use executeScript
        jse.executeScript("arguments[0].click();",settingBtn);

    }

    public void closePopup(){
        BrowserUtils.wait(4);
        popupX.click();


    }
    public void setFirstName(String firstname){
     firstName.clear();
      firstName.sendKeys(firstname);

    }
    public void setmidle(String middleName1) {
        middleName.clear();
        middleName.sendKeys(middleName1);
    }

    public void setlastName(String lastName1) {
        lastName.clear();
        lastName.sendKeys(lastName1);
    }

    public void seturl(String url1) {
        url.clear();
        url.sendKeys(url1);
    }
    public void setcompany(String comp) {
        company.clear();
        company.sendKeys(comp);

    }
    public void setbio(String bio1) {
        bio.clear();
        bio.sendKeys(bio1);

    }
    public void cliktoUpdateInfo(){
        WebElement userInfo = Driver.getDriver().findElement(By.xpath("(//div[@class='settings-tree__item'])[1]"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //use executeScript
        jse.executeScript("arguments[0].click();",updateProfile);//userinfo

    }

    public void clicktoUserInfo() {
        userInfo.click();

}
public String getFirstName() {

    // firstName.sendKeys(name);
  return   firstName.getText();
}

}

//    public String getCarGeneralInfo(String parameter) {
//        String xpath = "//label[text()='" + parameter + "']/following-sibling::div/div";
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
//        return driver.findElement(By.xpath(xpath)).getText().trim();