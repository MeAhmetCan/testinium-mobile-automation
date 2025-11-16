package com.testinium.And.PageSteps;

import com.testinium.And.Pages.BookPage;
import com.testinium.And.Pages.CategoryPage;
import com.testinium.And.Pages.FilterPage;
import com.testinium.And.Pages.SearchSortPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookPageSteps {

    private static final Logger log = LoggerFactory.getLogger(BookPageSteps.class);

    private BookPage bookPage = new BookPage();

    @And("Kitap detayına gidilir.")
    public void clickKitapDetay() {
        bookPage.clickKitapDetay();
    }

    @Then("Kategori adı kontrol edilir.")
    public void kategoriAdiDogru() {
        bookPage.kategoriAdiDogru();

    }

}