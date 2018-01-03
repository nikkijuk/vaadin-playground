package com.example.vaadin8guice.ui.view;

import com.google.inject.Inject;
import com.vaadin.guice.annotation.GuiceView;
import com.vaadin.navigator.View;
import com.vaadin.ui.Panel;

/**
 * Default view of app. Doesn't have name.
 */
@GuiceView("") // start view doesn't have name
public class Vaadin8GuiceStartView extends Panel implements View {

    @Inject
    Vaadin8GuiceStartView(){
        super("start view");
    }
}
