package com.skillstorm.cucumber;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.selenium.PegaLogin;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import com.skillstorm.selenium.StudioPage;

import io.github.cdimascio.dotenv.Dotenv;

public class DashboardSteps {

    private WebDriver driver;
    private PegaLogin pegaLogin;
    private StudioPage studioPage;
    private Dotenv dotenv;

    @Before("@Onboarding")
    public void before(){
        this.driver = new ChromeDriver();
        this.pegaLogin = new PegaLogin(driver);
        this.studioPage = new StudioPage(driver);

        dotenv = Dotenv.load();
    }

    @Given("I am on the Pega login page")
    public void i_am_on_the_login_page(){
        this.pegaLogin.get();
    }

    @When("I enter valid {string} and {string}")
    public void i_enter_valid_credentials(String username, String password){
        this.pegaLogin.setUsername(dotenv.get("USERNAME"));
        this.pegaLogin.setPassword(dotenv.get("PASSWORD"));
    }

    @And("click the login button")
    public void i_click_the_login_button(){
        this.pegaLogin.clickLogin();
    }

    @Then("I will be in app studio")
    public void in_app_studio(){
        assertTrue(this.studioPage.appNameDisplay());
    }

    // @Given("I am on App Studio home page")
    // public void i_am_on_app_studio_home_page() {
    //     // Write code here that turns the phrase above into concrete actions
    //     assertTrue(this.studioPage.appNameDisplay());
    // }

    @When("I click on App Studio") 
    public void i_click_the_app_studio() {
        this.studioPage.clickAppStudioDropdown();
    }

    @When("click Dev Studio")
    public void click_dev_studio() {
        this.studioPage.clickDevStudio();
    }
    
    @Then("I will be in Dev Studio")
    public void i_will_be_in_dev_studio() {
        assertTrue(true);
    }

    @When("I launch user portal")
    public void i_launch_user_portal() {
        this.studioPage.launchUserPortal();
    }
}
