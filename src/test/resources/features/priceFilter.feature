Feature: Mobil Uygulama Test Senaryoları
  Background: Mobil uygulamada temel test senaryolarının çalışması

  Scenario: KY_TC003_Fiyat_Karilastirmasi
    Given Uygulama açılır.
    And Alt menüden Ara butonuna basılır.
    And Arama kısmına tıklanır.
    And Arama alanına deger yazılır.
    And Önerilen ilk sonuç seçilir.
    And Filtre butonuna tıklanır.
    And Fiyat butonuna tıklnaır.
    And Fiyatlar seçilir.
    And Uygula butonuna basılır.
    Then Fiyatlar kontrol edilir.
