package application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SampleController {
	
	
    @FXML
    private Button GirisYapButton;

    @FXML
    private TextField kullaniciAdiTextField;

    private static String kullaniciAdi;//label için
    private static String sifre;
    
    @FXML
    private TextField sifreTextField;

    @FXML
    private ImageView exitImage;

    @FXML
    private Button hemenUyeOlButton;

    @FXML
    private void login(ActionEvent event) throws IOException {
    	 String dogruKullaniciAdi = "zey";
         String dogruSifre = "1";

         String girilenKullaniciAdi = kullaniciAdiTextField.getText();
         String girilenSifre = sifreTextField.getText();

         // Kullanıcı adı ve şifre doğruysa veya üye ise SideBar.fxml'e geçiş yapın
         if ((dogruKullaniciAdi.equals(girilenKullaniciAdi) && dogruSifre.equals(girilenSifre))
                 || isUserRegistered(girilenKullaniciAdi, "personelUyeListesi.txt")
                 || isUserRegistered(girilenKullaniciAdi, "normalUyeListesi.txt")) {

             Parent SideBar = FXMLLoader.load(getClass().getResource("SideBar.fxml"));
             Scene SideBarScene = new Scene(SideBar);
             Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             appStage.setScene(SideBarScene);
             appStage.show();
             System.out.println("üye bilgileri var mı kontrol eden metod çalışıyor");
         } 
         else {
             showAlert(AlertType.ERROR, "Hata", "Üye bulunamadı", "Kullanıcı kayıtlı değil lütfen önce üye olun ");
         }
         
         setKullaniciAdi(girilenKullaniciAdi);//label
         setSifre(girilenSifre);//
    }
    
    
    //başka sayfada label kullanmak icin
    public static String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public static void setKullaniciAdi(String kullaniciAdi) {
        SampleController.kullaniciAdi = kullaniciAdi;
    }
    
    //
    public static String getSifre() {
        return sifre;
    }
    public static void setSifre(String sifre) {
        SampleController.sifre = sifre;
    }
  
    
    
	private boolean isUserRegistered(String kullaniciAdi, String dosyaAdi) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            while ((satir = bufferedReader.readLine()) != null) {
                if (satir.contains(kullaniciAdi)) {
                	System.out.println("Kullanıcı adı dosyada bulunuyor");
                    return true;
                    
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
	

    private void showAlert(AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void logOutSample(MouseEvent event) {
        javafx.application.Platform.exit();
    }

    @FXML
    private void hemenUyeOl(ActionEvent event) {
        try {
            Parent SignUp = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Scene SignUpScene = new Scene(SignUp);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(SignUpScene);
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


