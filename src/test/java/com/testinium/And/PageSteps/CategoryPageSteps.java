package com.testinium.And.PageSteps;

import com.testinium.And.Pages.CategoryPage;
import com.testinium.And.Pages.FilterPage;
import com.testinium.And.Pages.SearchSortPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryPageSteps {

    private static final Logger log = LoggerFactory.getLogger(CategoryPageSteps.class);

    private CategoryPage categoryPage = new CategoryPage();

    @And("Kampanyalar seçilir")
    public void clickKampanyalarButonu() {
        categoryPage.clickKampanyalarButonu();
    }

    @And("Yayınevi butonuna tıklanır.")
    public void clickYayineviSecButonu() {
        categoryPage.clickYayineviSecButonu();

    }

    @Then("Kampanya değerinin doğruluğuna bakılır.")
    public void clickKampanyaDogru() {
        categoryPage.clickKampanyaDogru();
    }




}