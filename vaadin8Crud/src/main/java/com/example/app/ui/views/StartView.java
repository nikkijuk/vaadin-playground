package com.example.app.ui.views;

import com.google.inject.Inject;
import com.vaadin.guice.annotation.GuiceView;
import com.vaadin.navigator.View;
import com.vaadin.ui.Panel;

/**
 * Default view of app. Doesn't have name.
 */
@GuiceView("") // start view doesn't have name
public class StartView extends Panel implements View {

    @Inject
    StartView(){
        super("start view");
    }
}
