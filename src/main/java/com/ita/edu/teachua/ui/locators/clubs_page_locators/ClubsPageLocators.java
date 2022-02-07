package com.ita.edu.teachua.ui.locators.clubs_page_locators;

public class ClubsPageLocators {
    public static final String CARD_TITLE_CSS_SELECTOR = "div[class='name']";
    public static final String CARD_CATEGORY_CSS_SELECTOR = "span[class='name']";
    public static final String CLUBS_PAGE_TITLE_XPATH = "//h2[contains(text(),'Гуртки у місті Київ')]";
    public static final String INVALID_CLUBS_BASIC_SEARCH_CSS_SELECTOR = "div.clubs-not-found";
    public static final String NEXT_PAGE_BUTTON_XPATH = "//li[@title='Next Page']//button[class='ant-pagination-item-link']";
    public static final String LAST_PAGE_BUTTON_XPATH = "//li[@title='Next Page']/preceding-sibling::*[1]";
}
