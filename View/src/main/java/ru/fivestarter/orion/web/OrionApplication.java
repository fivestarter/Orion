package ru.fivestarter.orion.web;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;

import ru.fivestarter.orion.web.pages.BasePage;
import ru.fivestarter.orion.web.pages.login.LoginPage;
import ru.fivestarter.orion.web.pages.login.OrionSession;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 21.02.13
 */
public class OrionApplication extends AuthenticatedWebApplication {
    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return OrionSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return LoginPage.class;
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return BasePage.class;
    }

    @Override
    public RuntimeConfigurationType getConfigurationType() {
        return RuntimeConfigurationType.DEVELOPMENT;
    }
}
