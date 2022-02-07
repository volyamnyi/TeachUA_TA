package com.ita.edu.teachua.ui.pages.advanced_search;

import com.ita.edu.teachua.ui.locators.advanced_search_page_locators.ClubsItemComponentLocators;
import com.ita.edu.teachua.ui.pages.administration_pages.BannerPage;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class ClubsItemComponent extends BasePage {
    DefaultElementLocatorFactory parentContext;
    @FindBy(how = How.XPATH, using = ClubsItemComponentLocators.CARD_TITLE_XPATH)
    private WebElement cartTitle;
    @FindAll(@FindBy(how = How.XPATH, using = ClubsItemComponentLocators.CARD_RATING_STAR_XPATH))
    private List<WebElement> cardStars;

    public ClubsItemComponent(WebDriver driver, WebElement root) {
        super(driver);
        parentContext = new DefaultElementLocatorFactory(root);
        PageFactory.initElements(parentContext, this);
    }

    @Step("Get title of the card")
    public WebElement getCardTitle() {
        return cartTitle;
    }

    public Integer getRating() {
        return cardStars.size();
    }

    public ClubsItemComponent getClubsItemComponent(){
        return this;
    }
}
