package com.example.app.ui.views;

import com.google.inject.Inject;
import com.vaadin.guice.annotation.GuiceView;
import com.vaadin.navigator.View;
import com.vaadin.ui.Panel;

/**
 * Extra view
 */
@GuiceView("extra") // all other views except start view need to have unique name
public class ExtraView extends Panel implements View {

    @Inject
    ExtraView(){
        super("extra view");
    }
}
