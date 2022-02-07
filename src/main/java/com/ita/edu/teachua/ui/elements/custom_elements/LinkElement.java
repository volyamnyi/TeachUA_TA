package com.ita.edu.teachua.ui.elements.custom_elements;

import com.ita.edu.teachua.ui.elements.base_element.BaseElement;
import org.openqa.selenium.WebElement;

public class LinkElement extends BaseElement implements Label {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public LinkElement(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        getWrappedElement().click();
    }
}
