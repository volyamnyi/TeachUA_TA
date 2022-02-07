package com.ita.edu.teachua.ui.pages.advanced_search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CentersItemComponent {
    WebElement root;
    WebDriver driver;

    public CentersItemComponent(WebDriver driver, WebElement root) {
        this.driver = driver;
        this.root = root;
    }

    public boolean isList() {
        String str = root.getAttribute("class");
        return str.contains("list-rectangle-item");
    }
}
