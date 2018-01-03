package com.example.vaadin8guice.ui;

import com.google.inject.AbstractModule;

/**
 * Guice module for defining needed bindings
 */
public class Vaadin8GuiceModule extends AbstractModule {

    @Override
    protected void configure() {

        // bindings come here
        //bind(StartViewContent.class).to(StartViewContentDefault.class);
    }
}
