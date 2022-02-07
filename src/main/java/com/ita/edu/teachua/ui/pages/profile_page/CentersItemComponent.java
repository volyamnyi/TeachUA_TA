package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.locators.profile_locators.CentersItemComponentLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class CentersItemComponent {
    DefaultElementLocatorFactory parentContext;
    WebDriver driver;
    @FindBy(how = How.XPATH, using = CentersItemComponentLocators.CENTERS_TITLE_XPATH)
    private WebElement centerTitle;

    public CentersItemComponent(WebDriver driver, WebElement root) {
        this.driver=driver;
        parentContext = new DefaultElementLocatorFactory(root);
        PageFactory.initElements(parentContext, this);
    }

    public CentersItemComponent(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getCenterTitle(){
        return centerTitle;
    }

    public boolean containsValue() {
       String str = centerTitle.getText();
       return str.contains("API_testing");
    }

    public CentersItemComponent getCentersItemComponent(){
        return this;
    }
}
