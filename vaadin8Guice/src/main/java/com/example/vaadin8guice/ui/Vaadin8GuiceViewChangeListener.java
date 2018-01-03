package com.example.vaadin8guice.ui;

import com.vaadin.navigator.ViewChangeListener;

import java.util.logging.Logger;

/**
 * Logger for view change events
 */
public class Vaadin8GuiceViewChangeListener implements ViewChangeListener {

    @Override
    public boolean beforeViewChange(ViewChangeEvent viewChangeEvent) {
        Logger.getAnonymousLogger().info("changing view to " + viewChangeEvent.getViewName());
        return true;
    }

}
