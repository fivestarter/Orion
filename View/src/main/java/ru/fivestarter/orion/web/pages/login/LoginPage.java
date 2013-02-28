package ru.fivestarter.orion.web.pages.login;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.ajax.markup.html.AjaxLazyLoadPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 25.02.13
 */
public class LoginPage extends WebPage {
    private static final long serialVersionUID = 1L;

    public LoginPage(final PageParameters parameters) {
        super(parameters);

        add(new AjaxLazyLoadPanel("body-lazy") {
            @Override
            public Component getLazyLoadComponent(String id) {
                return new LoginPanel(id);
            }
        });
    }
}
