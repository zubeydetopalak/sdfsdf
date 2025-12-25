package com.example.demo;

import org.junit.jupiter.api.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class DemoApplicationTests {

	// deneme eklendi
	
	@Test
	public void checkExampleComAccess() {
		String targetUrl = "https://example.com";
		try {
			URL url = new URL(targetUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000); // 5 saniye zaman aşımı
			connection.connect();

			int responseCode = connection.getResponseCode();

			// Eğer kod 200 değilse test başarısız olur
			assertEquals(400, responseCode, "URL erişilebilir değil! Beklenen: 200, Gelen: " + responseCode);

			System.out.println("Başarılı: " + targetUrl + " erişilebilir.");

		} catch (Exception e) {
			// Bağlantı hatası durumunda testi fail et
			fail("URL'e bağlanırken hata oluştu: " + e.getMessage());
		}
	}

}
