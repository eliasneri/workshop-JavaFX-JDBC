package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable {

	private Department entity;
	
	@FXML
	private Label lblErrorId;
	
	@FXML
	private Label lblErroName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtName;
	
	public void setDepartment(Department entity) {
		this.entity = entity;
		
	}
	
	@FXML
	public void onBtSaveAction() {
		Alerts.showAlert("Save!!", AlertType.INFORMATION);
		txtName.requestFocus();
	}
	
	@FXML
	public void onBtSCancelAction() {
		Alerts.showAlert("Cancel!!", AlertType.INFORMATION);
		txtName.clear();
		txtName.requestFocus();
	}
	
	@Override
	public void initialize(URL ur, ResourceBundle ar) {
		txtName.clear();
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 15);
		txtName.requestFocus();
		
	}
	
	public void updateFormData() {
		if (entity == null ) {
			throw new IllegalStateException("Sem Dados");
		} 
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	
	}

}
