package com.digiauto;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.digiauto.utils.DigiAutoConstants;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Estimation { // extends Application {

	public void estimationScene() {

	}

	public void estimationScene(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			ScrollPane scrollPane = new ScrollPane();
			Text estimateTitle = new Text();
			estimateTitle.setText("Prepare Estimate");

			Text customerName = new Text("Customer Name*:");
			Text contactNumber = new Text("Contact Number*:");
			Text address = new Text("Address*:");

			Text insured = new Text("Insured?*:");
			Text drivingLicence = new Text("Driving Licence Number*:");
			Text drivingLicenceIssueDate = new Text("Issue Date*:");
			Text drivingLicenceExpDate = new Text("Expiry Date*:");
			Text rcBook = new Text("RC Book*:");
			Text insurancePolicy = new Text("Insurance Policy Number*:");

			Text accidental = new Text("Accidental?*:");
			Text accidentDate = new Text("Accident Date*:");
			Text accidentPlace = new Text("Accident Place*:");
			Text accidentTime = new Text("Accident Time*:");
			Text accidentDescription = new Text("Accident Description*:");

			Text policeCase = new Text("Police Case?*:");
			Text fir = new Text("FIR*:");
			Text punchnama = new Text("Punchnama*:");

			Text chassisNumber = new Text("Chassis Number*:");
			Text engineNumber = new Text("Engine Number*:");

			Text commercialVehical = new Text("Commercial Vahical?*:");
			Text fitness = new Text("Fitness Certificate*:");
			Text odometerReading = new Text("Odometer Reading*");

			Button rcBookFiled = new Button("Choose file to upload");
			Button firField = new Button("Choose file to upload");
			Button punchnamaField = new Button("Choose file to upload");
			Button fitnessField = new Button("Choose file to upload");

			TextArea addressField = new TextArea();
			TextArea accidentDescriptionField = new TextArea();

			TextField customerNameField = new TextField();
			TextField contactField = new TextField();
			TextField accidentPlaceField = new TextField();
			TextField odometerReadingField = new TextField();
			TextField chassisNumberField = new TextField();
			TextField engineNumberField = new TextField();
			TextField drivingLicenceFiled = new TextField();
			TextField insurancePolicyField = new TextField();

			ToggleGroup insuranceGroup = new ToggleGroup();
			ToggleGroup accidentGroup = new ToggleGroup();
			ToggleGroup policeCaseGroup = new ToggleGroup();
			ToggleGroup commercialGroup = new ToggleGroup();

			RadioButton insuranceYes = new RadioButton("Yes");
			RadioButton insuranceNo = new RadioButton("No");

			RadioButton accidentYes = new RadioButton("Yes");
			RadioButton accidentNo = new RadioButton("No");

			RadioButton policeCaseYes = new RadioButton("Yes");
			RadioButton policeCaseNo = new RadioButton("No");

			RadioButton commercialYes = new RadioButton("Yes");
			RadioButton commercialNo = new RadioButton("No");

			DatePicker accidentDateField = new DatePicker();
			DatePicker drivingLicenceIssueField = new DatePicker();
			DatePicker drivingLicenceExpField = new DatePicker();

			ArrayList<String> hourList = new ArrayList<>();
			ArrayList<String> minuteList = new ArrayList<>();

			for (int i = 1; i < 13; i++) {
				if (i < 10) {
					hourList.add("0" + i);
				} else {
					hourList.add("" + i);
				}
			}
			minuteList.add("00");
			for (int i = 1; i < 61; i++) {
				if (i < 10) {
					minuteList.add("0" + i);
				} else {
					minuteList.add("" + i);
				}
			}

			ObservableList<String> hourOptions = FXCollections.observableArrayList(hourList);
			ObservableList<String> minutesOptions = FXCollections.observableArrayList(minuteList);
			ObservableList<String> timeIndicator = FXCollections.observableArrayList("AM", "PM");

			final ComboBox<String> hourBox = new ComboBox<String>(hourOptions);
			final ComboBox<String> minuteBox = new ComboBox<String>(minutesOptions);
			final ComboBox<String> timeIndicatorBox = new ComboBox<String>(timeIndicator);

			hourBox.setValue("12");
			minuteBox.setValue("00");
			timeIndicatorBox.setValue("PM");

			HBox timeBox = new HBox();
			timeBox.getChildren().addAll(hourBox, minuteBox, timeIndicatorBox);

			accidentYes.setToggleGroup(accidentGroup);
			accidentNo.setToggleGroup(accidentGroup);
			accidentNo.setSelected(true);
			accidentYes.setUserData("Yes");
			accidentNo.setUserData("No");

			insuranceYes.setToggleGroup(insuranceGroup);
			insuranceNo.setToggleGroup(insuranceGroup);
			insuranceNo.setSelected(true);
			insuranceYes.setUserData("Yes");
			insuranceNo.setUserData("No");

			policeCaseYes.setToggleGroup(policeCaseGroup);
			policeCaseNo.setToggleGroup(policeCaseGroup);
			policeCaseNo.setSelected(true);
			policeCaseYes.setUserData("Yes");
			policeCaseNo.setUserData("No");

			commercialYes.setToggleGroup(commercialGroup);
			commercialNo.setToggleGroup(commercialGroup);
			commercialNo.setSelected(true);
			commercialYes.setUserData("Yes");
			commercialNo.setUserData("No");

			Button prepare = new Button("Generate Estimate");

			prepare.setId("file-upload");

			rcBookFiled.setId("file-upload");
			firField.setId("file-upload");
			punchnamaField.setId("file-upload");
			estimateTitle.setId("estimate");
			fitnessField.setId("file-upload");

			customerName.setId("labels");
			contactNumber.setId("labels");
			address.setId("labels");
			drivingLicence.setId("labels");
			insured.setId("labels");
			rcBook.setId("labels");
			insurancePolicy.setId("labels");
			accidental.setId("labels");
			accidentDate.setId("labels");
			accidentPlace.setId("labels");
			accidentTime.setId("labels");
			accidentDescription.setId("labels");
			policeCase.setId("labels");
			fir.setId("labels");
			punchnama.setId("labels");
			commercialVehical.setId("labels");
			fitness.setId("labels");
			chassisNumber.setId("labels");
			engineNumber.setId("labels");
			drivingLicenceIssueDate.setId("labels");
			drivingLicenceExpDate.setId("labels");
			odometerReading.setId("labels");

			customerNameField.setId("fields");
			contactField.setId("fields");
			addressField.setId("fields");
			accidentDateField.setId("fields");
			insuranceYes.setId("fields");
			insuranceNo.setId("fields");
			accidentYes.setId("fields");
			accidentNo.setId("fields");
			commercialYes.setId("fields");
			commercialNo.setId("fields");
			hourBox.setId("fields");
			minuteBox.setId("fields");
			timeIndicatorBox.setId("fields");
			accidentDescriptionField.setId("fields");
			accidentPlaceField.setId("fields");
			policeCaseYes.setId("fields");
			policeCaseNo.setId("fields");
			chassisNumberField.setId("fields");
			engineNumberField.setId("fields");
			drivingLicenceFiled.setId("fields");
			insurancePolicyField.setId("fields");
			drivingLicenceIssueField.setId("fields");
			drivingLicenceExpField.setId("fields");
			odometerReadingField.setId("fields");

			drivingLicenceFiled.setDisable(true);
			insurancePolicyField.setDisable(true);
			drivingLicenceIssueField.setDisable(true);
			drivingLicenceExpField.setDisable(true);
			rcBookFiled.setDisable(true);

			accidentDateField.setDisable(true);
			accidentDescriptionField.setDisable(true);
			hourBox.setDisable(true);
			minuteBox.setDisable(true);
			timeIndicatorBox.setDisable(true);
			accidentPlaceField.setDisable(true);

			fitnessField.setDisable(true);
			firField.setDisable(true);
			punchnamaField.setDisable(true);

			addressField.setPrefRowCount(3);
			accidentDescriptionField.setPrefRowCount(3);

			final FileChooser fileChooser = new FileChooser();

			rcBookFiled.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					File file = fileChooser.showOpenDialog(primaryStage);
					if (file != null) {
						openFile(file);
					}
				}
			});

			firField.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					File file = fileChooser.showOpenDialog(primaryStage);
					if (file != null) {
						openFile(file);
					}
				}
			});

			punchnamaField.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					File file = fileChooser.showOpenDialog(primaryStage);
					if (file != null) {
						openFile(file);
					}
				}
			});

			fitnessField.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					File file = fileChooser.showOpenDialog(primaryStage);
					if (file != null) {
						openFile(file);
					}
				}
			});

			GridPane gridPane = new GridPane();

			gridPane.setVgap(25);
			gridPane.setHgap(10);

			gridPane.setAlignment(Pos.TOP_CENTER);

			HBox insuredBox = new HBox();
			HBox accidentalBox = new HBox();
			HBox policeCaseBox = new HBox();
			HBox commercialBox = new HBox();
			// HBox drivingBox = new HBox();

			policeCaseBox.getChildren().addAll(policeCaseYes, policeCaseNo);
			commercialBox.getChildren().addAll(commercialYes, commercialNo);
			// drivingBox.getChildren().addAll(drivingLicenceIssueDate,
			// drivingLicenceIssueField, drivingLicenceExpDate,
			// drivingLicenceExpField);

			gridPane.addColumn(0, customerName);
			gridPane.addColumn(1, customerNameField);

			gridPane.addRow(1, contactNumber);
			gridPane.addColumn(1, contactField);

			gridPane.addRow(2, address);
			gridPane.addColumn(1, addressField);

			gridPane.addRow(3, insured);
			insuredBox.setPadding(new Insets(15, 12, 15, 12));
			insuredBox.setSpacing(10);
			insuredBox.getChildren().addAll(insuranceYes, insuranceNo);
			gridPane.addColumn(1, insuredBox);

			gridPane.addRow(4, drivingLicence);
			gridPane.addColumn(1, drivingLicenceFiled);

			gridPane.addRow(5, drivingLicenceIssueDate);
			gridPane.addColumn(1, drivingLicenceIssueField);

			gridPane.addRow(6, drivingLicenceExpDate);
			gridPane.addColumn(1, drivingLicenceExpField);

			gridPane.addRow(7, rcBook);
			gridPane.add(rcBookFiled, 1, 7);

			gridPane.addRow(8, insurancePolicy);
			gridPane.addColumn(1, insurancePolicyField);

			gridPane.addRow(9, engineNumber);
			gridPane.addColumn(1, engineNumberField);

			gridPane.addRow(10, chassisNumber);
			gridPane.addColumn(1, chassisNumberField);

			gridPane.addColumn(2, accidental);
			accidentalBox.setPadding(new Insets(15, 12, 15, 12));
			accidentalBox.setSpacing(10);
			accidentalBox.getChildren().addAll(accidentYes, accidentNo);
			gridPane.addColumn(3, accidentalBox);

			gridPane.addRow(1, accidentDate);
			gridPane.addColumn(3, accidentDateField);

			gridPane.addRow(2, accidentDescription);
			gridPane.addColumn(3, accidentDescriptionField);

			gridPane.addRow(3, accidentTime);
			timeBox.setPadding(new Insets(15, 12, 15, 12));
			timeBox.setSpacing(10);
			gridPane.addColumn(3, timeBox);

			gridPane.addRow(4, accidentPlace);
			gridPane.addColumn(3, accidentPlaceField);

			gridPane.add(commercialVehical, 2, 5);
			commercialBox.setPadding(new Insets(15, 12, 15, 12));
			commercialBox.setSpacing(10);
			gridPane.addColumn(3, commercialBox);

			gridPane.addRow(6, fitness);
			gridPane.addColumn(3, fitnessField);

			gridPane.add(policeCase, 2, 7);
			policeCaseBox.setPadding(new Insets(15, 12, 15, 12));
			policeCaseBox.setSpacing(10);
			gridPane.addColumn(3, policeCaseBox);

			gridPane.addRow(8, fir);
			gridPane.addColumn(3, firField);

			gridPane.addRow(9, punchnama);
			gridPane.addColumn(3, punchnamaField);

			gridPane.addRow(10, odometerReading);
			gridPane.addColumn(3, odometerReadingField);

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

			accidentGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
				public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
					if (accidentGroup.getSelectedToggle() != null) {
						if (accidentGroup.getSelectedToggle().getUserData().toString().equals("Yes")) {
							accidentDateField.setDisable(false);
							accidentDescriptionField.setDisable(false);
							hourBox.setDisable(false);
							minuteBox.setDisable(false);
							timeIndicatorBox.setDisable(false);
							accidentPlaceField.setDisable(false);
						} else {
							accidentDateField.setDisable(true);
							accidentDescriptionField.setDisable(true);
							hourBox.setDisable(true);
							minuteBox.setDisable(true);
							timeIndicatorBox.setDisable(true);
							accidentPlaceField.setDisable(true);
						}
					}
				}
			});

			commercialGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
				public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
					if (commercialGroup.getSelectedToggle() != null) {
						if (commercialGroup.getSelectedToggle().getUserData().toString().equals("Yes")) {
							fitnessField.setDisable(false);
						} else {
							fitnessField.setDisable(true);
						}
					}
				}
			});

			policeCaseGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
				public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
					if (policeCaseGroup.getSelectedToggle() != null) {
						if (policeCaseGroup.getSelectedToggle().getUserData().toString().equals("Yes")) {
							firField.setDisable(false);
							punchnamaField.setDisable(false);
						} else {
							firField.setDisable(true);
							punchnamaField.setDisable(true);
						}
					}
				}
			});

			// gridPane.addRow(9, prepare);

			gridPane.setPadding(new Insets(10, 10, 20, 20));

			GridPane.setColumnSpan(prepare, 2);

			scrollPane.setContent(gridPane);
			scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

			primaryStage.setTitle("MS AUTO Digital Portal");
			Scene scene = new Scene(scrollPane);

			scene.getStylesheets().add(getClass().getResource(DigiAutoConstants.CSS).toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Desktop desktop = Desktop.getDesktop();

	private void openFile(File file) {
		try {
			desktop.open(file);
		} catch (IOException ex) {

		}
	}
}
