package com.testinium.And.PageSteps;

import com.testinium.And.Pages.FilterPage;
import com.testinium.And.Pages.SearchSortPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PriceFilterSteps {

    private static final Logger log = LoggerFactory.getLogger(PriceFilterSteps.class);

    private FilterPage filterPage = new FilterPage();

    @And("Arama alanına deger yazılır.")
    public void typeEdebiyatToSearchBox() {
        filterPage.typeEdebiyatToSearchBox();
    }

    @And("Filtre butonuna tıklanır.")
    public void clickFiltreButonu() {
        filterPage.clickFiltreButonu();

    }

    @And("Fiyat butonuna tıklnaır.")
    public void clickFiyatButonu() {
        filterPage.clickFiyatButonu();
    }

    @And("Fiyatlar seçilir.")
    public void typeFiyatBir(){
        filterPage.typeFiyatBir();
    }

    @And("Filtre tuşuna basılır.")
    public void clickFiltreUygula(){
        filterPage.clickFiltreUygula();
    }

    @And("Uygula butonuna basılır.")
    public void clickSonuclarıGoster(){
        filterPage.clickSonuclarıGoster();
    }

    @Then("Fiyatlar kontrol edilir.")
    public void fiyatıKontrolEt(){
        filterPage.fiyatıKontrolEt();
    }


}