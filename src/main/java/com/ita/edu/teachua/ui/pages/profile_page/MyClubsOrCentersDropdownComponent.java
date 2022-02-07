package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.profile_locators.MyClubsOrCentersDropdownComponentLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyClubsOrCentersDropdownComponent extends BasePage {

    @FindBy(how = How.XPATH, using = MyClubsOrCentersDropdownComponentLocators.CENTERS_BUTTON_XPATH)
    private Button centersButton;

    public MyClubsOrCentersDropdownComponent(WebDriver driver) {
        super(driver);
    }

    public ProfilePage clickOnCentersButton(){
        centersButton.click();
        //waitUntilElementToBeClickable(By.cssSelector(MyClubsOrCentersDropdownComponentLocators.CENTERS_CSS_SELECTOR), 5);
        sleep(200);
        return new ProfilePage(driver);
    }

    public MyClubsOrCentersDropdownComponent getMyClubsOrCentersDropdownComponent(){
        return this;
    }
}
