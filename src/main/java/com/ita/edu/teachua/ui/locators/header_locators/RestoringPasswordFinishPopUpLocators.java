package com.ita.edu.teachua.ui.locators.header_locators;


public class RestoringPasswordFinishPopUpLocators {
    public static final String PASSWORD_FIELD_ID = "edit_password";
    public static final String PASSWORD_CONFIRM_FIELD_ID = "edit_new-password";
    public static final String CHANGE_PASSWORD_BUTTON_XPATH = "//button[@type='submit']/span[contains(text(),'Змінити пароль')]";
    public static final String NEW_PASSWORD_INPUT_XPATH = "//*[@id='edit_password']";
    public static final String RESTORE_PASSWORD_INPUT_XPATH = "//*[@id='edit_new-password']";
    public static final String MESSAGE_CHANGE_PASSWORD_ERROR_XPATH = "//*[@class='ant-message-custom-content ant-message-error']";//TODO remove if it is redundant
    public static final String GREEN_MARK_ICON_XPATH = "//*[@class='anticon anticon-check-circle']";
    public static final String MESSAGE_PASSWORD_ERROR_XPATH = "//div[@role='alert']";

}
