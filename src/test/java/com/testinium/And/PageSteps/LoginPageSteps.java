package com.testinium.And.PageSteps;

import com.testinium.And.Pages.HomePage;
import com.testinium.And.Pages.LoginPage;
import com.testinium.And.Pages.TestiniumMasterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPageSteps extends TestiniumMasterPage {
    private static final Logger log = LoggerFactory.getLogger(HomePageSteps.class);

    LoginPage loginPage=new LoginPage();

    @And("E-posta ve şifre bilgileri girilir.")
    public void accountEnteredStep() {
        log.info("Kayıtlı kullanıcı bilgileri dolduruluyor...");
        loginPage.loginFillForm();
    }
    @And("Giriş Yap butonuna tıklanır.")
    public void loginButtonMethod(){
        log.info("Giriş yap butonuna tıklanıyor...");
        loginPage.loginButtonClick();
    }
}
