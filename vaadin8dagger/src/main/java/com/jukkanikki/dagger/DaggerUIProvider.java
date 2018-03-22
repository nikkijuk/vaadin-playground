package com.jukkanikki.dagger;

import com.vaadin.server.DefaultUIProvider;
import com.vaadin.server.UIProvider;

import javax.inject.Inject;

public class DaggerUIProvider extends DefaultUIProvider {

    @Inject
    public DaggerUIProvider () {}

    //UIProvider getUIProvider();
}
