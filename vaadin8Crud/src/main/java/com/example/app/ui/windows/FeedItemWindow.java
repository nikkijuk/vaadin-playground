package com.example.app.ui.windows;

import com.example.app.ui.model.FeedItem;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

import javax.xml.soap.Text;

public class FeedItemWindow extends Window {

    private TextField title = new TextField("Title");

    private FeedItem item;

    public FeedItemWindow() {

        HorizontalLayout layout = new HorizontalLayout();
        layout.addComponents(title);
        layout.setHeight(400, Unit.PIXELS);
        layout.setWidth(200, Unit.PIXELS);

        setContent(layout);
    }

    public void setFeedItem (FeedItem item) {
        this.item = item;
        showItem(item);
    }

    private void showItem(FeedItem item) {
        title.setValue(item.getTitle());
    }

}
