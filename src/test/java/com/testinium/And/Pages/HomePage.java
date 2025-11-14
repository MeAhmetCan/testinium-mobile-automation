package com.testinium.And.Pages;

import com.testinium.And.PageElement.PageElementModel;
import com.testinium.And.PageElement.TestiniumButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends TestiniumMasterPage {
    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    private static TestiniumButton BTN_Giris = new TestiniumButton(PageElementModel.selectorNames.ID, "//android.view.ViewGroup[@content-desc='Giriş']");


}
