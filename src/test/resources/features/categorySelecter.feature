Feature: Mobil Uygulama Test Senaryoları
  Background: Mobil uygulamada temel test senaryolarının çalışması

  Scenario: KY_TC004_Fiyat_Karilastirmasi
    Given Uygulama açılır.
    And Kampanyalar seçilir
    And Yayınevi butonuna tıklanır.
    Then Kampanya değerinin doğruluğuna bakılır.
