package com.ita.edu.teachua.ui.pages.header_page;


import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.locators.header_locators.LoginPopUpComponentLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPopUpComponent extends BasePage {

    @FindBy(how = How.ID, using = LoginPopUpComponentLocators.EMAIL_FIELD_ID)
    private Input emailField;
    @FindBy(how = How.ID, using = LoginPopUpComponentLocators.PASSWORD_FIELD_ID)
    private Input passwordField;
    @FindBy(how = How.XPATH, using = LoginPopUpComponentLocators.LOG_IN_SUBMIT_BUTTON_XPATH)
    private Button loginSubmitButton;
    @FindBy(how = How.CLASS_NAME, using = LoginPopUpComponentLocators.FORGOT_PASSWORD_BUTTON_CLASS_NAME)
    private Button forgotPasswordButton;


    public LoginPopUpComponent(WebDriver driver) {
        super(driver);

    }

    public LoginPopUpComponent sendKeysEmailField(String emailValue) {
        waitUntilVisibilityOfElementLocated(By.id(LoginPopUpComponentLocators.EMAIL_FIELD_ID), 5);
        emailField.set(emailValue);
        return this;
    }

    @Step("Fill in Password field: '{passwordValue}'")
    public LoginPopUpComponent sendKeysPasswordField(String passwordValue) {
        passwordField.set(passwordValue);
        return this;
    }

    @Step("Click on Submit button")
    public HeaderPage clickLoginSubmitButton() {
        loginSubmitButton.click();
        sleep(2000);
        return new HeaderPage(driver);
    }

    @Step("Set values '{email}'/'{password}' for `Емейл` and `Пароль` fields")
    public HeaderPage fillLoginFields(String email, String password) {
        sendKeysEmailField(email);
        sendKeysPasswordField(password);
        clickLoginSubmitButton();
        return new HeaderPage(driver);
    }

    @Step("Click on 'Забули пароль' button.")
    public RestoringBeginPopUpComponent clickOnForgotPasswordButton(){
        sleep(500);
        //waitElementToBeClickable(LoginPopUpComponentLocators.FORGOT_PASSWORD_BUTTON,5);
        forgotPasswordButton.click();
        return new RestoringBeginPopUpComponent(driver);
    }

    public LoginPopUpComponent getLoginPopUpComponent(){
        return this;
    }
}
