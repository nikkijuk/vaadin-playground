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
    Vaadin8GuiceContent(Vaadin8GuiceHeader header, Vaadin8GuiceViewContainer myViewContainer){
        final VerticalLayout layout = new VerticalLayout(header, myViewContainer);

        layout.setExpandRatio(myViewContainer, 1);

        setCompositionRoot(layout);
    }
}
