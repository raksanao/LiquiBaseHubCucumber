package com.liquibase.page;

import com.liquibase.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    @FindBy(xpath = "//li[@id='search-btn']")
    protected WebElement searchBtn;

    @FindBy(xpath = "//input[@id='s']")
    protected WebElement searchInput;

    /**
     * Method for SemanticBits navigation. Provide tab name and module name to navigate
     * @param tabName, like Expertise, Domains, Services
     * @param moduleName, for Expertise -> (Big Data, Mobility, Cloud Services,..),
     *                    for Domains -> (Health IT, Clinical Genomics, Clinical Trials,..)
     */
    public void moveToByName(String tabName, String moduleName) {
        String tabNameXpath = "(//*[contains(text(),'"+tabName+"')])[1]";
        String moduleNameXpath = "(//*[contains(text(),'"+moduleName+"')])[1]";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleNameXpath));

        Actions actions = new Actions(driver);

        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-icon none")));

    }

    /**
     * Method for SemanticBits navigation. Provide only the tab name to navigate
     * @param tabName, like Expertise, Domains, Services
     */
    public void moveToByName(String tabName) {
        String tabNameXpath = "(//*[contains(text(),'"+tabName+"')])[1]";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));

        tabElement.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-icon none")));

    }

    public void search (String itemToSearch){
        searchBtn.click();
        searchInput.sendKeys(itemToSearch);
        //just commit for git

    }

}
