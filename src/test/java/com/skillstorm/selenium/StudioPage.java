package com.skillstorm.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudioPage {

    private WebDriver driver;

    @FindBy(name = "pzAppName_pyPortalHarness_1")
    private WebElement appName;

    public StudioPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public boolean appNameDisplay() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return appName.isDisplayed();
    }
    
}
