package com.jukkanikki.dagger;

import com.vaadin.server.UIProvider;
import dagger.Provides;
import dagger.Module;

@Module
public class VaadinDaggerModule {

    @Provides
    public UIProvider getUIProvider(){
        return new DaggerUIProvider ();
    }

}
