package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SideBarController implements Initializable {
    @FXML 
    private AnchorPane anchorPane; 
    @FXML 
    private BorderPane borderPane; 
    @FXML
    private ImageView backImage;
    
    
    @FXML
    private Label labelKitapSayisi;

    @FXML
    private Label labelUyeSayisi;
   
    
    
    @FXML
    private Label usernameLabel;
    @FXML
    private Label adLabel;

    //
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
        String kullaniciAdi = SampleController.getKullaniciAdi();
        usernameLabel.setText(kullaniciAdi);
        
        int uyeSayisi = SignUpController.getSayac2();
        labelUyeSayisi.setText(Integer.toString(uyeSayisi));
        
        //
        if (adLabel != null) {
            String Ad = SignUpController.getAd();
            adLabel.setText(Ad);
        }
	}
	
	
	@FXML
	private void anasayfa(MouseEvent event) {
		borderPane.setCenter(anchorPane);
	}
	@FXML
	private void kitaplar(MouseEvent event) {
		loadPage("page1");
	}
	@FXML
	private void kitapOduncAl(MouseEvent event) {
		loadPage("page2");
	}
	@FXML
	private void kitapIadeEt(MouseEvent event) {
		loadPage("page3");
	}
	@FXML
	private void kitapEkle(MouseEvent event) {
		loadPage("page4");
		
		// labelKitapSayisina ekleme
		int kitapSayisi = kitapEkleController.getSayac();
        labelKitapSayisi.setText(Integer.toString(kitapSayisi));
		
	}
	@FXML
	private void kutuphaneBilgileri(MouseEvent event) {
		loadPage("page5");
	}
	@FXML
	private void cikis(MouseEvent event) {
		loadPage("page6");
	}
	
	private void loadPage(String page) {
		Parent root =null;
		try {
			root=FXMLLoader.load(getClass().getResource(page+".fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		borderPane.setCenter(root);
		
	}
	   @FXML
	    private void returnSample(MouseEvent event) throws IOException {
		   Parent Sample = FXMLLoader.load(getClass().getResource("Sample.fxml"));
           Scene SampleScene = new Scene(Sample);
           Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           appStage.setScene(SampleScene);
           appStage.show();
	    }
	
}
