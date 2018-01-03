package com.example.vaadin8guice.ui.view;

import com.google.inject.Inject;
import com.vaadin.guice.annotation.GuiceView;
import com.vaadin.navigator.View;
import com.vaadin.ui.Panel;

@GuiceView("extra") // all other views except start view have name
public class Vaadin8GuiceExtraView extends Panel implements View {

    @Inject
    Vaadin8GuiceExtraView(){
        super("extra view");
    }
}
