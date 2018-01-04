package com.example.app;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.example.app.ui.AppUI;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.guice.annotation.PackagesToScan;
import com.vaadin.guice.server.GuiceVaadinServlet;

/**
 * uses guice vaadin servlet as base class instead of vaadin servlet
 *
 * @WebServlet annotation defines Url of app
 *
 * @VaadinServletConfiguration defines used ui class
 *
 * @PackagesToScan defines which packages Guice scans for injections
 */
@WebServlet(urlPatterns={"/*"})
@VaadinServletConfiguration(ui = AppUI.class, productionMode = false)
@PackagesToScan("com.example.app.ui")
public class AppServlet extends GuiceVaadinServlet {}
