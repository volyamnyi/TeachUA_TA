package com.ita.edu.teachua.ui.elements.custom_elements;

import com.ita.edu.teachua.ui.elements.base_element.Element;
import com.ita.edu.teachua.ui.elements.base_element.ImplementedBy;

@ImplementedBy(RadioButtonElement.class)
public interface RadioButton extends Element {
    void toggle();

    void check();

    boolean isChecked();
}
