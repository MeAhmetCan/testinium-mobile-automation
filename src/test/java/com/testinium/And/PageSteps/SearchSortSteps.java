package com.testinium.And.PageSteps;

import com.testinium.And.Pages.SearchSortPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchSortSteps {

    private static final Logger log = LoggerFactory.getLogger(SearchSortSteps.class);

    private SearchSortPage searchSortPage = new SearchSortPage();

    @Given("Uygulama açılır.")
    public void uygulamaAcilir() {
        log.info("Uygulama açık durumda varsayılıyor.");
    }

    @And("Alt menüden Ara butonuna basılır.")
    public void altMenudenAraButonunaBasilir() {
        searchSortPage.clickSearchBottomMenu();
    }

    @And("Arama kısmına tıklanır.")
    public void aramaKismineTiklanir() {
        searchSortPage.clickSearchBox();
    }

    @And("Arama alanına hikme yazılır.")
    public void aramaAlaninaHikmeYazilir() {
        searchSortPage.typeHikmeToSearchBox();
    }

    @And("Arama alanına hikaye yazılır.")
    public void typeHikayeToSearchBox(){
        searchSortPage.typeHikayeToSearchBox();
    }
    @And("Önerilen ilk sonuç seçilir.")
    public void onerilenIlkSonucSecilir() {
        searchSortPage.clickFirstSearchSuggestion();
    }

    @And("Sırala butonuna tıklanır.")
    public void siralaButonunaTiklanir() {
        searchSortPage.clickSortButton();
    }

    @And("Pahalıdan ucuza seçeneği seçilir.")
    public void pahalidanUcuzaSecenegiSecilir() {
        searchSortPage.selectSortByExpensiveToCheap();
    }

    @And("İlk iki ürünün fiyat karşılaştırılması yapılır.")
    public void ilkIkiUrununFiyatKarsilastirilmasiYapilir() {
        searchSortPage.verifyFirstProductIsMoreExpensive();
    }

    @Then("İlk ürünün daha pahalı olması beklenir.")
    public void ilkUrununDahaPahaliOlmasiBeklenir() {
        searchSortPage.verifyFirstProductIsMoreExpensive();
    }
}
