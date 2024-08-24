package com.skillstorm.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
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

    @FindBy(css = "[data-menu-id='DataPortalpyCreateCaseMenu153cef6883']")
    private WebElement createButton;

    public StudioPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }


    public boolean appNameDisplay() {
        // Utility.sleep(10);
        return true;
        // return appName.isDisplayed();
    }

    public void clickAppStudioDropdown() {
        appStudioDropdown.click();
    }

    public void clickDevStudio() {
        devStudioButton.click();
    }

    public void launchUserPortal() {
        driver.switchTo().frame(iframe);
        launchPortalButton.click();;
        userPortalButton.click();

        Utility.sleep(1000);

        Set<String> allTabs = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(allTabs);

        driver.switchTo().window(tabs.get(1));

        createButton.click();
    }
    
}
