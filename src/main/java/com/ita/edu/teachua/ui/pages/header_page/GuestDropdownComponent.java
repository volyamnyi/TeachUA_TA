package com.ita.edu.teachua.ui.pages.header_page;


import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.header_locators.GuestDropdownComponentLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GuestDropdownComponent extends BasePage {
    @FindBy(how = How.XPATH, using = GuestDropdownComponentLocators.REGISTER_BUTTON_XPATH)
    private Button registerButton;
    @FindBy(how = How.XPATH, using = GuestDropdownComponentLocators.LOGIN_BUTTON_XPATH)
    private Button loginButton;

    public GuestDropdownComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Click on register button")
    public RegisterPopUpComponent clickOnRegisterButton() {
        waitUntilVisibilityOfElementLocated(By.xpath(GuestDropdownComponentLocators.REGISTER_BUTTON_XPATH),10);
        waitUntilElementToBeClickable(By.xpath(GuestDropdownComponentLocators.REGISTER_BUTTON_XPATH),10);
        registerButton.click();
        return new RegisterPopUpComponent(driver);
    }

    @Step("Click on `Увійти` button")
    public LoginPopUpComponent clickOnLoginButton() {
        waitUntilElementToBeClickable(By.xpath(GuestDropdownComponentLocators.LOGIN_BUTTON_XPATH), 5);
        loginButton.click();
        return new LoginPopUpComponent(driver);
    }

    public GuestDropdownComponent getGuestDropdownComponent(){
        return this;
    }

}
