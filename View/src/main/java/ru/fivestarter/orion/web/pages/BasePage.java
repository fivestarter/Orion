package ru.fivestarter.orion.web.pages;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.ajax.markup.html.AjaxLazyLoadPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 22.02.13
 */
public class BasePage extends WebPage {

    private static final long serialVersionUID = 1L;

    public BasePage(final PageParameters parameters) {
        super(parameters);

        add(new AjaxLazyLoadPanel("body-lazy") {
            @Override
            public Component getLazyLoadComponent(String id) {
                return new BasePanel(id);
            }
        });
    }
}
