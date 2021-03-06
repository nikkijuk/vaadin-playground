package com.jukkanikki.dagger;

import com.vaadin.server.*;
import com.jukkanikki.dagger.*;

import javax.inject.Inject;

public class VaadinDaggerServletService extends VaadinServletService {

    @Inject
    UIProvider uiProvider = null;

    protected final class SessionListenerImpl implements SessionInitListener,
            SessionDestroyListener {
        @Override
        public void sessionInit(SessionInitEvent event) {
            event.getSession().addUIProvider(uiProvider);
        }

        @Override
        public void sessionDestroy(SessionDestroyEvent event) {

            //VaadinSessionScopedContext.destroy(event.getSession());
        }

    }

    public VaadinDaggerServletService(VaadinServlet servlet,
                                      DeploymentConfiguration deploymentConfiguration)
            throws ServiceException {
        super(servlet, deploymentConfiguration);

        AppComponent component = DaggerAppComponent.builder()
                .vaadinDaggerModule(new VaadinDaggerModule())
                .build();

        uiProvider = component.getUIProvider();

        // init and destroy logic
        SessionListenerImpl sessionListener = new SessionListenerImpl();
        addSessionInitListener(sessionListener);
        addSessionDestroyListener(sessionListener);
    }

}
