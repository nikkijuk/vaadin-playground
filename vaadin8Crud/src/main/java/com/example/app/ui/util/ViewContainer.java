package com.example.app.ui.util;

import com.vaadin.guice.annotation.UIScope;
import com.vaadin.ui.Panel;

/**
 * Container in which views content is set
 */
@UIScope // there is single instance in ui scope
public class ViewContainer extends Panel {

    ViewContainer() {
        setSizeFull();
        setStyleName(KaamosTheme.KAAMOS_CONTENT);
    }
}
