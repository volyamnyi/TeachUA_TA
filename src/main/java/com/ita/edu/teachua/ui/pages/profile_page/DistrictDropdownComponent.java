package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.profile_locators.DistrictDropdownLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DistrictDropdownComponent extends BasePage {
    @FindBy(how = How.XPATH, using = DistrictDropdownLocators.DESNIANSKYI_BUTTON_XPATH)
    private Button desnianskyiButton;

    public DistrictDropdownComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Choose a 'Деснянський' district from the 'Місто' drop-down list")
    public AddLocationPopUpComponent clickOnDesnianskyiButton() {
        desnianskyiButton.click();
        return new AddLocationPopUpComponent(driver);
    }

    public DistrictDropdownComponent getDistrictDropdownComponent(){
        return this;
    }
}