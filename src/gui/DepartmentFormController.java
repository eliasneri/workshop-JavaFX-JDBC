package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.listners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {

	private Department entity;
	private DepartmentService service;
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
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
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	public void subscribeData(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}
	
	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if (entity == null) {
			throw new IllegalStateException("Entity Null!!");
		}
		
		if (service == null) {
			throw new IllegalStateException("Service Null!!");
		}
		
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			
			Alerts.showAlert("Novo Department Salvo!!! \n"
					+ "ID: " + entity.getId() 
					+ "\nName: " + entity.getName(), 
					AlertType.INFORMATION);
			notificaListeners();
			Utils.currentStage(event).close();
			
		}
		
		catch (DbException e) {
			Alerts.showAlert("Erro ao Salvar novo Departamento!!! \n" + e, AlertType.ERROR);
			
		}
		
		
	}

	private void notificaListeners() {
		for (DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
		
	}

	private Department getFormData() {
		Department obj = new Department();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		
		return obj;
	}

	
	@FXML
	public void onBtSCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
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
