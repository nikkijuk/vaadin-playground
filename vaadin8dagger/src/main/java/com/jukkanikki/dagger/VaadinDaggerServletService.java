package com.jukkanikki.dagger;

import com.vaadin.server.*;

public class VaadinDaggerServletService extends VaadinServletService {

    private final CDIUIProvider cdiuiProvider;

    protected final class SessionListenerImpl implements SessionInitListener,
            SessionDestroyListener {
        @Override
        public void sessionInit(SessionInitEvent event) {
            getLogger().fine("Session init");
            event.getSession().addUIProvider(cdiuiProvider);
        }

        @Override
        public void sessionDestroy(SessionDestroyEvent event) {
            if (VaadinSessionScopedContext.guessContextIsUndeployed()) {
                // Happens on tomcat when it expires sessions upon undeploy.
                // beanManager.getPassivationCapableBean returns null for passivation id,
                // so we would get an NPE from AbstractContext.destroyAllActive
                getLogger().warning("VaadinSessionScoped context does not exist. " +
                        "Maybe application is undeployed." +
                        " Can't destroy VaadinSessionScopedContext.");
                return;
            }
            getLogger().fine("VaadinSessionScopedContext destroy");
            VaadinSessionScopedContext.destroy(event.getSession());
        }

    }

    public VaadinCDIServletService(VaadinServlet servlet,
                                   DeploymentConfiguration deploymentConfiguration)
            throws ServiceException {
        super(servlet, deploymentConfiguration);

        cdiuiProvider = BeanProvider.getContextualReference(CDIUIProvider.class, false);
        SessionListenerImpl sessionListener = new SessionListenerImpl();
        addSessionInitListener(sessionListener);
        addSessionDestroyListener(sessionListener);
    }

    private static Logger getLogger() {
        return Logger.getLogger(VaadinCDIServletService.class
                .getCanonicalName());
    }
