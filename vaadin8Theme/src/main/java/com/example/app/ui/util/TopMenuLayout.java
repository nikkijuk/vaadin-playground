package com.example.app.ui.util;

import com.google.inject.Inject;
import com.vaadin.guice.annotation.UIScope;
import com.vaadin.ui.Composite;
import com.vaadin.ui.VerticalLayout;

/**
 * Basic layout of app
 */
@UIScope // there is single instance in ui scope
public class TopMenuLayout extends Composite {

    @Inject
    TopMenuLayout(HorizontalButtonMenu uiMenu, ViewContainer uiContent){

        // layout contains header and placeholder for view content
        final VerticalLayout layout = new VerticalLayout(uiMenu, uiContent);

        // define how header and content are sharing available space
        layout.setExpandRatio(uiContent, 1);

        // set layout in use
        setCompositionRoot(layout);
    }
}
