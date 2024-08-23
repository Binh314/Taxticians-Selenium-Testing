package com.skillstorm.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PegaLogin {

    private WebDriver driver;
    private static final String baseUrl = "http://10.1.0.5:9080/prweb/app/taxticians/";

    @FindBy(id = "txtUserID")
    private WebElement usernameField;

    @FindBy(id = "txtPassword")
    private WebElement passwordField;

    @FindBy(id = "sub")
    private WebElement loginBtn;

    public PegaLogin(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    /**
     * navigating to the login page
     * pause execution for 1000 mili sec before navigation
     */
    public void get() {
        try {
            Thread.sleep(1425);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        //driver.get(baseUrl);
        driver.navigate().to(baseUrl);
    }

    /**
     * entering the username into the username field
     */
    public void setUsername(String username) {
        try {
            Thread.sleep(1254);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        usernameField.sendKeys(username);
    }

    /**
     * entering the password into the password field
     */
    public void setPassword(String password) {
        try {
            Thread.sleep(1145);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        passwordField.sendKeys(password);
    }

    /**
     * clicks the login in button and submits a form
     */
    public void clickLogin() {
        try {
            Thread.sleep(2145);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        loginBtn.click();
    }
    
}
