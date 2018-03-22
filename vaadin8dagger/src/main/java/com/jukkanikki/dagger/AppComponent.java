package com.jukkanikki.dagger;

import com.vaadin.server.UIProvider;
import dagger.Component;
import dagger.Provides;

@Component(modules=VaadinDaggerModule.class)
public interface AppComponent {

    UIProvider getUIProvider();

}