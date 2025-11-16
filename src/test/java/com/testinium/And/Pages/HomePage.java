package com.testinium.And.Pages;

import com.testinium.And.PageElement.PageElementModel;
import com.testinium.And.PageElement.TestiniumButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends TestiniumMasterPage {
    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    private static TestiniumButton BTN_Account = new TestiniumButton(PageElementModel.selectorNames.ID, "com.mobisoft.kitapyurdu:id/btn_ic_header_account");

    public void accountEntered(){
        log.info("Hesabım sayfasına giriş yapılıyor...");
        BTN_Account.click();
    }
}
