package com.example.vaadin8binder;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import com.vaadin.server.VaadinServlet;

@WebServlet(
    asyncSupported=false,
    urlPatterns={"/*","/VAADIN/*"},
    initParams={
        @WebInitParam(name="ui", value="com.example.vaadin8binder.Vaadin8binderUI")
    })
public class Vaadin8binderServlet extends VaadinServlet { }
