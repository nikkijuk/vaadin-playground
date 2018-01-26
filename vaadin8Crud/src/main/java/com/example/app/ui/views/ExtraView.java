package com.example.app.ui.views;

import com.example.app.ui.model.FeedItem;
import com.example.app.ui.model.FeedWrapper;
import com.example.app.ui.model.Login;
import com.example.app.ui.util.FeedUtil;
import com.example.app.ui.util.HttpUtil;
import com.google.inject.Inject;
import com.vaadin.data.converter.StringToBigDecimalConverter;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.guice.annotation.GuiceView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Extra view
 */
@GuiceView("extra") // all other views except start view need to have unique name
public class ExtraView extends Panel implements View {

    private TextField feedUrl = new TextField ();


    private Grid<FeedItem> feed = new Grid <> ();

    @Inject
    ExtraView(){
        super("extra view");
        init ();
    }

    protected void init(){
        VerticalLayout layout = new VerticalLayout();
        layout.addComponents(feedUrl, feed);
        setContent(layout);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        String url = FeedUtil.getUrl();
        System.out.println("url is :"+url);
        feedUrl.setValue(url);
        String json = HttpUtil.getJson(url);
        System.out.println("json is :"+json);
        FeedWrapper feedWrapper = FeedUtil.convertToObjects(json);
        System.out.println("found items :"+feedWrapper.getItems().size());
        feed.setItems(feedWrapper.getItems());
    }

}
