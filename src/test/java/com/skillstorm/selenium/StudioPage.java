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

    @FindBy(name = "pzComposerBarMain_pyPortalHarness_2")
    private WebElement appStudioDropdown;

    @FindBy(xpath = "//*[text()='Dev Studio']")
    private WebElement devStudioButton;

    @FindBy(name="pzStudioHeader_pyDisplayHarness_7")
    private WebElement launchPortalButton;

    @FindBy(xpath = "//*[text() = 'User Portal']")
    private WebElement userPortalButton;

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

    public void clickAppStudioDropdown() {
        try {
            Thread.sleep(1001);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        appStudioDropdown.click();
    }

    public void clickDevStudio() {
        try {
            Thread.sleep(1050);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        devStudioButton.click();
    }

    public void launchUserPortal() {
        try {
            Thread.sleep(2050);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        launchPortalButton.click();

        try {
            Thread.sleep(1050);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        userPortalButton.click();
    }
    
}
