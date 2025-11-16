package com.testinium.And.Pages;

import com.testinium.And.PageElement.PageElementModel;
import com.testinium.And.PageElement.TestiniumButton;
import com.testinium.And.PageElement.TestiniumLabel;
import com.testinium.And.PageElement.TestiniumTextBox;
import com.testinium.And.Util.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.testinium.And.Pages.SearchSortPage.ANA_TXT_SEARCH;
import static com.testinium.And.Pages.SearchSortPage.URUN_1_FIYAT;

public class FilterPage extends TestiniumMasterPage {

    private static final Logger log = LoggerFactory.getLogger(FilterPage.class);

    // Alt menü "Ara" butonu
    private static TestiniumButton ANA_BTN_Filter =
            new TestiniumButton(PageElementModel.selectorNames.ID,
                    "com.mobisoft.kitapyurdu:id/filterButton");

    private static TestiniumButton BTN_Price = new TestiniumButton(PageElementModel.selectorNames.XPATH,"(//android.view.ViewGroup[@resource-id='com.mobisoft.kitapyurdu:id/containerView'])[7]");
    private static TestiniumTextBox Fiyat_En_Az = new TestiniumTextBox(PageElementModel.selectorNames.ID,"com.mobisoft.kitapyurdu:id/editTextMinPrice");
    private static TestiniumTextBox Fiyat_En_Fazla = new TestiniumTextBox(PageElementModel.selectorNames.ID,"com.mobisoft.kitapyurdu:id/editTextMaxPrice");
    private static TestiniumButton BTN_Filtre_Uygula = new TestiniumButton(PageElementModel.selectorNames.ID,"com.mobisoft.kitapyurdu:id/btnShowProducts");
    private static TestiniumButton BTN_Sonuclari_Goster = new  TestiniumButton(PageElementModel.selectorNames.ID,"com.mobisoft.kitapyurdu:id/btnShowProducts");

    // Arama alanına "edebiyat" yaz
    public void typeEdebiyatToSearchBox() {
        log.info("Arama alanına 'edebiyat' yazılıyor.");
        ANA_TXT_SEARCH.clearText();
        ANA_TXT_SEARCH.type(ConfigReader.get("search.keyword1"));
        // Klavyeyi kapatmayalım, önerilenler listesi açık kalsın
        // hideAndroidKeyboard();
    }
    public void clickFiltreButonu(){
        log.info("filtre butonuna tıklandı");
        ANA_BTN_Filter.click();
    }

    public void clickFiyatButonu(){
        log.info("fiyat butonuna tıklanır");
        BTN_Price.click();
    }
    public void typeFiyatBir() {
        log.info("Fiyat alanına 400 yazılır");
        Fiyat_En_Az.clearText();
        Fiyat_En_Az.type(ConfigReader.get("price.min"));
        Fiyat_En_Fazla.type(ConfigReader.get("price.max"));
    }
    public void clickFiltreUygula(){
        log.info("Fiyat uygulandı");
        BTN_Filtre_Uygula.click();
    }
    public void clickSonuclarıGoster(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("sonuçları göster tüşüna basılır");
        BTN_Sonuclari_Goster.click();
    }

    public void fiyatıKontrolEt() {
        String urun1FiyatText = URUN_1_FIYAT.getElementText();
        log.info("1. ürün fiyat text: {}", urun1FiyatText);

        double urun1Fiyat = parsePrice(urun1FiyatText);

        // Doğru aralık
        double min = ConfigReader.getDouble("price.min");
        double max = ConfigReader.getDouble("price.max");

        // Eğer aralık DIŞINDA ise hata verecek
        if (!(urun1Fiyat >= min && urun1Fiyat <= max)) {
            throw new AssertionError(
                    String.format("1. ürün fiyatı aralık dışında! Beklenen %.2f - %.2f, Gerçekleşen: %.2f",
                            min, max, urun1Fiyat)
            );
        }

        log.info("1. ürün fiyatı doğru aralıkta: {}", urun1Fiyat);
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