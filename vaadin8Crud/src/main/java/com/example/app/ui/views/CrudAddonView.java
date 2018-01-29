package com.example.app.ui.views;

import com.example.app.ui.model.FeedItem;
import com.example.app.ui.model.FeedWrapper;
import com.example.app.ui.util.FeedUtil;
import com.example.app.ui.util.HttpUtil;
import com.example.app.ui.windows.FeedItemWindow;
import com.google.inject.Inject;
import com.vaadin.guice.annotation.GuiceView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.impl.form.factory.GridLayoutCrudFormFactory;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;

import java.util.List;

/**
 * Extra view
 *
 * https://vaadin.com/directory/component/crud-ui-add-on
 */
@GuiceView("crud-addon") // all other views except start view need to have unique name
public class CrudAddonView extends Panel implements View {

    private GridCrud<FeedItem> feed = new GridCrud <> (FeedItem.class, new HorizontalSplitCrudLayout());

    @Inject
    CrudAddonView(){
        super("crud addon view");
        init ();
    }

    protected void init(){
        VerticalLayout layout = new VerticalLayout();

        // define how items are retrieved
        feed.setFindAllOperation(() -> getFeedItems());

        // configure visible fields for grid
        feed.getGrid().setColumns("title","author");

        // define how master-detail view is shown
        GridLayoutCrudFormFactory<FeedItem> formFactory = new GridLayoutCrudFormFactory<>(FeedItem.class, 2, 2);

        // use validation, not needed now since we can't edit data anyway
        //formFactory.setUseBeanValidation(true);

        // define which fields are shown when data is read
        formFactory.setVisibleProperties(CrudOperation.READ, "title", "author");

        // set form factory in use
        feed.setCrudFormFactory(formFactory);

        feed.setSizeFull();

        layout.addComponents(feed);
        layout.setSizeFull();
        setContent(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    /**
     * Get items over network
     *
     * @return list of items
     */
    private List<FeedItem> getFeedItems() {
        String url = FeedUtil.getUrl();
        String json = HttpUtil.getJson(url);
        FeedWrapper feedWrapper = FeedUtil.convertToObjects(json);
        List<FeedItem> items = feedWrapper.getItems();
        return items;
    }

}
