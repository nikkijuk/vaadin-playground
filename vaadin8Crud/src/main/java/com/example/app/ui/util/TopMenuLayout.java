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
    TopMenuLayout(TopMenu menu, ViewContainer viewContainer){

        // mainLayout contains header and placeholder for view content
        VerticalLayout mainLayout = new VerticalLayout(menu, viewContainer);
        mainLayout.setSizeFull();

        // define how header and content are sharing available space
        mainLayout.setExpandRatio(viewContainer, 1);

        // set mainLayout in use
        setCompositionRoot(mainLayout);
    }
}
