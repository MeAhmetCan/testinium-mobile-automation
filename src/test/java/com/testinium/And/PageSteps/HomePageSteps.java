package com.testinium.And.PageSteps;

import com.testinium.And.PageElement.PageElementModel;
import com.testinium.And.PageElement.TestiniumButton;
import com.testinium.And.Pages.HomePage;
import com.testinium.And.Pages.LandingPage;
import com.testinium.And.Pages.TestiniumMasterPage;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageSteps extends TestiniumMasterPage {
    private static final Logger log = LoggerFactory.getLogger(HomePageSteps.class);

    HomePage homePage=new HomePage();


    @Given("Hesabım butonuna tıklanır.")
    public void accountEnteredStep() {
        log.info("Örnek test case'i çalıştırılıyor...");
        homePage.accountEntered();
    }

}
