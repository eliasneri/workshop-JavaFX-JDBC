package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService service;
	
	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	@FXML
	public void onBtNewAction() {
		Alerts.showAlert("Bt New", AlertType.INFORMATION);
	}
	
	private ObservableList<Department> obsList;
	
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//para forçar o tableView a ser responsivo com a tela!
		Stage stage = (Stage) Main.getMainScene().getWindow();
		
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		
	}
	
	public void updateTableView() {
		if (service == null) {
			Alerts.showAlert("Serviço Vazio", AlertType.ERROR);
			throw new IllegalStateException("Serviço Nullo");
		}
		
		List<Department> list = service.findAll();
		
		obsList = FXCollections.observableArrayList(list);
		
		tableViewDepartment.setItems(obsList);
		
		
	}
	
	

}
