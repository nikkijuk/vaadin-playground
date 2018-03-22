package com.jukkanikki.dagger;

import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinServletService;

public abstract class VaadinDaggerServlet extends VaadinServlet {

    private DeploymentConfiguration deploymentConfiguration;

    /**
     * Creates a vaadin servlet service.
     *
     * @param deploymentConfiguration
     *            the deployment configuration to be used
     *
     * @return the created vaadin servlet service
     *
     * @throws ServiceException
     *             if creating the vaadin servlet service fails
     */
    @Override
    protected VaadinServletService createServletService(
            DeploymentConfiguration deploymentConfiguration)
            throws ServiceException {
        this.setDeploymentConfiguration(deploymentConfiguration);
        VaadinServletService service = createVaadinServletService(deploymentConfiguration);
        service.init();
        return service;
    }

    public DeploymentConfiguration getDeploymentConfiguration() {
        return deploymentConfiguration;
    }

    protected void setDeploymentConfiguration(DeploymentConfiguration deploymentConfiguration) {
        this.deploymentConfiguration = deploymentConfiguration;
    }

    /**
     * Dependency graph creation happens here. App's should overwrite this method.
     */
    protected VaadinServletService createVaadinServletService(DeploymentConfiguration deploymentConfiguration) throws ServiceException {
        return new VaadinServletService(this, deploymentConfiguration);
    }

}
