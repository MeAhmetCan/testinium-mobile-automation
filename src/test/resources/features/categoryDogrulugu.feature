Feature: Mobil Uygulama Test Senaryoları
  Background: Mobil uygulamada temel test senaryolarının çalışması

  Scenario: KY_TC005_Fiyat_Karilastirmasi
    Given Uygulama açılır.
    And Alt menüden Ara butonuna basılır.
    And Arama alanına hikaye yazılır.
    And Önerilen ilk sonuç seçilir.
    And Kitap detayına gidilir.
    Then Kategori adı kontrol edilir.
