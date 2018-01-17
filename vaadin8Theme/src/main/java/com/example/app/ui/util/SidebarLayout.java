package com.example.app.ui.util;

import com.google.inject.Inject;
import com.vaadin.guice.annotation.UIScope;
import com.vaadin.ui.Composite;
import com.vaadin.ui.HorizontalLayout;

/**
 * Basic layout of app
 */
@UIScope // there is single instance in ui scope
public class SidebarLayout extends Composite {

    @Inject
    SidebarLayout(SidebarMenu menu, ViewContainer viewContainer){

        // mainLayout contains menu and placeholder for view content
        HorizontalLayout mainLayout = new HorizontalLayout(menu, viewContainer);
        mainLayout.setHeight("100%");

        // define how menu and content are sharing available space
        mainLayout.setExpandRatio(viewContainer, 1);

        // set mainLayout in use
        setCompositionRoot(mainLayout);
    }
}
