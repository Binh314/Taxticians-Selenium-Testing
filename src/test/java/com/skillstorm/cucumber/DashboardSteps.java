package com.skillstorm.cucumber;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.selenium.PegaLogin;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class DashboardSteps {

    private WebDriver driver;
    private PegaLogin pegaLogin;

    @Before("@onboarding")
    public void before(){
        this.driver = new ChromeDriver();
        this.pegaLogin = new PegaLogin(driver);
    }

    @Given("I am on the Pega login page")
    public void i_am_on_the_login_page(){
        this.pegaLogin.get();
    }

    @When("I enter valid {string} and {string}")
    public void i_enter_valid_credentials(String username, String password){
        this.pegaLogin.setUsername("username");
        this.pegaLogin.setPassword("password");
    }

    @And("click the login button")
    public void i_click_the_login_button(){
        this.pegaLogin.clickLogin();
    }

    @Then("I will be in app studio")
    public void in_app_studio(){
        
    }
    
}
