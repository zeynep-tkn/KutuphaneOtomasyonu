package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

	public class Page1Controller implements Initializable {
		    @FXML
		    private TableView<Books> table;
		
		    @FXML
		    private TableColumn<Books,String> kitapAdi;

		    @FXML
		    private TableColumn<Books,Integer> sayfaSayisi;

		    @FXML
		    private TableColumn<Books,String> turu;

		    @FXML
		    private TableColumn<Books,String> yazarAdi;
		    
		    
           /*
		    @FXML
		    private Button searchButton; 
		    
		    @FXML
		    private TextField searchBar;
		    */
		    
		    ObservableList<Books> list =FXCollections.observableArrayList(
		    		
		    		new Books("Sefiller","Victor Hugo",302,"roman"),
		    		new Books("Notre-Dame'ın Kamburu","Victor Hugo",656,"roman"),
		    		new Books("Suç ve Ceza","Dostoyevski",592,"roman"),
		    		new Books("Yüzyılın Yalnızlığı", "Gabriel Garcia Marquez", 350, "roman"),
		    		new Books("Kasım", "Ayşe Kulin", 320, "roman"),
		    		new Books("Sonbahar Rüzgarları", "Canan Tan", 280, "roman"),
		    		new Books("İki Şehrin Hikayesi", "Charles Dickens", 400, "roman"),
		    		new Books("Gökyüzüne Notlar", "Paulo Coelho", 250, "roman"),
		    		new Books("Erenlerin Bağından","Yakup Kadri Karaosmaoğlu",84,"şiir"),
		    		new Books("Evliya Çelebi Seyahatnamesi","Evliya Çelebi",230,"seyehatname"),
		    		new Books("Aşk ve Gurur", "Jane Austen", 350, "roman"),
		    		new Books("Beyaz Diş", "Jack London", 200, "roman"),
		    		new Books("Kürk Mantolu Madonna", "Sabahattin Ali", 180, "roman"),
		    		new Books("Don Kişot","Ceravntes",495,"roman"),
		    		new Books("Efruz Bey","Ömer Seyfettin",222,"hikaye"),
		    		new Books("Edebiyatçılar Geçiyor","Halit Fahri Ozansoy",230,"biyografi"),
		    		new Books("Eğil Dağlar","Yahya Kemal Beyatlı",299,"otobiyografi"),
		    		new Books("Ehemmiyetsiz Bir Kadın","Oscar Wilde",105,"roman"),
		    		new Books("Evliya Çelebi Seyahatnamesi 2","Evliya Çelebi",245,"seyehatname"),
		    		new Books("Evliya Çelebi Seyahatnamesi 3","Evliya Çelebi",320,"seyehatname"),
		    		new Books("Oblomov","İvan Gonçarov",632,"roman"),
		    		new Books("Gün Olur Asra Bedel","Cengiz Aytmatov",426,"roman"),
		    		new Books("Mavi Saçlı Kız","Burak Çerezcioğlu",230,"günlük"),
		    		new Books("Yedi Güzel Adam","Cahit Zarifoğlu",136,"şiir"),
		    		new Books("Kayıp Tanrılar Ülkesi", "Ahmet Ümit", 280, "roman"),
		    		new Books("Sineklerin Tanrısı", "William Golding", 220, "roman"),
		    		new Books("Kırmızı Pazartesi", "Gabriel Garcia Marquez", 300, "roman"),
		    		new Books("Cevdet Bey ve Oğulları", "Orhan Pamuk", 400, "roman"),
		    		new Books("Bir Daha", "Harlan Coben", 260, "roman"),
		    		new Books("To Kill a Mockingbird", "Harper Lee", 320, "kurgu"),
		    		new Books("Gözlerinde Son Gece", "Ahmet Batman", 240, "roman"),
		    		new Books("Nehir", "Sema Kaygusuz", 310, "roman"),
		    		new Books("İnsan Neyle Yaşar", "Lev Tolstoy", 180, "roman"),
		    		new Books("Dracula", "Bram Stoker", 330, "roman"),
		    		new Books("Kürk Mantolu Adam", "Yalın Alpay", 200, "roman"),
		    		new Books("Uçurtma Avcısı", "Khaled Hosseini", 400, "roman"),
		    		new Books("Beyaz Zambaklar Ülkesinde", "Grigory Petrov", 250, "roman"),
		    		new Books("Olağanüstü Bir Gece", "Stefan Zweig", 190, "roman"),
		    		new Books("İnsanlık Suçu", "Oğuz Atay", 270, "roman"),
		    		new Books("İstanbul Hatırası", "Ahmet Ümit", 320, "roman"),
		    		new Books("Şeker Portakalı", "Jose Mauro de Vasconcelos", 150, "roman"),
		    		new Books("Altın Gözlü", "Sabahattin Ali", 210, "roman"),
		    		new Books("Yeraltından Notlar", "Fyodor Dostoyevsky", 280, "roman"),
		    		new Books("Dava", "Franz Kafka", 240, "roman"),
		    		new Books("The Great Gatsby", "F. Scott Fitzgerald", 180, "roman"),
		    		new Books("Yabancı", "Albert Camus", 200, "roman"),
		    		new Books("Simru", "Buket Uzuner", 270, "roman"),
		    		new Books("Dönüşüm", "Franz Kafka", 150, "roman"),
		    		new Books("1984", "George Orwell", 280, "distopik"),
		    		new Books("Kar", "Orhan Pamuk", 280, "roman"),
		    		new Books("Bir Gün", "David Nicholls", 350, "roman"),
		    		new Books("Savaş ve Barış","Tolstoy",393,"roman"),
		    		new Books("İki Şehrin Hikayesi","Charles Dickens",464,"roman"),
		    		new Books("Madam Bovary","Gustave Flaubert",408,"roman"),
		    		new Books("Fareler ve İnsanlar","John Steinbeck",128,"roman"),
		    		new Books("Kırmızı ve Siyah","Stendhal",736,"roman"),
		    		new Books("Babalar ve Oğullar","Turgenyev",167,"roman"),
		    		new Books("Genç Werther'in Acılar","Johann Wolfgang Von Goethe",126,"roman"),
		    		new Books("Araba Sevdası","Recaizade Mahmut Ekrem",240,"roman"),
		    		new Books("Kürk Mantolu Madonna","Sabahattin Ali",164,"roman"),
		    		new Books("Kuyucaklı Yusuf","Sabahattin Ali",220,"roman"),
		    		new Books("Aşk-ı Memnu","Halid Ziya Uşaklıgil",514,"roman"),
		    		new Books("Yaprak Dökümü","Reşat Nuri Güntekin",135,"roman"),
		    		new Books("Ateşten Gömlek","Halide Edip Adıvar",256,"roman"),
		    		new Books("Cezmi","Namık Kemal",320,"roman"),
		    		new Books("Tutunamayanlar","Oğuz Atay",724,"roman"),
		    		new Books("Anayurt Oteli","Yusuf Atılgan",112,"roman"),
		    		new Books("Çalıkuşu","Reşat Nuri Güntekin",406,"roman"),
		    		new Books("Serenad","Zülfü Livaneli",484,"roman"),
		    		new Books("Beyoğlu Rapsodisi","Ahmet Ümit",408,"roman"),
		    		new Books("Acımak","Reşat Nuri Güntekin",124,"roman"),
		    		new Books(" Bana Deli Derlerdi","John Monahan",304,"roman"),
		    		new Books("Ben Bir Ağacım","Orhan Pamuk",125,"roman"),
		    		new Books("Beş Şehir","Ahmet Hamdi Tampınar",220,"deneme"),
		    		new Books("Beyaz Gemi","Cengiz Aytmatov",168,"roman"),
		    		new Books("Budala","Dostoyevski",447,"roman"),
		    		new Books("Çile","Necip Fazıl Kısakürek",511,"şiir"),
		    		new Books("Dokuzuncu Hariciye Koğuşu","Peyami Safa",109,"roman"),
		    		new Books("Martin Eden","Jack London",496,"roman"),
		    		new Books("Eylül","Mehmet Rauf",256,"roman"),
		    		new Books("Çalıkuşu","Reşat Nuri Güntekin",544,"roman"),
		    		new Books("Aklından Bir Sayı Tut","John Verdon",475,"roman"),
		    		new Books("Araba Sevdası","Recaizade Mahmut Ekrem",272,"roman"),
		    		new Books("Yaşamak","Cahit Zarifoğlu",220,"roman")
		    		);
		    
	
		@Override 
		public void initialize(URL url, ResourceBundle rb) {
			kitapAdi.setCellValueFactory(new PropertyValueFactory<Books,String>("kitapAdi"));
			sayfaSayisi.setCellValueFactory(new PropertyValueFactory<Books,Integer>("sayfaSayisi"));
			turu.setCellValueFactory(new PropertyValueFactory<Books,String>("turu"));
			yazarAdi.setCellValueFactory(new PropertyValueFactory<Books,String>("yazarAdi"));
			
			table.setItems(list);
			
		}
		
		//deneme-arama çubuğu listeyi filtreleme çalışmıyor-
		/*
		@FXML
		private void searchProcess(ActionEvent event) {
		    System.out.println("Arama butonuna tıklandı.");
		    String searchText = searchBar.getText().toLowerCase();
		    System.out.println("Arama metni: " + searchText);

		    ObservableList<Books> filteredList = FXCollections.observableArrayList();

		    for (Books book : list) {
		        // Kitap adı, yazar adı veya türü içinde arama yap
		        if (book.getKitapAdi().toLowerCase().contains(searchText)
		                || book.getYazarAdi().toLowerCase().contains(searchText)
		                || book.getTuru().toLowerCase().contains(searchText)) {
		            filteredList.add(book);
		        }
		    }

		    // Filtrelenmiş kitap listesini tabloya set et
		    table.setItems(filteredList);
		    table.refresh();
		    System.out.println("tabloya güncellendi: kontrol");
		}
*/

		
	}
