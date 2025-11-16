# 📱 Testinium Mobile Base Project - Cucumber Edition

Bu proje Kitapyurdu mobil uygulamasını test etmek için Cucumber + Appium tabanlı bir mobil test otomasyon frameworküdür.

## 🚀 Özellikler

- **Cucumber BDD Framework** - Gherkin syntax ile yazılmış test senaryoları
- **Appium Mobile Testing** - Android cihazlarda mobil uygulama testi
- **Page Object Model** - Sürdürülebilir ve tekrar kullanılabilir kod yapısı

## 📋 Gereksinimler

### Yazılım Gereksinimleri
- **Java 21** veya üzeri
- **Maven 3.6+**
- **Android SDK**
- **Appium Server 2.0+**
- **Node.js** (Appium için)

### Mobil Cihaz/Emülatör
- **Android Emülatör** (Pixel_5 önerilir)
- **Kitapyurdu Uygulaması** yüklü olmalı

# 📌 Test Senaryoları

Aşağıda Kitapyurdu mobil uygulaması için hazırlanan tüm otomasyon test senaryolarının detaylı açıklamaları bulunmaktadır.

---

## ⭐ 1️⃣ Yayınevi Kampanyası Doğrulama Senaryosu

**Amaç:**  
Kampanyalar bölümünde yayınevi filtrelemesinin doğru çalıştığını doğrulamak.

**Adımlar:**
1. Uygulama açılır.  
2. Alt menüden **Kampanyalar** butonuna basılır.  
3. Üst taraftaki filtreleme alanından **Yayınevi** seçilir.  
4. Listelenen kampanyalardan **2. sıradaki** kampanya seçilir.  
5. Üst bilgi alanında **doğru yayınevinin** görüntülendiği kontrol edilir.

---

## ⭐ 2️⃣ Kategori Doğrulama Senaryosu

**Amaç:**  
Arama yapılan bir ürünün kategori bilgilerinin doğru yansıyıp yansımadığını doğrulamak.

**Adımlar:**
1. Uygulama açılır.  
2. Alt menüden **Ara** butonuna tıklanır.  
3. Arama kutusuna tıklanır.  
4. **"Hikaye"** yazılır.  
5. Arama sonuçlarında en üstteki ürün seçilir.  
6. Ürün detay sayfasında yer alan **İlgili kategoriler** bölümünde “Hikaye” kelimesinin geçtiği doğrulanır.

---

## ⭐ 3️⃣ Pahalıdan Ucuza Sıralama Senaryosu

**Amaç:**  
Sıralama fonksiyonunun pahalıdan ucuza doğru şekilde çalıştığını doğrulamak.

**Adımlar:**
1. Uygulama açılır.  
2. Alt menüden **Ara** butonuna tıklanır.  
3. Arama kutusuna tıklanır.  
4. **"Otomasyon"** yazılır.  
5. **Sırala** butonuna tıklanır.  
6. **Pahalıdan Ucuza** seçeneği seçilir.  
7. İlk iki ürünün fiyatları karşılaştırılır.  
8. **İlk ürünün daha pahalı** olduğu doğrulanır.

---

## ⭐ 4️⃣ Fiyat Aralığı Filtreleme Senaryosu

**Amaç:**  
Fiyat filtresinin belirlenen aralığa göre doğru şekilde çalıştığını doğrulamak.

**Adımlar:**
1. Uygulama açılır.  
2. Alt menüden **Ara** butonuna tıklanır.  
3. Arama kutusuna tıklanır.  
4. Arama alanına **"Edebiyat"** yazılır ve enter yapılır.  
5. **Filtrele** butonuna tıklanır.  
6. **Fiyat** filtresi açılır.  
7. Minimum fiyat alanına **400** girilir.  
8. Maksimum fiyat alanına **410** girilir.  
9. **Seçimi uygula** butonuna tıklanır.  
10. **Ürünleri göster** butonuna tıklanır.  
11. Listelenen tüm ürün fiyatlarının **400 - 410** aralığında olduğu doğrulanır.

---
