package com.skillstorm;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;

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

public final class Utility {
    private Utility() {

    }

    public static String randomDigits(int numDigits) {
        String digits = "";
        Random random = new Random();

        for (int i = 0; i < numDigits; i++) {
            int digit = random.nextInt(10);
            digits += digit;
        }

        return digits;
    }

    /**
     * Puts the thread to sleep for a specified number of seconds.
     * 
     * @param seconds number of seconds to sleep
     */
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Given a selenium web driver, uses it to navgiate to the User Portal in Pega.
     * 
     * @param driver Selenium web driver used to navigate to the user portal
     */
    public static void goToUserPortal(WebDriver driver) {
        goToPortal(driver, "User Portal");
    }


    /**
     * Given a seleneium web driver and portal name, uses it to navigate to that portal in Pega.
     * @param driver Selenium web driver used to navigate to the portal
     * @param portalName name of the portal (case sensitive)
     */
    public static void goToPortal(WebDriver driver, String portalName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Dotenv dotenv = Dotenv.load();

        String baseUrl = "http://10.1.0.5:9080/prweb/app/taxticians/";
        driver.navigate().to(baseUrl);

        WebElement usernameField = driver.findElement(By.id("txtUserID"));
        usernameField.sendKeys(dotenv.get("USERNAME"));

        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys(dotenv.get("PASSWORD"));

        WebElement loginBtn = driver.findElement(By.id("sub"));
        loginBtn.click();

        // WebElement appDropdown = driver.findElement(By.name("pzAppName_pyPortalHarness_1"));
        // appDropdown.click();

        // WebElement testAppButton = driver.findElement(By.xpath("//*[text()='Taxticians Unit Tests App']"));
        // testAppButton.click();

        WebElement studioDropdown = driver.findElement(By.name("pzComposerBarMain_pyPortalHarness_2"));
        studioDropdown.click();

        Utility.sleep(1500);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement devStudioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Dev Studio']")));
        devStudioButton.click();

        WebElement iframe = driver.findElement(By.id("Developer"));
        driver.switchTo().frame(iframe);

        WebElement launchPortalButton = driver.findElement(By.name("pzStudioHeader_pyDisplayHarness_7"));
        launchPortalButton.click();

        WebElement userPortalButton = driver.findElement(By.xpath(String.format("//*[text()='%s']", portalName)));
        userPortalButton.click();

        Utility.sleep(100);

        Set<String> allTabs = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(allTabs);

        driver.switchTo().window(tabs.get(1));
    }
    

}
