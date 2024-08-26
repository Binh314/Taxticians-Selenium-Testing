package com.skillstorm.cucumber;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillstorm.Utility;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.cdimascio.dotenv.Dotenv;

public class DashboardSteps {

    private WebDriver driver;
    private Dotenv dotenv;

    private static final String baseUrl = "http://10.1.0.5:9080/prweb/app/taxticians/";

    @Before("@Onboarding")
    public void before(){
        this.driver = new ChromeDriver();
        // this.pegaLogin = new PegaLogin(driver);
        // this.studioPage = new StudioPage(driver);
        dotenv = Dotenv.load();

        Utility.goToUserPortal(driver);
    }

    

    @When("I click the create case button")
    public void i_click_the_create_case_button() {
        WebElement createButton = driver.findElement(By.cssSelector("[data-menu-id='DataPortalpyCreateCaseMenu153cef6883']"));
        createButton.click();
    }

    @When("I click Register Taxpayer")
    public void i_click_register_taxpayer() {
        Utility.sleep(1000);
        WebElement registerTaxpayerButton = driver.findElement(By.xpath("//*[text()='Register Taxpayer']"));
        registerTaxpayerButton.click();
    }

    @When("I enter a valid email")
    public void i_enter_a_valid_email() {
        WebElement emailField = driver.findElement(By.id("dcbbc9a8"));
        emailField.sendKeys("example@skillstorm.com");
    }

    @When("I enter an invalid email")
    public void i_enter_an_invalid_email() {
        WebElement emailField = driver.findElement(By.id("dcbbc9a8"));
        emailField.sendKeys("example");
    }

    @When("I enter a valid password")
    public void i_enter_a_valid_password() {
        WebElement passwordField = driver.findElement(By.id("6a51482b"));
        passwordField.sendKeys("passwordpassword");
    }

    @When("I enter a too short password")
    public void i_enter_a_too_short_password() {
        WebElement passwordField = driver.findElement(By.id("6a51482b"));
        passwordField.sendKeys("password");
    }


    @When("I click submit")
    public void i_click_submit() {
        WebElement submitButton = driver.findElement(By.xpath("//*[text()='Submit']"));
        submitButton.click();
    }

    @Then("I get an error message about the short password")
    public void i_get_an_error_message_about_the_short_password() {
        boolean errorMessageIsPresent = driver.findElements(By.xpath("//*[text()='The password must contain at least 12 characters']")).size() > 0;
        assertTrue(errorMessageIsPresent);
    }

    
}
