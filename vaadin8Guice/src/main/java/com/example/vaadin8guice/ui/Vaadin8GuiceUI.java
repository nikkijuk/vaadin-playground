package com.example.vaadin8guice.ui;

import com.vaadin.data.*;
import com.vaadin.data.converter.StringToBigDecimalConverter;
import com.vaadin.guice.annotation.GuiceUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.annotations.Theme;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
// removed custom theme - using plain valo instead
@Theme("valo")
// mark ui as guice ui
@GuiceUI (content = Vaadin8GuiceContent.class, viewContainer = Vaadin8GuiceViewContainer.class)
public class Vaadin8GuiceUI extends UI{

	@Override
	protected void init(VaadinRequest request){
	}
}
