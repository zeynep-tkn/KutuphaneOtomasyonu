package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) {
		try {
			SplitPane root = (SplitPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.initStyle(StageStyle.TRANSPARENT); 
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Kütüphane Otomasyonu");
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
