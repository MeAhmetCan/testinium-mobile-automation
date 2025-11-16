package com.testinium.And.Pages;

import com.testinium.And.PageElement.PageElementModel;
import com.testinium.And.PageElement.TestiniumButton;
import com.testinium.And.PageElement.TestiniumLabel;
import com.testinium.And.PageElement.TestiniumTextBox;
import com.testinium.And.Util.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class BookPage extends TestiniumMasterPage {

    private static final Logger log = LoggerFactory.getLogger(BookPage.class);

    private static TestiniumButton BTN_Kitap_Detay = new TestiniumButton(PageElementModel.selectorNames.XPATH,"(//android.widget.RelativeLayout[@content-desc='İki Şehrin Hikayesi'])[1]");
    private static TestiniumLabel LBL_Kategori_Adi = new TestiniumLabel(PageElementModel.selectorNames.XPATH,"//android.widget.TextView[@resource-id='com.mobisoft.kitapyurdu:id/textViewCategory' and @text='Kitap > Edebiyat > Roman (Çeviri)']");
    public void clickKitapDetay(){
        log.info("kitaba tıklandı");
        BTN_Kitap_Detay.click();
    }
    public void kategoriAdiDogru() {
        String kategoriText = LBL_Kategori_Adi.getElementText();
        log.info("Kategori text: {}", kategoriText);

        if (kategoriText == null || kategoriText.trim().isEmpty()) {
            throw new AssertionError("Kategori alanı boş ya da null döndü!");
        }

        // Sadece "Edebiyat" geçiyor mu onu kontrol ediyoruz
        if (!kategoriText.contains(ConfigReader.get("search.keyword1"))) {
            throw new AssertionError(
                    String.format(
                            "Kategori bilgisi hatalı! 'Edebiyat' içermesi bekleniyordu. Gelen text: '%s'",
                            kategoriText
                    )
            );
        }

        log.info("Kategori alanı doğru. 'Edebiyat' ifadesi kategori içinde geçiyor.");
    }

}


