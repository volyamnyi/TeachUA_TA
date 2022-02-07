package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.profile_locators.CityDropdownLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CityDropdownComponent extends BasePage {
    @FindBy(how = How.XPATH, using = CityDropdownLocators.KYIV_BUTTON_XPATH)
    private Button kyivButton;

    public CityDropdownComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Choose a 'Київ' city from the 'Місто' drop-down list")
    public AddLocationPopUpComponent clickOnKyivButton() {
        waitUntilElementToBeClickable(By.xpath(CityDropdownLocators.KYIV_BUTTON_XPATH),5);
        kyivButton.click();
        return new AddLocationPopUpComponent(driver);
    }

    public CityDropdownComponent getCityDropdownComponent(){
        return this;
    }
}