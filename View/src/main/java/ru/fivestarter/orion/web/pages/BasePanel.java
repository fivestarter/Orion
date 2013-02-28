package ru.fivestarter.orion.web.pages;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 22.02.13
 */
public class BasePanel extends Panel {

    private boolean errorMessage = false;

    public BasePanel(String id) {
        super(id);

        this.errorMessage = errorMessage;

        WebMarkupContainer hmc = new WebMarkupContainer("header-markup-container") {
            @Override
            public boolean isVisible() {
                return !BasePanel.this.errorMessage;
            }
        };

        WebMarkupContainer bmc = new WebMarkupContainer("body-markup-container") {
            @Override
            public boolean isVisible() {
                return !BasePanel.this.errorMessage;
            }
        };

        add(hmc);
        add(bmc);

        WebMarkupContainer emc = new WebMarkupContainer("error-markup-container") {
            /**
             * Gets whether this component and any children are visible.
             * <p/>
             * WARNING: this method can be called multiple times during a request. If you override this
             * method, it is a good idea to keep it cheap in terms of processing. Alternatively, you can
             * call {@link #setVisible(boolean)}.
             * <p/>
             *
             * @return True if component and any children are visible
             */
            @Override
            public boolean isVisible() {
                return BasePanel.this.errorMessage;
            }
        };

        add(emc);
    }
}
