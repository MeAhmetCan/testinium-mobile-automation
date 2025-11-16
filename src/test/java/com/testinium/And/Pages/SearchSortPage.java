package com.testinium.And.Pages;

import com.testinium.And.PageElement.PageElementModel;
import com.testinium.And.PageElement.TestiniumButton;
import com.testinium.And.PageElement.TestiniumLabel;
import com.testinium.And.PageElement.TestiniumTextBox;
import com.testinium.And.Util.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchSortPage extends TestiniumMasterPage {

    private static final Logger log = LoggerFactory.getLogger(SearchSortPage.class);

    // Alt menü "Ara" butonu
    private static TestiniumButton ANA_BTN_Ara =
            new TestiniumButton(PageElementModel.selectorNames.ID,
                    "com.mobisoft.kitapyurdu:id/navigation_search");

    // Arama text alanı
    public static TestiniumTextBox ANA_TXT_SEARCH =
            new TestiniumTextBox(PageElementModel.selectorNames.ID,
                    "com.mobisoft.kitapyurdu:id/searchEditText");

    // Önerilenler listesindeki ilk sonuç
    private static TestiniumButton FIRST_SUGGESTION =
            new TestiniumButton(PageElementModel.selectorNames.XPATH,
                    "//android.widget.ListView[@resource-id='com.mobisoft.kitapyurdu:id/searchListView']/android.widget.LinearLayout[1]");

    // Sırala butonu
    private static TestiniumButton BTN_Sirala =
            new TestiniumButton(PageElementModel.selectorNames.ID,
                    "com.mobisoft.kitapyurdu:id/sortButton");

    // "Pahalıdan Ucuza" seçeneği
    private static TestiniumButton BTN_PahalidanUcuza =
            new TestiniumButton(PageElementModel.selectorNames.XPATH,
                    "//android.widget.TextView[@text='Pahalıdan Ucuza']");

    // 1. ürün fiyat
    public static TestiniumLabel URUN_1_FIYAT =
            new TestiniumLabel(PageElementModel.selectorNames.XPATH,
                    "(//androidx.recyclerview.widget.RecyclerView[@resource-id='com.mobisoft.kitapyurdu:id/recycler_view']/android.view.ViewGroup[1])//android.widget.TextView[@resource-id='com.mobisoft.kitapyurdu:id/textViewLeftPrice']");

    // 2. ürün fiyat
    private static TestiniumLabel URUN_2_FIYAT =
            new TestiniumLabel(PageElementModel.selectorNames.XPATH,
                    "(//androidx.recyclerview.widget.RecyclerView[@resource-id='com.mobisoft.kitapyurdu:id/recycler_view']/android.view.ViewGroup[2])//android.widget.TextView[@resource-id='com.mobisoft.kitapyurdu:id/textViewLeftPrice']");

    // Alt menüden "Ara"ya tıkla
    public void clickSearchBottomMenu() {
        log.info("Alt menüden 'Ara' butonuna tıklanıyor.");
        ANA_BTN_Ara.click();
    }

    // Arama alanına tıkla
    public void clickSearchBox() {
        log.info("Arama text alanına tıklanıyor.");
        ANA_TXT_SEARCH.getAnElement().click();
    }

    // Arama alanına "hikme" yaz
    public void typeHikmeToSearchBox() {
        log.info("Arama alanına 'harry' yazılıyor.");
        ANA_TXT_SEARCH.clearText();
        ANA_TXT_SEARCH.type(ConfigReader.get("search.keyword4"));
        // Klavyeyi kapatmayalım, önerilenler listesi açık kalsın
        // hideAndroidKeyboard();
    }

    public void typeHikayeToSearchBox() {
        log.info("Arama alanına 'Hikaye' yazılıyor.");
        ANA_TXT_SEARCH.clearText();
        ANA_TXT_SEARCH.type(ConfigReader.get("category.name2"));
    }


    // Önerilen listeden ilk sonucu seç
    public void clickFirstSearchSuggestion() {
        log.info("Önerilen arama sonuçlarından ilkine tıklanıyor.");
        FIRST_SUGGESTION.click();
    }

    // Sırala butonuna tıkla
    public void clickSortButton() {
        log.info("'Sırala' butonuna tıklanıyor.");
        BTN_Sirala.click();
    }

    // "Pahalıdan Ucuza" seçeneğini seç
    public void selectSortByExpensiveToCheap() {
        log.info("'Pahalıdan Ucuza' seçeneği seçiliyor.");
        BTN_PahalidanUcuza.click();
    }

    // İlk 2 ürünün fiyatını karşılaştır: 1. ürün > 2. ürün beklenir
    public void verifyFirstProductIsMoreExpensive() {
        String urun1FiyatText = URUN_1_FIYAT.getElementText();
        String urun2FiyatText = URUN_2_FIYAT.getElementText();

        log.info("1. ürün fiyat text: {}", urun1FiyatText);
        log.info("2. ürün fiyat text: {}", urun2FiyatText);

        double urun1Fiyat = parsePrice(urun1FiyatText);
        double urun2Fiyat = parsePrice(urun2FiyatText);

        log.info("1. ürün fiyat numeric: {}", urun1Fiyat);
        log.info("2. ürün fiyat numeric: {}", urun2Fiyat);

        if (!(urun1Fiyat > urun2Fiyat)) {
            throw new AssertionError("Beklenen: 1. ürün fiyatı 2. üründen pahalı olmalı. " +
                    "Gerçekleşen: urun1Fiyat=" + urun1Fiyat + ", urun2Fiyat=" + urun2Fiyat);
        }
    }

    // "35,90 TL" gibi textleri double'a çeviren helper
    private double parsePrice(String priceText) {
        if (priceText == null) {
            return 0.0;
        }

        String normalized = priceText
                .replace("TL", "")
                .replace("₺", "")
                .replaceAll("[^0-9,\\.]", "")
                .trim();

        if (normalized.contains(",") && !normalized.contains(".")) {
            normalized = normalized.replace(",", ".");
        } else if (normalized.contains(",") && normalized.contains(".")) {
            normalized = normalized.replace(".", "").replace(",", ".");
        }

        try {
            return Double.parseDouble(normalized);
        } catch (NumberFormatException e) {
            log.error("Fiyat parse edilirken hata oluştu. Text: '{}'", priceText, e);
            return 0.0;
        }
    }
}
