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

    @FindBy(id = "Developer")
    private WebElement iframe;

    public StudioPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }


    public boolean appNameDisplay() {
        Utility.sleep(1);
        return appName.isDisplayed();
    }

    public void clickAppStudioDropdown() {
        Utility.sleep(1);
        appStudioDropdown.click();
    }

    public void clickDevStudio() {
        Utility.sleep(1);
        devStudioButton.click();
    }

    public void launchUserPortal() {
        Utility.sleep(2);
        driver.switchTo().frame(iframe);
        Utility.sleep(2);
        launchPortalButton.click();
        Utility.sleep(1);
        userPortalButton.click();
    }
    
}
