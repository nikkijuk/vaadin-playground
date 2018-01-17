package com.example.app.ui;

import com.example.app.ui.util.KaamosTheme;
import com.example.app.ui.util.SidebarLayout;
import com.example.app.ui.util.TopMenuLayout;
import com.example.app.ui.util.ViewContainer;
import com.vaadin.guice.annotation.GuiceUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.annotations.Theme;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 *
 * @Theme is used to set "kaamos" as theme
 *
 * @GuiceUI defines layout of ui and in which conmponent view is shown
 */
@Theme("kaamos") // custom theme
//@GuiceUI (content = TopMenuLayout.class, viewContainer = ViewContainer.class)
@GuiceUI (content = SidebarLayout.class, viewContainer = ViewContainer.class)
public class AppUI extends UI{

	@Override
	protected void init(VaadinRequest request){
		setStyleName(KaamosTheme.KAAMOS);
	}

}
