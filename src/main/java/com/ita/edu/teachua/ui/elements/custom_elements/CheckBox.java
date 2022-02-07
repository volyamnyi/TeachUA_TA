package com.ita.edu.teachua.ui.elements.custom_elements;

import com.ita.edu.teachua.ui.elements.base_element.Element;
import com.ita.edu.teachua.ui.elements.base_element.ImplementedBy;

@ImplementedBy(CheckBoxElement.class)
public interface CheckBox extends Element {


    void toggle();

    void check();


    void uncheck();

    boolean isChecked();
}
