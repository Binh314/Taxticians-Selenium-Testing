package com.skillstorm.cucumber;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillstorm.Utility;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.cdimascio.dotenv.Dotenv;

public class DashboardSteps {

    private WebDriver driver;
    private Dotenv dotenv;

    private static final String baseUrl = "http://10.1.0.5:9080/prweb/app/taxticians/";



    @Before("@Onboarding")
    public void beforeOnboarding(){
        this.driver = new ChromeDriver();
        // this.pegaLogin = new PegaLogin(driver);
        // this.studioPage = new StudioPage(driver);
        dotenv = Dotenv.load();

        Utility.goToUserPortal(driver);

        WebElement createButton = driver.findElement(By.cssSelector("[data-menu-id='DataPortalpyCreateCaseMenu153cef6883']"));
        createButton.click();

        Utility.sleep(1000);
        WebElement registerTaxpayerButton = driver.findElement(By.xpath("//*[text()='Register Taxpayer']"));
        registerTaxpayerButton.click();
    }

    @Before("@TaxFiling")
    public void beforeTaxFiling(){
        this.driver = new ChromeDriver();
        // this.pegaLogin = new PegaLogin(driver);
        // this.studioPage = new StudioPage(driver);
        dotenv = Dotenv.load();

        Utility.goToUserPortal(driver);

        WebElement createButton = driver.findElement(By.cssSelector("[data-menu-id='DataPortalpyCreateCaseMenu153cef6883']"));
        createButton.click();

        Utility.sleep(1000);
        WebElement fileTaxButton = driver.findElement(By.xpath("//*[text()='File Individual Taxes']"));
        fileTaxButton.click();
    }

    @After("@Onboarding")
    public void after() {
        // this.driver.quit();
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
        Utility.sleep(100);
        // WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        WebElement submitButton = driver.findElement(By.id("Submit"));
        submitButton.click();
        Utility.sleep(1000);
    }

    @When("I click create")
    public void i_click_create() {
        Utility.sleep(100);
        WebElement createButton = driver.findElement(By.xpath("//button[text()='Create']"));
        createButton.click();
        Utility.sleep(1000);
    }

    @When("I click continue")
    public void i_click_continue() {
        Utility.sleep(100);
        WebElement button = driver.findElement(By.xpath("//button[text()='Continue']"));
        button.click();
    }

    @When("I click finish")
    public void i_click_finish() {
        Utility.sleep(100);
        WebElement button = driver.findElement(By.xpath("//button[text()='Finish']"));
        button.click();
    }

    @When("I click go")
    public void i_click_go() {
        Utility.sleep(100);
        WebElement button = driver.findElement(By.xpath("//button[text()='Go']"));
        button.click();
        Utility.sleep(1000);
    }

    @When("I click approve")
    public void i_click_approve() {
        Utility.sleep(100);
        WebElement button = driver.findElement(By.xpath("//button[text()='Approve']"));
        button.click();
    }

    @When("I click add dependents")
    public void i_click_add_dependents() {
        Utility.sleep(100);
        WebElement button = driver.findElement(By.xpath("//button[text()='Add dependents']"));
        button.click();
    }

    @Then("I get an error message about the short password")
    public void i_get_an_error_message_about_the_short_password() {
        boolean errorMessageIsPresent = driver.findElements(By.xpath("//*[text()='The password must contain at least 12 characters']")).size() > 0;
        assertTrue(errorMessageIsPresent);
        driver.quit();
    }

    @Then("I get an error message about the invalid email")
    public void i_get_an_error_message_about_the_invalid_email() {
        try {
            // Switch to the alert
            Alert alert = driver.switchTo().alert();
            alert.accept(); 
        } catch (NoAlertPresentException e) {
            throw e;
        }
        boolean errorMessageIsPresent = driver.findElements(By.xpath("//*[text()='Enter a valid email address']")).size() > 0;
        assertTrue(errorMessageIsPresent);
        driver.quit();
    }

    @Then("I get an error message about a blank value")
    public void i_get_an_error_message_about_a_blank_value() {
        try {
            // Switch to the alert
            Alert alert = driver.switchTo().alert();
            alert.accept(); 
        } catch (NoAlertPresentException e) {
            throw e;
        }
        boolean errorMessageIsPresent = driver.findElements(By.xpath("//*[text()='Value cannot be blank']")).size() > 0;
        assertTrue(errorMessageIsPresent);
        driver.quit();
    }

    @Then("it is successful")
    public void it_is_successful() {
        driver.quit();
    }
    
    @When("I enter my first name")
    public void i_enter_my_first_name() {
        WebElement field = driver.findElement(By.name("$PpyWorkPage$pForm1040$pFirstName"));
        field.sendKeys(Utility.randomFirstName());
    }

    @When("I enter my middle initial")
    public void i_enter_my_middle_initial() {
        WebElement field = driver.findElement(By.name("$PpyWorkPage$pForm1040$pMiddleInitial"));
        field.sendKeys("m");
    }

    @When("I enter my last name")
    public void i_enter_my_last_name() {
        WebElement field = driver.findElement(By.name("$PpyWorkPage$pForm1040$pLastName"));
        field.sendKeys(Utility.randomLastName());
    }

    @When("I enter a valid SSN")
    public void i_enter_a_valid_SSN() {
        WebElement field = driver.findElement(By.name("$PpyWorkPage$pForm1040$pSSN"));
        field.sendKeys(Utility.randomDigits(9));
    }

    @When("I enter my street address")
    public void i_enter_my_street_address() {
        WebElement field = driver.findElement(By.name("$PpyWorkPage$pForm1040$pStreetAddress"));
        field.sendKeys("1 main st");
    }

    @When("I enter my city")
    public void i_enter_my_city() {
        WebElement field = driver.findElement(By.name("$PpyWorkPage$pForm1040$pCity"));
        field.sendKeys("cambridge");
    }

    @When("I enter my state")
    public void i_enter_my_state() {
        WebElement field = driver.findElement(By.name("$PpyWorkPage$pForm1040$pState"));
        field.sendKeys("massachusetts");
    }

    @When("I enter a valid zip code")
    public void i_enter_a_valid_zip_code() {
        WebElement field = driver.findElement(By.name("$PpyWorkPage$pForm1040$pZip"));
        field.sendKeys("02142");
    }

    @When("I choose filing jointly")
    public void i_choose_filing_jointly() {
        WebElement dropdownElement = driver.findElement(By.name("$PpyWorkPage$pForm1040$pFilingStatus"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Married Filing Jointly (even if only one had income)");
    }

    @When("I enter my spouse's information") 
    public void i_enter_my_spouses_information() {
    
        WebElement firstNameField = driver.findElement(By.name("$PpyWorkPage$pForm1040$pSpouseFirstNameM"));
        firstNameField.sendKeys(Utility.randomFirstName());

        WebElement lastNameField = driver.findElement(By.name("$PpyWorkPage$pForm1040$pSpouseLastName"));
        lastNameField.sendKeys(Utility.randomLastName());

        // WebElement middleInitialField = driver.findElement(By.name("$PpyWorkPage$pForm1040$pSpouseMiddleInitial"));
        // middleInitialField.sendKeys("S");

        WebElement ssnField = driver.findElement(By.name("$PpyWorkPage$pForm1040$pSpouseSSN"));
        ssnField.sendKeys(Utility.randomDigits(9));
    }

    @When("I enter my dependent's information") 
    public void i_enter_my_dependents_information() {
    
        WebElement firstNameField = driver.findElement(By.name("$PTempDependent$pFirstName"));
        firstNameField.sendKeys(Utility.randomFirstName());

        WebElement lastNameField = driver.findElement(By.name("$PTempDependent$pLastName"));
        lastNameField.sendKeys(Utility.randomLastName());

        WebElement ssnField = driver.findElement(By.name("$PTempDependent$pSSN"));
        ssnField.sendKeys(Utility.randomDigits(9));

        WebElement relationField = driver.findElement(By.name("$PTempDependent$pRelationship"));
        relationField.sendKeys("parent");

        List<WebElement> childTaxCreditChecks = driver.findElements(By.name("$PTempDependent$pChildTaxCredit"));
        childTaxCreditChecks.get(1).click();
    }


}
