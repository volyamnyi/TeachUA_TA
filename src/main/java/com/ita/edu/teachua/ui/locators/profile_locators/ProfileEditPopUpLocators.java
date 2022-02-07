package com.ita.edu.teachua.ui.locators.profile_locators;


public class ProfileEditPopUpLocators {
    public static final String PHONE_EDIT_XPATH = "//input[@id='edit_phone']";
    public static final String LASTNAME_EDIT_XPATH = "//input[@id='edit_lastName']";
    public static final String SAVE_BUTTON_XPATH = "//button[@class='ant-btn submit-button']/span";
    public static final String FIRSTNAME_EDIT_XPATH = "//input[@id='edit_firstName']";
    public static final String PASSWORD_EDIT_CHECKBOX_XPATH = "//input[@class='checkbox']";
    public static final String CURRENT_PASSWORD_ERROR_MESSAGE_XPATH = "//input[contains(@id,'edit_currentPassword')]/ancestor::div[@class='ant-col ant-form-item-control']//div[@role='alert']";
    public static final String NEW_PASSWORD_ERROR_MESSAGE_XPATH = "//input[contains(@id,'edit_password')]/ancestor::div[@class='ant-col ant-form-item-control']//div[@role='alert']";
    public static final String CONFIRM_PASSWORD_ERROR_MESSAGE_XPATH = "//input[contains(@id,'edit_confirmPassword')]/ancestor::div[@class='ant-col ant-form-item-control']//div[@role='alert']";
    public static final String CURRENT_PASSWORD_INPUT_XPATH = "//*[@id='edit_currentPassword']";
    public static final String NEW_PASSWORD_INPUT_XPATH = "//*[@id='edit_password']";
    public static final String CONFIRM_PASSWORD_INPUT_XPATH = "//*[@id='edit_confirmPassword']";
    public static final String MESSAGE_INVALID_INPUT_XPATH = "//div[@role='alert']";
    public static final String ROLE_USER_BUTTON_XPATH = "//div[contains(text(),'Відвідувач')]";
    public static final String ROLE_MANAGER_BUTTON_XPATH = "//div[contains(text(),'Керівник')]";
}

