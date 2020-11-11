package com.liquibase.step_definitions;

import com.liquibase.page.LoginPage;
import com.liquibase.page.SettingPage;
import com.liquibase.utilities.BrowserUtils;
import com.liquibase.utilities.ConfigurationReader;
import com.liquibase.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestCase1 {
    LoginPage loginPage=new LoginPage();
    SettingPage settingPage=new SettingPage();
    @Given("User in Login page")
    public void user_in_Login_page() {

        String URL= ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        System.out.println("Open "+URL);
        loginPage.login();
        loginPage.closePopUp();

    }

    @When("Click on the third option \\(Settings) in the left nav.")
    public void click_on_the_third_option_Settings_in_the_left_nav() {

settingPage.clickToSetting();


    }
    @When("Click on the User Info tab.")
    public void click_on_the_User_Info_tab() {
        settingPage.clicktoUserInfo();

    }

    @Then("Edit the user info fields to add updated info for your user account.")
    public void edit_the_user_info_fields_to_add_updated_info_for_your_user_account(List<Map<String, String>>dataTable) {
        for (Map<String, String> row : dataTable) {
            settingPage.clearForm();
            BrowserUtils.wait(5);
            settingPage.setFirstName(row.get("firstname"));
            BrowserUtils.wait(5);
            settingPage.setmidle(row.get("middlename"));

            settingPage.setlastName(row.get("lastname"));

            settingPage.seturl(row.get("url"));

            settingPage.setcompany(row.get("company"));

            settingPage.setbio(row.get("bio"));
            BrowserUtils.wait(4);
            settingPage.cliktoUpdateInfo();

        }
         Assert.assertEquals(settingPage.pageTitle(), "Liquibase Hub");

         String url = "https://hub-staging.liquibase.com/settings/user-info";
          Assert.assertEquals(settingPage.pageUrl(), url);
        Assert.assertEquals(settingPage.getSettings(),true);

    }




    }





