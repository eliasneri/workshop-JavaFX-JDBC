package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;

public class MainViewController implements Initializable{

	@FXML
	private MenuItem menuItemSeller, menuItemDepartment;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("seller");
	}
	
	@FXML
	public void onMenuItemDepartment() {
		Alerts.showAlert("Department", AlertType.INFORMATION);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
