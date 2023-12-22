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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SignUpController implements Initializable {

    @FXML
    private Button girisYap;

    @FXML
    private Button uyeOl;

    @FXML
    private TextField ad;

    @FXML
    private ImageView exitImage;

    @FXML
    private TextField kullaniciAdi;

    @FXML
    private PasswordField sifre;

    @FXML
    private TextField soyad;

    @FXML
    private RadioButton personelButton;

    @FXML
    private RadioButton standartButton;

    private static String Ad; 
    private static String Soyad; 
    private static String kullaniciTuru;
    
    private static int sayac2=1;
    
   //arttıkça üye sayısı label i artacak
     public static int getSayac2() {
         return sayac2;
     }
     
    @FXML
    void logOutSample(MouseEvent event) {
        javafx.application.Platform.exit();
    }
    
    @FXML
    private void getUser(ActionEvent event) {
        //
    }
    
    
    //uye listesine uye bilgileri eklensin
    @FXML
    void signupList(ActionEvent event)throws IOException {
        String adStr = ad.getText();
        String soyadStr = soyad.getText();
        String kullaniciAdiStr = kullaniciAdi.getText();
        String sifreStr = sifre.getText();
        String kullaniciTuru;

        // Kullanıcı türünü RadioButton'lardan al
        if (personelButton.isSelected()) {
            kullaniciTuru = "personel";
        }
        else if (standartButton.isSelected()) {
            kullaniciTuru = "standart";
        } 
        else {
            showAlert(AlertType.ERROR, "Hata", "Eksik alan", "Lütfen kullanıcı türü işaretlediğinizden emin olun.");
            return; // Hata durumunda metodu sonlandır
        }

        // Kullanıcı türüne göre dosya adını belirle
        String dosyaAdi;
        if ("personel".equals(kullaniciTuru.toLowerCase())) {
            dosyaAdi = "personelUyeListesi.txt";
        } else if ("standart".equals(kullaniciTuru.toLowerCase())) {
            dosyaAdi = "normalUyeListesi.txt";
        } else {
            showAlert(AlertType.ERROR, "Hata", "Eksik alan", "Lütfen kullanıcı türü işaretlediğinizden emin olun.");
            return; // Hata durumunda metodu sonlandır
        }
        
        setAd(adStr);// label
        setSoyad(soyadStr);//
        setKullaniciTuru(kullaniciTuru);//
        
        // Üye bilgilerini dosyaya yaz
        dosyayaYaz(dosyaAdi, adStr, soyadStr, kullaniciAdiStr, sifreStr, kullaniciTuru);
    }
    
    
    
  //label için
    public static String getAd() {
        return Ad;
    }

    public static void setAd(String Ad) {
        SignUpController.Ad = Ad;
    }
    
    public static String getSoyad() {
        return Soyad;
    }

    public static void setSoyad(String Soyad) {
        SignUpController.Soyad = Soyad;
    }
    
    
    public static String getKullaniciTuru() {
        return kullaniciTuru;
    }
    
    public static void setKullaniciTuru(String kullaniciTuru) {
    	SignUpController.kullaniciTuru = kullaniciTuru;
    }
    
    
    
    // dosyaya yazdırma metodu
    private static int siraNo = 1;
    private void dosyayaYaz(String dosyaAdi, String ad, String soyad, String kullaniciAdi, String sifre, String kullaniciTuru) {
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                if (satir.contains("Kullanıcı Adı: " + kullaniciAdi)) {
                    // Kullanıcı adı zaten varsa dosyaya eklememe durumu
                    showAlert(AlertType.INFORMATION, "Bilgi", "Üyelik Zaten Var", "Üyelik zaten bulunmaktadır.Giriş yapabilirsiniz.");
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
  
        
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true))) {
            // Üye bilgilerini dosyaya ekle
            writer.write("----------------------\n");
            writer.write(siraNo + "-");
            writer.write("Ad: " + ad + " |");
            writer.write("Soyad: " + soyad + " |");
            writer.write("Kullanıcı Adı: " + kullaniciAdi + " |");
            writer.write("Şifre: " + sifre + " |");
            writer.write("Kullanıcı Türü: " + kullaniciTuru + " |");
            writer.write("\n");

            System.out.println("Üye bilgileri dosyaya başarıyla eklendi.");
            sayac2++;
            showAlert(AlertType.INFORMATION, "Tebrikler", "Üye oldunuz", "Giriş ekranına dönünüz.");

            siraNo++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
  
    @FXML
    private void returnLogin(ActionEvent event) throws IOException {

        Parent login = FXMLLoader.load(getClass().getResource("Sample.fxml"));
        Scene loginScene = new Scene(login);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(loginScene);
        appStage.show();
    }

    public void initialize(URL url, ResourceBundle rb) {

    }

    private void showAlert(AlertType error, String string, String string2, String string3) {
        Alert alert = new Alert(error);
        alert.setTitle(string);
        alert.setHeaderText(string2);
        alert.setContentText(string3);
        alert.showAndWait();
    }
}

