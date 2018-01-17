package com.example.app.ui.util;

import com.google.inject.Inject;
import com.vaadin.guice.annotation.NavigableViewClasses;
import com.vaadin.guice.annotation.UIScope;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.util.Map;

/**
 * Header for app
 */
@UIScope // there is single instance in ui scope
public class SidebarMenu extends VerticalLayout {

    @Inject
    SidebarMenu(@NavigableViewClasses Map<String, Class<? extends View>> viewClasses) {
        //setSizeFull();
        setHeightUndefined();
        setWidth("100%");
        //setWidthUndefined();
        setStyleName(KaamosTheme.KAAMOS_MENU);
        setMargin(false);

        // Navigation is built here
        for (String viewName : viewClasses.keySet()) {
            String caption = "navigate to " + viewName;
            Button navigationButton = new Button(caption, e -> goTo(viewName));
            addComponent(navigationButton);
        }
    }

    /**
     * navigate to view
     */
    private void goTo(String viewName) {
        UI.getCurrent().getNavigator().navigateTo(viewName);
    }
}
