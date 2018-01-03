package com.example.vaadin8guice.ui;

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
public class Vaadin8GuiceHeader extends HorizontalLayout {

    @Inject
    Vaadin8GuiceHeader(@NavigableViewClasses Map<String, Class<? extends View>> viewClasses) {
        setWidth("100%");

        // Navigation is built here
        for (String uiFragment : viewClasses.keySet()) {
            Button navigationButton = new Button(
                    "navigate to " + uiFragment,
                    e -> UI.getCurrent().getNavigator().navigateTo(uiFragment)
            );

            addComponent(navigationButton);
        }
    }
}
