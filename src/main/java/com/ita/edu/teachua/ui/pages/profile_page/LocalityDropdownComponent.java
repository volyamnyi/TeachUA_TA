package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.profile_locators.LocalityDropdownLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LocalityDropdownComponent extends BasePage {

    @FindBy(how = How.XPATH, using = LocalityDropdownLocators.AKADEMMISTECHKO_BUTTON_XPATH)
    private Button akademmistechkoButton;


    public LocalityDropdownComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Choose a 'Академмістечко' locality from the 'Метро/Міцевість' drop-down list")
    public AddLocationPopUpComponent clickOnAkademmistechkoButton() {
        akademmistechkoButton.click();
        return new AddLocationPopUpComponent(driver);
    }

    public LocalityDropdownComponent getLocalityDropdownComponent(){
        return this;
    }
}