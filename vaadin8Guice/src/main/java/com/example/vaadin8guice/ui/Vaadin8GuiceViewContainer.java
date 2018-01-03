package com.example.vaadin8guice.ui;

import com.vaadin.guice.annotation.UIScope;
import com.vaadin.ui.Panel;

/**
 * Container in which views content is set
 */
@UIScope // there is single instance in ui scope
public class Vaadin8GuiceViewContainer extends Panel {

    Vaadin8GuiceViewContainer() {
        setSizeFull();
    }
}
