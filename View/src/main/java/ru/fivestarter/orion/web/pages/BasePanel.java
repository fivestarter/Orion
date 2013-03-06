package ru.fivestarter.orion.web.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import ru.fivestarter.orion.web.pages.diary.DiaryPanel;
import ru.fivestarter.orion.web.pages.plan.PlanPanel;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 22.02.13
 */
public class BasePanel extends Panel {

    /**
     * Tabbed panel
     */
    private TabbedPanel tabbedPanel;
    /**
     * Tabs
     */
    private List<ITab> tabs;
    private Panel diaryPanel;
    private Panel planPanel;

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

        /**
         * add TabPanel
         */
        bmc.add(getTabbedPanel());
    }

    public TabbedPanel getTabbedPanel() {
        if (tabbedPanel == null) {

            tabbedPanel = new AjaxTabbedPanel<ITab>("tabs", getTabs());
        }
        return tabbedPanel;
    }

    public List<ITab> getTabs() {
        if (tabs == null) {
            tabs = new ArrayList<ITab>();

            /**
             * Associations tabbed panel
             */
            tabs = new ArrayList<ITab>();

            tabs.add(new AbstractTab(new Model<String>("Diary")) {
                private static final long serialVersionUID = 1L;
                @Override
                public Panel getPanel(String panelId) {
                    return getDiaryPanel(panelId);
                }

            });

            tabs.add(new AbstractTab(new Model<String>("Plan")) {
                private static final long serialVersionUID = 1L;
                @Override
                public Panel getPanel(String panelId) {
                    return getPlanPanel(panelId);
                }

            });

        }
        return tabs;
    }

    private Panel getDiaryPanel(String panelId) {
        if (diaryPanel == null) {
            diaryPanel = new DiaryPanel(panelId);
        }
        return diaryPanel;
    }

    private Panel getPlanPanel(String panelId) {
        if (planPanel == null) {
            planPanel = new PlanPanel(panelId);
        }
        return planPanel;
    }
}
