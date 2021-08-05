package gui.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	
		public static void showAlert(String content, AlertType type) {
			Alert alert = new Alert(type);
			alert.setTitle("Workshop JavaFX JDBC");
			alert.setHeaderText(null);
			alert.setContentText(content);
			alert.show();
		}

}
