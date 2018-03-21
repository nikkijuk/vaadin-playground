package com.jukkanikki.dagger;

import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinServletService;

public class VaadinDaggerServlet extends VaadinServlet {

    @Override
    protected VaadinServletService createServletService(
            DeploymentConfiguration deploymentConfiguration)
            throws ServiceException {
        VaadinDaggerServletService service = new VaadinDaggerServletService(this, deploymentConfiguration);
        service.init();
        return service;
    }

}
