package com.example.vaadin8guice;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.example.vaadin8guice.ui.Vaadin8GuiceUI;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.guice.annotation.PackagesToScan;
import com.vaadin.guice.server.GuiceVaadinServlet;


@WebServlet(urlPatterns={"/*"})
@VaadinServletConfiguration(ui = Vaadin8GuiceUI.class, productionMode = false)
@PackagesToScan("com.example.vaadin8guice.ui")
public class Vaadin8GuiceServlet extends GuiceVaadinServlet {
    // uses guice vaadin servlet as base class instead of vaadin servlet
}
