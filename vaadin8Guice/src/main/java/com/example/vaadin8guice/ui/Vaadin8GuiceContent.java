package com.example.vaadin8guice.ui;

import com.google.inject.Inject;
import com.vaadin.guice.annotation.UIScope;
import com.vaadin.ui.Composite;
import com.vaadin.ui.VerticalLayout;

/**
 * Basic layout of app
 */
@UIScope // there is single instance in ui scope
public class Vaadin8GuiceContent extends Composite {

    @Inject
    Vaadin8GuiceContent(Vaadin8GuiceHeader myHeader, Vaadin8GuiceViewContainer myViewContainer){

        // layout contains header and placeholder for view content
        final VerticalLayout layout = new VerticalLayout(myHeader, myViewContainer);

        // define how header and content are sharing available space
        layout.setExpandRatio(myViewContainer, 1);

        // set layout in use
        setCompositionRoot(layout);
    }
}
