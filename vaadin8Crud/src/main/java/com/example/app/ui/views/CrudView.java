package com.example.app.ui.views;

import com.example.app.ui.model.FeedItem;
import com.example.app.ui.model.FeedWrapper;
import com.example.app.ui.model.Login;
import com.example.app.ui.util.FeedUtil;
import com.example.app.ui.util.HttpUtil;
import com.example.app.ui.windows.FeedItemWindow;
import com.google.inject.Inject;
import com.vaadin.data.converter.StringToBigDecimalConverter;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.guice.annotation.GuiceView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

/**
 * Extra view
 */
@GuiceView("crud") // all other views except start view need to have unique name
public class CrudView extends Panel implements View {

    private TextField feedUrl = new TextField ();
    private TextField posts = new TextField ();


    private Grid<FeedItem> feed = new Grid <> (FeedItem.class);

    @Inject
    private FeedItemWindow itemWindow;

    @Inject
    CrudView(){
        super("extra view");
        init ();
    }

    protected void init(){
        VerticalLayout layout = new VerticalLayout();

        // configure visible fields
        feed.setColumns("title","author");
        feed.addItemClickListener(this::showItem);
        feed.setSizeFull();

        layout.addComponents(feedUrl, posts, feed);
        layout.setSizeFull();
        setContent(layout);
    }

    private void showItem(Grid.ItemClick<FeedItem> feedItemItemClick) {
        FeedItem item = feedItemItemClick.getItem();
        itemWindow.setFeedItem(item);
        UI.getCurrent().addWindow(itemWindow);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        String url = FeedUtil.getUrl();
        System.out.println("url is :"+url);
        feedUrl.setValue(url);
        String json = HttpUtil.getJson(url);
        System.out.println("json is :"+json);
        FeedWrapper feedWrapper = FeedUtil.convertToObjects(json);
        int postCount = feedWrapper.getItems().size();
        System.out.println("found items :"+ postCount);
        posts.setValue(""+postCount);
        feed.setItems(feedWrapper.getItems());
    }

}
