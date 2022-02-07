package com.ita.edu.teachua.ui.pages.base_page;

import com.ita.edu.teachua.ui.pagefactory.ElementFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        initialize(this.driver);
    }

    public BasePage initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, this);
    }

    public void waitUntilVisibilityOfElementLocated(By locator, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void sleep(long ms) {
        try {
            Thread.sleep(ms); // For Presentation ONLY
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void implicitlyWaitInMs(long ms) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(ms));
    }

    public void waitUntilElementToBeClickable(By locator, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForAmountOfElements(By locator, int amount, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, amount));
    }

}
