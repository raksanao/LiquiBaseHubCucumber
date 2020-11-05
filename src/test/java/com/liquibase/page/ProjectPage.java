package com.liquibase.page;

import com.liquibase.utilities.BrowserUtils;
import com.liquibase.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {

    @FindBy(xpath = "(//span[@class='mat-button-wrapper'])[4]")
    protected WebElement expand;
    @FindBy(xpath = "//div[.='Operations']")
    protected WebElement operation;

    @FindBy(xpath = "//span[.='Result']")
    protected WebElement result;

    @FindBy(xpath = "(//span[@class='mat-option-text'])[2]")
    protected WebElement pass;


    @FindBy(css = "[role=button]")
    protected WebElement expandDropDownNoOperation;



    public void clicktoProjects() {

        BrowserUtils.wait(2);

        BrowserUtils.wait(4);
        PageFactory.initElements(Driver.getDriver(), this);

        WebElement projectbtn = Driver.getDriver().findElement(By.xpath("//*[text()='account_tree']"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //use executeScript
        jse.executeScript("arguments[0].click();", projectbtn);

    }

    public void expandModule() {
        expand.click();

    }

    public void clickToOperationTab() {
        operation.click();
    }

    public void clickToResult() {
        result.click();

    }

    public void clickPass() {
        pass.click();

    }

    public void clickDropDownOperat() {
        expandDropDownNoOperation.click();
        String text = "No Operations to display.";
        Assert.assertEquals(text,expandDropDownNoOperation.getText());

    }

}
