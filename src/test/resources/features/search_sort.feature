Feature: Mobil Uygulama Test Senaryoları
  Background: Mobil uygulamada temel test senaryolarının çalışması

  @search @sort
  Scenario: KY_TC002_Mobil_Arama_Hikme_Pahalıdan_Ucuza_Sıralama_Kontrolü
    Given Uygulama açılır.
    And Alt menüden Ara butonuna basılır.
    And Arama kısmına tıklanır.
    And Arama alanına hikme yazılır.
    And Önerilen ilk sonuç seçilir.
    And Sırala butonuna tıklanır.
    And Pahalıdan ucuza seçeneği seçilir.
    And İlk iki ürünün fiyat karşılaştırılması yapılır.
    Then İlk ürünün daha pahalı olması beklenir.
