package com.example.app.ui.util;

import com.vaadin.navigator.ViewChangeListener;

import java.util.logging.Logger;

/**
 * Logger for view change events
 */
public class LoggingViewChangeListener implements ViewChangeListener {

    @Override
    public boolean beforeViewChange(ViewChangeEvent viewChangeEvent) {
        Logger.getAnonymousLogger().info("changing view to " + viewChangeEvent.getViewName());
        return true;
    }

}
