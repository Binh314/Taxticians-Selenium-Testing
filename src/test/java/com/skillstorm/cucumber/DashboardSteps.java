package com.skillstorm.cucumber;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.selenium.PegaLogin;
import com.skillstorm.selenium.Utility;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import com.skillstorm.selenium.StudioPage;

import io.github.cdimascio.dotenv.Dotenv;

public class DashboardSteps {

    private WebDriver driver;
    private PegaLogin pegaLogin;
    private StudioPage studioPage;
    private Dotenv dotenv;

    private static final String baseUrl = "http://10.1.0.5:9080/prweb/app/taxticians/";

    @Before("@Onboarding")
    public void before(){
        this.driver = new ChromeDriver();
        this.pegaLogin = new PegaLogin(driver);
        this.studioPage = new StudioPage(driver);
        dotenv = Dotenv.load();

        driver.navigate().to(baseUrl);

        WebElement usernameField = driver.findElement(By.id("txtUserID"));
        usernameField.sendKeys(dotenv.get("USERNAME"));

        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys(dotenv.get("PASSWORD"));

        WebElement loginBtn = driver.findElement(By.id("sub"));
        loginBtn.click();

        WebElement studioDropdown = driver.findElement(By.name("pzComposerBarMain_pyPortalHarness_2"));
        studioDropdown.click();

        Utility.sleep(100);

        WebElement devStudioButton = driver.findElement(By.xpath("//*[text()='Dev Studio']"));
        devStudioButton.click();

        WebElement iframe = driver.findElement(By.id("Developer"));
        driver.switchTo().frame(iframe);

        WebElement launchPortalButton = driver.findElement(By.name("pzStudioHeader_pyDisplayHarness_7"));
        launchPortalButton.click();

        WebElement userPortalButton = driver.findElement(By.xpath("//*[text()='User Portal']"));
        userPortalButton.click();

        Utility.sleep(100);

        Set<String> allTabs = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(allTabs);

        driver.switchTo().window(tabs.get(1));

    }

    

    @When("I click the create case button")
    public void i_click_the_create_case_button() {
        WebElement createButton = driver.findElement(By.cssSelector("[data-menu-id='DataPortalpyCreateCaseMenu153cef6883']"));
        createButton.click();
    }

    
}
