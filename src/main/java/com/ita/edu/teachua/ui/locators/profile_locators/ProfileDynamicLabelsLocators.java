package com.ita.edu.teachua.ui.locators.profile_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileDynamicLabelsLocators {
    public WebElement addLocationPopUpDynamicIdByXPath(WebDriver driver, String id) {
        return driver.findElement(By.xpath(String.format("//input[contains(@id,'%s')]/ancestor::div[@class='ant-form-item-control-input']//span[@aria-label='check-circle']", id)));
        ////input[contains(@id,'basic_contactТелефон')]/ancestor::div[@class='ant-row ant-form-item add-club-contact ant-form-item-has-feedback ant-form-item-has-success']//span[@aria-label='check-circle']
    }

    public WebElement addClubPopUpDynamicIdByXPath(WebDriver driver, String id) {
        return driver.findElement(By.xpath(String.format("//input[contains(@id,'%s')]/ancestor::div[@class='ant-row ant-form-item add-club-contact ant-form-item-has-feedback ant-form-item-has-success']//span[@aria-label='check-circle']", id)));
        ////input[contains(@id,'basic_contactТелефон')]/ancestor::div[@class='ant-row ant-form-item add-club-contact ant-form-item-has-feedback ant-form-item-has-success']//span[@aria-label='check-circle']
    }
}