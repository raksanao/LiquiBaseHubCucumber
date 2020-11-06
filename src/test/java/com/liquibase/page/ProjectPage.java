package com.liquibase.page;

import com.liquibase.utilities.BrowserUtils;
import com.liquibase.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends BasePage {

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

        BrowserUtils.wait(4);
        PageFactory.initElements(Driver.getDriver(), this);

        WebElement projectbtn = Driver.getDriver().findElement(By.xpath("//*[text()='account_tree']"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //use executeScript
        jse.executeScript("arguments[0].click();", projectbtn);

    }

    public void expandeModule() {
        WebElement expandBnt = Driver.getDriver().findElement(By.xpath("(//span[@class='mat-button-wrapper'])[4]"));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //use executeScript
        jse.executeScript("arguments[0].click();", expandBnt);



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
    }
        public void verifyingText(){
        String text = "No Operations to display.";
        Assert.assertEquals(text,expandDropDownNoOperation.getText());
//WebElement woops=driver.findElement(By.xpath("//div[@class='mat-expansion-panel-body ng-tns-c118-19']"));
//Assert.assertEquals(woops.getText()," Whoops! It looks like we don't have any Operations to show you here. Go add some! ");

    }

}
