package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class kitapEkleController implements Initializable{
	@FXML
    private ComboBox<String> comboBox;
	
	// kitap sayısı labeli arttıracak
	private static int sayac=85;
    @FXML
    private TextField kitapAdi;

    @FXML
    private Button kitapEkleButton;

    @SuppressWarnings("exports")
	@FXML
    public TextField personelAdi;

    @FXML
    private PasswordField personelSifre;

    @FXML
    private TextField sayfaSayisi;

    @FXML
    private TextField yazarAdi;

    //
    public static int getSayac() {
        return sayac;
    }
    
    
	@FXML
    void Select(ActionEvent event) {
		//kitap tür seçimi için 
		
    }
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		ObservableList<String> list= FXCollections.observableArrayList("roman","hikaye","şiir","biyografi",
		"otobiyografi","deneme","seyehatname","günlük","distopik","kurgu","diğer");
		comboBox.setItems(list);
	}
	
	@FXML
	void kitapEkle(ActionEvent event) {
	    String personelAdiStr = personelAdi.getText();
	    String personelSifreStr = personelSifre.getText();

	    // Kullanıcı adı ve şifre kontrolü
	    if (personelKontrol(personelAdiStr, personelSifreStr)) {

	        String turu = comboBox.getValue();
	        String kitapAdiStr = kitapAdi.getText();
	        String yazarAdiStr = yazarAdi.getText();
	        int sayfaSayisiInt = Integer.parseInt(sayfaSayisi.getText());

	        // Kitap bilgilerini içeren Books nesnesini oluştur
	        Books kitap = new Books(kitapAdiStr, yazarAdiStr, sayfaSayisiInt, turu);

	        
	        if (!kitapZatenEkli(kitap)) {
	            // Kitap bilgilerini dosyaya yaz
	            dosyayaYaz(kitap);
	        } else {
	            // Kitap zaten ekliyse hata mesajı göster
	            showAlert(AlertType.ERROR, "Hata", "Kitap Zaten Ekli", "Bu kitap zaten kitap listesinde bulunmaktadır.");
	        }
	    } else {
	        // Kullanıcı adı ve/veya şifre yanlışsa hata mesajı göster
	        showAlert(AlertType.ERROR, "Hata", "Yetkisiz Kullanıcı", "Kitap eklemek için yetkiniz yok.");
	    }
	}

	private boolean kitapZatenEkli(Books kitap) {
	    try (BufferedReader reader = new BufferedReader(new FileReader("kitapListesi.txt"))) {
	        String satir;
	        while ((satir = reader.readLine()) != null) {
	            // Dosyadaki her bir satırı kontrol et
	            if (satir.contains("Kitap Adı: " + kitap.getKitapAdi()) && satir.contains("Yazar Adı: " + kitap.getYazarAdi())) {
	                // Eğer kitap adı ve yazar adı eşleşiyorsa kitap zaten ekli
	                return true;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	   
	    return false;
	}



	// Personel kontrolü yapan metod
	private boolean personelKontrol(String personelAdi, String personelSifre) {
	    try (BufferedReader reader = new BufferedReader(new FileReader("personelUyeListesi.txt"))) {
	        String satir;
	        while ((satir = reader.readLine()) != null) {
	            // Dosyadaki her bir satırı kontrol et
	            if (satir.contains("Kullanıcı Adı: " + personelAdi) && satir.contains("Şifre: " + personelSifre)) {
	                // Eğer personel kullanıcı adı ve şifre doğruysa true döndür
	                return true;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // Personel kullanıcı adı ve/veya şifre yanlışsa false döndür
	    return false;
	}

	
	
	
	 //Dosyaya kitap yazma 
	private static int siraNosu = 1; 
	private void dosyayaYaz(Books kitap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("kitapListesi.txt", true))) {
            // Kitap bilgilerini dosyaya ekle
        	writer.write("----------------------\n");
        	writer.write(siraNosu + "-");
            writer.write("Kitap Adı: " + kitap.getKitapAdi()+ "|");
            writer.write("Yazar Adı: " + kitap.getYazarAdi() + "|");
            writer.write("Sayfa Sayısı: " + kitap.getSayfaSayisi() + "|");
            writer.write("Türü: " + kitap.getTuru() + "|");
            writer.write("\n");

            System.out.println("Kitap bilgileri dosyaya başarıyla eklendi.");
            sayac++;
            showAlert(AlertType.INFORMATION, "Tebrikler", "Kitap", "eklendi.");
            siraNosu++;
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	private void showAlert(AlertType error, String string, String string2, String string3) {
        Alert alert = new Alert(error);
        alert.setTitle(string);
        alert.setHeaderText(string2);
        alert.setContentText(string3);
        alert.showAndWait();
    }

}

