package com.ita.edu.teachua.ui.pages.administration_pages;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.locators.administration_pages_locators.BannerPageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BannerPage extends BasePage {
    @FindBy(how = How.XPATH, using = BannerPageLocators.UPLOAD_BANNER_XPATH)
    private Input uploadBanner;       //TODO or not creator
    @FindBy(how = How.XPATH, using = BannerPageLocators.ADD_BANNER_BUTTON_XPATH)
    private Button addBanner;

    public BannerPage(WebDriver driver) {
        super(driver);
    }

    public BannerPage getBannerPage(){
        return this;
    }
}
