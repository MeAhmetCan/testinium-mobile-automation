package com.testinium.And.Pages;

import com.testinium.And.PageElement.PageElementModel;
import com.testinium.And.PageElement.TestiniumButton;
import com.testinium.And.PageElement.TestiniumTextBox;
import com.testinium.And.Util.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private static TestiniumTextBox TXT_Email = new TestiniumTextBox(PageElementModel.selectorNames.XPATH, "(//android.widget.EditText[@resource-id=\"com.mobisoft.kitapyurdu:id/inputEditText\"])[1]");
    private static TestiniumTextBox TXT_Password = new TestiniumTextBox(PageElementModel.selectorNames.XPATH, "(//android.widget.EditText[@resource-id=\"com.mobisoft.kitapyurdu:id/inputEditText\"])[2]");
    private static TestiniumButton BTN_Login=new TestiniumButton(PageElementModel.selectorNames.ID, "com.mobisoft.kitapyurdu:id/btnLogin");

    public void loginFillForm(){
        log.info("Hesap bilgileri dolduruluyor...");
        TXT_Email.type(ConfigReader.get("User.email"));
        TXT_Password.type(ConfigReader.get("User.password"));
    }
    public void loginButtonClick(){
        log.info("Giriş yap butonuna tıklanıyor...");
        BTN_Login.click();
    }
}
