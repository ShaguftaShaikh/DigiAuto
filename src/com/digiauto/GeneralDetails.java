package com.digiauto;

import java.io.File;

import com.digiauto.beans.Customer;
import com.digiauto.utils.DigiAutoConstants;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GeneralDetails {

	private Text customerName;
	private Text contactNumber;
	private Text address;
	private Text carNumber;
	private Text insured;
	private Text drivingLicence;
	private Text drivingLicenceIssueDate;
	private Text drivingLicenceExpDate;
	private Text rcBook;
	private Text insurancePolicy;
	private Text chassisNumber;
	private Text engineNumber;
	private Text odometerReading;
	
	private Button rcBookFiled;
	private Button accidentDetails;
	private Button save;
	private Button clear;
	private Button prepareEstimate;
	
	private TextArea addressField;

	private TextField customerNameField;
	private TextField contactField;
	private TextField odometerReadingField;
	private TextField chassisNumberField;
	private TextField engineNumberField;
	private TextField drivingLicenceFiled;
	private TextField insurancePolicyField;
	private TextField carNumberField;
	
	private ToggleGroup insuranceGroup;
	
	private RadioButton insuranceYes;
	private RadioButton insuranceNo;
	
	private DatePicker drivingLicenceIssueField;
	private DatePicker drivingLicenceExpField;
	
	private File rcBookFile;
	
	public void generalDetailsScene(Stage primaryStage) throws Exception {
		GridPane gridPane = new GridPane();
		
		initializeLables();
		initalizeFields();
		initializeStyle();
		initializeRadioButtons();
		initializeDefaultValues();
		
		gridPane.addRow(0, customerName);
		gridPane.addColumn(1, customerNameField);

		gridPane.addRow(1, contactNumber);
		gridPane.addColumn(1, contactField);

		gridPane.addRow(2, address);
		addressField.setPrefRowCount(2);
		gridPane.addColumn(1, addressField);
		
		gridPane.addRow(3, engineNumber);
		gridPane.addColumn(1, engineNumberField);

		gridPane.addRow(4, chassisNumber);
		gridPane.addColumn(1, chassisNumberField);

		gridPane.addRow(5, carNumber);
		gridPane.addColumn(1, carNumberField);
		
		gridPane.addRow(6, odometerReading);
		gridPane.addColumn(1, odometerReadingField);
		
		
		HBox buttonBox = new HBox();
		buttonBox.setPadding(new Insets(15, 12, 15, 12));
		buttonBox.setSpacing(30);
		buttonBox.getChildren().addAll(save, clear,prepareEstimate);
		
		gridPane.addRow(7, buttonBox);
		GridPane.setColumnSpan(buttonBox, 2);
		
		gridPane.addColumn(2, insured);
		
		HBox insuredBox = new HBox();
		
		insuredBox.setPadding(new Insets(15, 12, 15, 12));
		insuredBox.setSpacing(10);
		insuredBox.getChildren().addAll(insuranceYes, insuranceNo);
		gridPane.addColumn(3, insuredBox);
		
		gridPane.addRow(1, drivingLicence);
		gridPane.addColumn(3, drivingLicenceFiled);

		gridPane.addRow(2, drivingLicenceIssueDate);
		gridPane.addColumn(3, drivingLicenceIssueField);

		gridPane.addRow(3, drivingLicenceExpDate);
		gridPane.addColumn(3, drivingLicenceExpField);

		gridPane.addRow(4, rcBook);
		gridPane.addColumn(3,rcBookFiled);

		gridPane.addRow(5, insurancePolicy);
		gridPane.addColumn(3, insurancePolicyField);
		
		gridPane.addRow(6, accidentDetails);

		insuranceGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
				if (insuranceGroup.getSelectedToggle() != null) {
					if (insuranceGroup.getSelectedToggle().getUserData().toString().equals("Yes")) {
						drivingLicenceFiled.setDisable(false);
						insurancePolicyField.setDisable(false);
						drivingLicenceIssueField.setDisable(false);
						drivingLicenceExpField.setDisable(false);
						rcBookFiled.setDisable(false);
					} else {
						drivingLicenceFiled.setDisable(true);
						insurancePolicyField.setDisable(true);
						drivingLicenceIssueField.setDisable(true);
						drivingLicenceExpField.setDisable(true);
						rcBookFiled.setDisable(true);
					}
				}
			}
		});
		
		rcBookFiled.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				//rcBookFile = openFileDialog(primaryStage);
			}

		});
		
		accidentDetails.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				try {
					Customer customer = new Customer();
					customer.setCustomerName(customerNameField.getText());
					customer.setCustomerContact(customerNameField.getText());
					customer.setCutomerAddress(addressField.getText());
					customer.setDrivingLicenceNumber(drivingLicenceFiled.getText());
					customer.setIssueDate(drivingLicenceIssueField.getValue().toString());
					customer.setExpiryDate(drivingLicenceExpField.getValue().toString());
					
					new AccidentDetails().estimationScene(primaryStage,customer);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		customerNameField.setOnKeyTyped(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				//String name = customerNameField.getText();
			}
		});
		
		gridPane.setPadding(new Insets(10, 10, 20, 20));
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(25);
		gridPane.setHgap(10);
		
		primaryStage.setTitle("MS AUTO Digital Portal");
		
		Scene scene = new Scene(gridPane);
		scene.getStylesheets().add(getClass().getResource(DigiAutoConstants.CSS).toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.show();
	}
	
	private void initializeDefaultValues() {
		// TODO Auto-generated method stub
		drivingLicenceFiled.setDisable(true);
		insurancePolicyField.setDisable(true);
		drivingLicenceIssueField.setDisable(true);
		drivingLicenceExpField.setDisable(true);
		rcBookFiled.setDisable(true);
	}
	
	private void initializeRadioButtons() {
		insuranceYes.setToggleGroup(insuranceGroup);
		insuranceNo.setToggleGroup(insuranceGroup);
		insuranceNo.setSelected(true);
		insuranceYes.setUserData("Yes");
		insuranceNo.setUserData("No");
	}
	
	private void initializeStyle() {
		rcBookFiled.setId("file-upload");
		accidentDetails.setId("file-upload");
		save.setId("file-upload");
		clear.setId("file-upload");
		prepareEstimate.setId("file-upload");
		
		customerName.setId("labels");
		contactNumber.setId("labels");
		address.setId("labels");
		drivingLicence.setId("labels");
		insured.setId("labels");
		rcBook.setId("labels");
		insurancePolicy.setId("labels");
		
		chassisNumber.setId("labels");
		engineNumber.setId("labels");
		drivingLicenceIssueDate.setId("labels");
		drivingLicenceExpDate.setId("labels");
		odometerReading.setId("labels");
		carNumber.setId("labels");

		customerNameField.setId("fields");
		contactField.setId("fields");
		addressField.setId("fields");
		
		insuranceYes.setId("fields");
		insuranceNo.setId("fields");
		
		chassisNumberField.setId("fields");
		engineNumberField.setId("fields");
		drivingLicenceFiled.setId("fields");
		insurancePolicyField.setId("fields");
		drivingLicenceIssueField.setId("fields");
		drivingLicenceExpField.setId("fields");
		odometerReadingField.setId("fields");
		carNumberField.setId("fields");
	}
	
	private void initalizeFields() {
		addressField = new TextArea();
		customerNameField = new TextField();
		contactField = new TextField();
		odometerReadingField = new TextField();
		chassisNumberField = new TextField();
		engineNumberField = new TextField();
		drivingLicenceFiled = new TextField();
		insurancePolicyField = new TextField();
		carNumberField = new TextField();

		insuranceGroup = new ToggleGroup();
		insuranceYes = new RadioButton("Yes");
		insuranceNo = new RadioButton("No");
		drivingLicenceIssueField = new DatePicker();
		drivingLicenceExpField = new DatePicker();
	}
	
	private void initializeLables() {
		customerName = new Text("Customer Name*:");
		contactNumber = new Text("Contact Number*:");
		address = new Text("Address*:");
		carNumber = new Text("Car Number*:");

		insured = new Text("Insured?*:");
		drivingLicence = new Text("Driving Licence Number*:");
		drivingLicenceIssueDate = new Text("Issue Date*:");
		drivingLicenceExpDate = new Text("Expiry Date*:");
		
		rcBook = new Text("RC Book*:");
		insurancePolicy = new Text("Insurance Policy Number*:");
		
		chassisNumber = new Text("Chassis Number*:");
		engineNumber = new Text("Engine Number*:");
		
		odometerReading = new Text("Odometer Reading*");
		rcBookFiled = new Button("Choose file to upload");
		accidentDetails = new Button("Add Accidential Details");
		save = new Button("Save Details");
		clear = new Button("Clear Details");
		prepareEstimate = new Button("Prepare Estimate");
	}
	
	private boolean validateInputs() {
		boolean flag = true;
		if (customerNameField.getText() == null || customerNameField.getText().isEmpty()) {
			customerName.setId("error-label");
			flag = false;
		} else {
			customerName.setId("labels");
		}
		if (contactField.getText() == null || contactField.getText().isEmpty()) {
			contactNumber.setId("error-label");
			flag = false;
		} else {
			contactNumber.setId("labels");
		}
		if (addressField.getText() == null || addressField.getText().isEmpty()) {
			address.setId("error-label");
			flag = false;
		} else {
			address.setId("labels");
		}
		if (carNumberField.getText() == null || carNumberField.getText().isEmpty()) {
			carNumber.setId("error-label");
			flag = false;
		} else {
			carNumber.setId("labels");
		}

		if (chassisNumberField.getText() == null || chassisNumberField.getText().isEmpty()) {
			chassisNumber.setId("error-label");
			flag = false;
		} else {
			chassisNumber.setId("labels");
		}
		if (odometerReadingField.getText() == null || odometerReadingField.getText().isEmpty()) {
			odometerReading.setId("error-label");
			flag = false;
		} else {
			odometerReading.setId("labels");
		}
		if (engineNumberField.getText() == null || engineNumberField.getText().isEmpty()) {
			engineNumber.setId("error-label");
			flag = false;
		} else {
			engineNumber.setId("labels");
		}

		if (insuranceYes.isSelected()) {
			if (insurancePolicyField.getText() == null || insurancePolicyField.getText().isEmpty()) {
				insurancePolicy.setId("error-label");
				flag = false;
			} else {
				insurancePolicy.setId("labels");
			}
			if (drivingLicenceFiled.getText() == null || drivingLicenceFiled.getText().isEmpty()) {
				drivingLicence.setId("error-label");
				flag = false;
			} else {
				drivingLicence.setId("labels");
			}
			if (drivingLicenceIssueField.getValue() == null) {
				drivingLicenceIssueDate.setId("error-label");
				flag = false;
			} else {
				drivingLicenceIssueDate.setId("labels");
			}
			if (drivingLicenceExpField.getValue() == null) {
				drivingLicenceExpDate.setId("error-label");
				flag = false;
			} else {
				drivingLicenceExpDate.setId("labels");
			}
			if (rcBookFile == null) {
				rcBook.setId("error-label");
				flag = false;
			} else {
				rcBook.setId("labels");
			}
		} else {
			rcBook.setId("labels");
			drivingLicenceIssueDate.setId("labels");
			drivingLicenceExpDate.setId("labels");
			drivingLicence.setId("labels");
			insurancePolicy.setId("labels");
		}
		return flag;
	}
}
