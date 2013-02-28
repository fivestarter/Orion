package ru.fivestarter.orion.web.pages.login;

import org.apache.wicket.authroles.authentication.panel.SignInPanel;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 25.02.13
 */
public class LoginPanel extends Panel {

    public LoginPanel(String id) {
        super(id);
        add(new SignInPanel("signInPanel"));
    }
}
