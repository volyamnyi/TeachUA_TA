package com.ita.edu.teachua.ui.locators.profile_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileDynamicCheckBoxLocators {

    public WebElement getLocationCheckBoxByNameByXPath(WebDriver driver, String name) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + name + "')]"));
    }

    public WebElement getClubCheckBoxByNameByXPath(WebDriver driver, String name) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + name + "')]"));
    }
}
