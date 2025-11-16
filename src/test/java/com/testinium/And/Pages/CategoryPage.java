package com.testinium.And.Pages;

import com.testinium.And.PageElement.PageElementModel;
import com.testinium.And.PageElement.TestiniumButton;
import com.testinium.And.PageElement.TestiniumLabel;
import com.testinium.And.PageElement.TestiniumTextBox;
import com.testinium.And.Util.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CategoryPage extends TestiniumMasterPage {

    private static final Logger log = LoggerFactory.getLogger(CategoryPage.class);

    private static TestiniumButton ANA_BTN_Kampanyalar =
            new TestiniumButton(PageElementModel.selectorNames.ID,
                    "com.mobisoft.kitapyurdu:id/navigation_campaigns");
    private static TestiniumButton BTN_Yayinevi_Sec = new TestiniumButton(PageElementModel.selectorNames.XPATH,"(//android.widget.RelativeLayout[@resource-id='com.mobisoft.kitapyurdu:id/containerView'])[7]");
    private static TestiniumButton BTN_Ikinci_Kampanya = new TestiniumButton(PageElementModel.selectorNames.XPATH,"//android.view.ViewGroup[@content-desc='Tübitak Yayınları’nın seçili ürünlerinde %25'e varan indirimler! ']");
    private static TestiniumLabel LBL_Yayinevi = new TestiniumLabel(PageElementModel.selectorNames.ID,"com.mobisoft.kitapyurdu:id/back_button_center_text");

    public void clickKampanyalarButonu(){
        log.info("kampanyalar butonuna tıklandı");
        ANA_BTN_Kampanyalar.click();
    }
    public void clickYayineviSecButonu(){
        BTN_Yayinevi_Sec.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        BTN_Ikinci_Kampanya.click();
    }
    public void clickKampanyaDogru() {
        // Beklenen yayınevi ismini burada sabitliyoruz.
        // İstersen ileride parametreli hale getirilebilir.
        String expectedPublisher = ConfigReader.get("category.name");

        String actualPublisher = LBL_Yayinevi.getElementText();
        log.info("Kampanya detay sayfasındaki yayınevi text: '{}'", actualPublisher);

        if (actualPublisher == null || actualPublisher.trim().isEmpty()) {
            throw new AssertionError("Yayınevi label'ı boş veya null döndü!");
        }

        // Büyük-küçük harf gibi ufak farklılıklar için contains ya da equalsIgnoreCase kullanılabilir
        if (!actualPublisher.toLowerCase().contains(ConfigReader.get("search.keyword3"))) {
            throw new AssertionError(
                    String.format(
                            "Yanlış yayınevi seçildi! Beklenen: '%s', Gerçekleşen: '%s'",
                            expectedPublisher,
                            actualPublisher
                    )
            );
        }

        log.info("Yayınevi doğru seçildi. Beklenen: '{}', Gerçekleşen: '{}'", expectedPublisher, actualPublisher);
    }
}