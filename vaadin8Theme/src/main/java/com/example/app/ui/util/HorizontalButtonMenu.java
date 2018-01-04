package com.example.app.ui.util;

import com.google.inject.Inject;
import com.vaadin.guice.annotation.NavigableViewClasses;
import com.vaadin.guice.annotation.UIScope;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

import java.util.Map;

/**
 * Header for app
 */
@UIScope // there is single instance in ui scope
public class HorizontalButtonMenu extends HorizontalLayout {

    @Inject
    HorizontalButtonMenu(@NavigableViewClasses Map<String, Class<? extends View>> viewClasses) {
        setWidth("100%");
        setStyleName(KaamosTheme.KAAMOS_MENU);

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
