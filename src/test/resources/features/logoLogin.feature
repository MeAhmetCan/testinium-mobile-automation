Feature: Mobil Uygulama Test Senaryoları
  Background: Mobil uygulamada temel test senaryolarının çalışması

  @tag1 @tag2
  Scenario: KY_TC001_Mobil_Login Kayıtlı Kullanıcının Giriş Yapma Senaryosu
    Given Hesabım butonuna tıklanır.
    And E-posta ve şifre bilgileri girilir.
    And Giriş Yap butonuna tıklanır.

