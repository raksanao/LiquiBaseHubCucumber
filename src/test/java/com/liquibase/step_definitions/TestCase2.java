package com.liquibase.step_definitions;

import com.liquibase.page.LoginPage;
import com.liquibase.page.ProjectPage;
import com.liquibase.page.SettingPage;
import com.liquibase.utilities.BrowserUtils;
import com.liquibase.utilities.ConfigurationReader;
import com.liquibase.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCase2 {
    LoginPage loginPage=new LoginPage();
    SettingPage settingPage=new SettingPage();
ProjectPage projectPage=new ProjectPage();
    @Given("Click on the second option \\(Projects) in the left nav.")
    public void click_on_the_second_option_Projects_in_the_left_nav() {
        String URL= ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        System.out.println("Open "+URL);
        loginPage.login();
        loginPage.closePopUp();
        BrowserUtils.wait(4);
       projectPage.clicktoProjects();
       BrowserUtils.wait(4);
       projectPage.expandModule();
    }




    @When("Click to expand the default project.")
    public void click_to_expand_the_default_project() {
//projectPage.expandModule();
    }
    @Then("Click on the Operations tab under this project.")
    public void click_on_the_Operations_tab_under_this_project() {
//projectPage.clickToOperationTab();
    }
    @Then("In the filter options, select Result = Pass.")
    public void in_the_filter_options_select_Result_Pass() {
//projectPage.clickToResult();
//projectPage.clickPass();
    }
    @Then("Expand the dropdown below \\(titled No Operations to display).")
    public void expand_the_dropdown_below_titled_No_Operations_to_display() {
//projectPage.clickDropDownOperat();
    }



}
