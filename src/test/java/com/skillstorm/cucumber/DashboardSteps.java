package com.skillstorm.cucumber;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        Utility.sleep(500);
        WebElement registerTaxpayerButton = driver.findElement(By.xpath("//*[text()='Register Taxpayer']"));
        // driver.findElement(By.xpath("//*[@title='Register Taxpayer']"));
        registerTaxpayerButton.click();
    }

    @When("I enter a valid email and password")
    public void i_enter_a_valid_email_and_password() {
        WebElement emailField = driver.findElement(By.id("dcbbc9a8"));
        emailField.sendKeys("example@skillstorm.com");

        WebElement passwordField = driver.findElement(By.id("6a51482b"));
        passwordField.sendKeys("password");
    }

    
}
