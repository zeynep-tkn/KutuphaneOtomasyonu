package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CikisController implements Initializable {
	
	
	@FXML
    private Button exitButton;

    @FXML
    void logOut(ActionEvent event) {
      javafx.application.Platform.exit();
    }
    
   
    @FXML
    private Label adLabel;

    @FXML
    private Label kullaniciAdiLabel;

    @FXML
    private Label kullaniciTuruLabel;

    @FXML
    private Label soyadLabel;
    
    @FXML
    private Label sifreLabel;

    @FXML
    private Label oduncKitapLabel;

    

    public void initialize(URL url, ResourceBundle rb) {
        if (kullaniciAdiLabel != null) {
            String kullaniciAdi = SampleController.getKullaniciAdi();
            kullaniciAdiLabel.setText(kullaniciAdi);
            
            
            //label e ödünç alınan kitapları ekle
            String oduncAlinanKitaplar = getOduncAlinanKitaplar(kullaniciAdi);
            oduncKitapLabel.setText(oduncAlinanKitaplar);
        }
        
        if (sifreLabel != null) {
            String sifre = SampleController.getSifre();
            sifreLabel.setText(sifre);
        }
        
        if (adLabel != null) {
            String Ad = SignUpController.getAd();
            adLabel.setText(Ad);
        }
        
        if (soyadLabel != null) {
            String Soyad = SignUpController.getSoyad();
            soyadLabel.setText(Soyad);
        }
      
        if (kullaniciTuruLabel != null) {
            String kullaniciTuru = SignUpController.getKullaniciTuru();
            kullaniciTuruLabel.setText(kullaniciTuru);
        }
    }
	
    
    
    
    //label e odunc alınan kitapları ekle metodu
    private String getOduncAlinanKitaplar(String kullaniciAdi) {
        String dosyaAdi = "oduncAlinanKitapListesi.txt";
        StringBuilder kitaplar = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                // Dosyadaki her bir satırı kontrol et
                if (satir.contains("Kullanıcı Adı: " + kullaniciAdi)) {
                    // Eğer kullanıcı adı eşleşiyorsa kitap adını al ve stringe ekle
                    String kitapAdi = getKitapAdiFromSatir(satir);
                    kitaplar.append(kitapAdi).append(", ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // StringBuilder'dan String'e çevirirken sonundaki virgülü kaldır
        if (kitaplar.length() > 2) {
            kitaplar.setLength(kitaplar.length() - 2);
        }

        return kitaplar.toString();
    }

    private String getKitapAdiFromSatir(String satir) {
        
        String[] parcalar = satir.split("\\|");
        for (String parca : parcalar) {
            // Kitap adını içeren parçayı bul
            if (parca.contains("Kitap Adı:")) {
                // Boşlukları temizle ve kitap adını al
                return parca.replace("Kitap Adı:", "").trim();
            }
        }
        return "";
    }
    
	
	//ÖDÜNÇ AL/PAGE2 sayfasının controllerı
    
    
	@FXML
    private TextField kitapAdiText;

    @FXML
    private TextField kullaniciAdiText;

    @FXML
    private Button oduncAlButton;

   
    @FXML
    void OduncAl(ActionEvent event) {
    	// Kullanıcı adı ve kitap adı alınır
    	int siraNosu = 1; 
        String kullaniciAdi = kullaniciAdiText.getText();
        String kitapAdi = kitapAdiText.getText();

        // Dosya adı
        String dosyaAdi = "oduncAlinanKitapListesi.txt";

        try {
            // Dosyaya yazma işlemi için FileWriter ve BufferedWriter kullanılır
            FileWriter dosyaYazici = new FileWriter(dosyaAdi, true);
            BufferedWriter yaz = new BufferedWriter(dosyaYazici);

            // Kullanıcı adı ve kitap adı dosyaya eklenir
            
            yaz.write("----------------------\n");
        	yaz.write(siraNosu + "-");
            yaz.write("Kullanıcı Adı: " + kullaniciAdi + " |"+" Kitap Adı: " + kitapAdi+"\n");
            yaz.newLine();

            // Kaynakları serbest bırak
            yaz.close();
            dosyaYazici.close();

            // Başarı mesajı göster
            System.out.println("Kitap başarıyla ödünç alındı: " + kitapAdi);
            siraNosu++;
           
           
            Alert alert = new Alert(AlertType.INFORMATION, kitapAdi+"  Kitabı başarıyla ödünç alındı ", ButtonType.OK);
            alert.showAndWait();

        } catch (IOException e) {
  
            e.printStackTrace();
            System.out.println("Bir hata oluştu, kitap ödünç alınamadı.");

    
            Alert alert = new Alert(AlertType.ERROR, "Bir hata oluştu, kitap ödünç alınamadı.", ButtonType.OK);
            alert.showAndWait();
        }
    }
    
 
}
