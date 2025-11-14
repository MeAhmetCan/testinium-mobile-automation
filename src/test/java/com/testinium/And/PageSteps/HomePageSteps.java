package com.testinium.And.PageSteps;

import com.testinium.And.PageElement.PageElementModel;
import com.testinium.And.PageElement.TestiniumButton;
import com.testinium.And.Pages.TestiniumMasterPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageSteps extends TestiniumMasterPage {
    private static final Logger log = LoggerFactory.getLogger(HomePageSteps.class);

    private static TestiniumButton BTN_Giris = new TestiniumButton(PageElementModel.selectorNames.ID, "//android.view.ViewGroup[@content-desc='Giriş']");


}
