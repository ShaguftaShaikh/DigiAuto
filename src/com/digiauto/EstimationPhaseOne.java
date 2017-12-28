package com.digiauto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import com.digiauto.utils.DigiAutoConstants;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

public class EstimationPhaseOne {

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
	private Text accidental;
	private Text accidentDate;
	private Text accidentPlace;
	private Text accidentTime;
	private Text accidentDescription;
	private Text policeCase;
	private Text fir;
	private Text punchnama;
	private Text chassisNumber;
	private Text engineNumber;
	private Text commercialVehical;
	private Text fitness;
	private Text odometerReading;
	private Button rcBookFiled;
	private Button firField;
	private Button punchnamaField;
	private Button fitnessField;

	private TextArea addressField;
	private TextArea accidentDescriptionField;

	private TextField customerNameField;
	private TextField contactField;
	private TextField accidentPlaceField;
	private TextField odometerReadingField;
	private TextField chassisNumberField;
	private TextField engineNumberField;
	private TextField drivingLicenceFiled;
	private TextField insurancePolicyField;
	private TextField carNumberField;

	private ToggleGroup insuranceGroup;
	private ToggleGroup accidentGroup;
	private ToggleGroup policeCaseGroup;
	private ToggleGroup commercialGroup;

	private RadioButton insuranceYes;
	private RadioButton insuranceNo;

	private RadioButton accidentYes;
	private RadioButton accidentNo;

	private RadioButton policeCaseYes;
	private RadioButton policeCaseNo;

	private RadioButton commercialYes;
	private RadioButton commercialNo;

	private DatePicker accidentDateField;
	private DatePicker drivingLicenceIssueField;
	private DatePicker drivingLicenceExpField;

	private ComboBox<String> hourBox;
	private ComboBox<String> minuteBox;
	private ComboBox<String> timeIndicatorBox;
	private HBox timeBox;
	private Button prepare;
	private Text estimateTitle;
	private final FileChooser fileChooser = new FileChooser();

	private File rcBookFile;
	private File fitnessCertificateFile;
	private File firFile;
	private File punchnamaFile;

	public void estimationScene(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			ScrollPane scrollPane = new ScrollPane();
			estimateTitle = new Text();
			estimateTitle.setText("Prepare Estimate");
			prepare = new Button("Generate Estimate");

			initializeLables();
			initalizeFields();
			initializeStyle();
			initializeRadioButtons();
			initializeDefaultValues();

			addressField.setPrefRowCount(3);
			accidentDescriptionField.setPrefRowCount(3);

			rcBookFiled.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					rcBookFile = openFileDialog(primaryStage);
				}

			});

			firField.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					firFile = openFileDialog(primaryStage);
				}
			});

			punchnamaField.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					punchnamaFile = openFileDialog(primaryStage);
				}
			});

			fitnessField.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					fitnessCertificateFile = openFileDialog(primaryStage);
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

			policeCaseBox.getChildren().addAll(policeCaseYes, policeCaseNo);
			commercialBox.getChildren().addAll(commercialYes, commercialNo);

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

			gridPane.addRow(11, carNumber);
			gridPane.addColumn(1, carNumberField);

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
			gridPane.addRow(11, prepare);

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

			prepare.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					prepareDocument();
				}

			});

			gridPane.setPadding(new Insets(10, 10, 20, 20));
			gridPane.setAlignment(Pos.CENTER);
			GridPane.setColumnSpan(prepare, 2);

			scrollPane.setContent(gridPane);
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

			primaryStage.setTitle("MS AUTO Digital Portal");
			Scene scene = new Scene(scrollPane);

			scene.getStylesheets().add(getClass().getResource(DigiAutoConstants.CSS).toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setFullScreen(true);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initializeDefaultValues() {
		// TODO Auto-generated method stub
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
	}

	private void initializeRadioButtons() {
		// TODO Auto-generated method stub
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
	}

	private void initializeStyle() {
		// TODO Auto-generated method stub
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
		carNumber.setId("labels");

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
		carNumberField.setId("fields");
	}

	private void initalizeFields() {
		// TODO Auto-generated method stub
		addressField = new TextArea();
		accidentDescriptionField = new TextArea();

		customerNameField = new TextField();
		contactField = new TextField();
		accidentPlaceField = new TextField();
		odometerReadingField = new TextField();
		chassisNumberField = new TextField();
		engineNumberField = new TextField();
		drivingLicenceFiled = new TextField();
		insurancePolicyField = new TextField();
		carNumberField = new TextField();

		insuranceGroup = new ToggleGroup();
		accidentGroup = new ToggleGroup();
		policeCaseGroup = new ToggleGroup();
		commercialGroup = new ToggleGroup();

		insuranceYes = new RadioButton("Yes");
		insuranceNo = new RadioButton("No");

		accidentYes = new RadioButton("Yes");
		accidentNo = new RadioButton("No");

		policeCaseYes = new RadioButton("Yes");
		policeCaseNo = new RadioButton("No");

		commercialYes = new RadioButton("Yes");
		commercialNo = new RadioButton("No");

		accidentDateField = new DatePicker();
		drivingLicenceIssueField = new DatePicker();
		drivingLicenceExpField = new DatePicker();

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

		hourBox = new ComboBox<String>(hourOptions);
		minuteBox = new ComboBox<String>(minutesOptions);
		timeIndicatorBox = new ComboBox<String>(timeIndicator);

		// hourBox.setValue("12");
		// minuteBox.setValue("00");
		// timeIndicatorBox.setValue("PM");

		timeBox = new HBox();
		timeBox.getChildren().addAll(hourBox, minuteBox, timeIndicatorBox);

	}

	private void initializeLables() {
		// TODO Auto-generated method stub
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

		accidental = new Text("Accidental?*:");
		accidentDate = new Text("Accident Date*:");
		accidentPlace = new Text("Accident Place*:");
		accidentTime = new Text("Accident Time*:");
		accidentDescription = new Text("Accident Description*:");

		policeCase = new Text("Police Case?*:");
		fir = new Text("FIR*:");
		punchnama = new Text("Punchnama*:");

		chassisNumber = new Text("Chassis Number*:");
		engineNumber = new Text("Engine Number*:");

		commercialVehical = new Text("Commercial Vahical?*:");
		fitness = new Text("Fitness Certificate*:");
		odometerReading = new Text("Odometer Reading*");

		rcBookFiled = new Button("Choose file to upload");
		firField = new Button("Choose file to upload");
		punchnamaField = new Button("Choose file to upload");
		fitnessField = new Button("Choose file to upload");
	}

	//private Desktop desktop = Desktop.getDesktop();

/*	private void openFile(File file) {
		try {
			desktop.open(file);
		} catch (IOException ex) {

		}
	}*/

	private File openFileDialog(Stage primaryStage) {
		// TODO Auto-generated method stub
		return fileChooser.showOpenDialog(primaryStage);
		/*
		 * if (file != null) { openFile(file); }
		 */
	}

	private void prepareDocument() {
		// TODO Auto-generated method stub
		boolean validate = validateInputs();
		if (validate) {
			boolean confirm = showConfirmPopUp();
			if (confirm) {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();

				Document document = new Document();
				try {
					PdfWriter.getInstance(document, new FileOutputStream("generated files/sample.pdf"));
					document.open();
					Image img = Image.getInstance("resource/logo.png");
					document.add(img);
					PdfPTable table = new PdfPTable(2);
					table.setWidthPercentage(100);

					PdfPCell cell = new PdfPCell(new Phrase("Name: " + customerNameField.getText()));
					cell.setFixedHeight(20);
					cell.setBorder(Rectangle.NO_BORDER);
					table.addCell(cell);

					cell = new PdfPCell(new Phrase("Invoice Number: 1"));
					cell.setFixedHeight(20);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setBorder(Rectangle.NO_BORDER);
					table.addCell(cell);

					cell = new PdfPCell(new Phrase("Contact Number: " + contactField.getText()));
					cell.setFixedHeight(20);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setBorder(Rectangle.NO_BORDER);
					table.addCell(cell);

					cell = new PdfPCell(new Phrase("Date: " + dateFormat.format(date)));
					cell.setFixedHeight(20);
					cell.setBorder(Rectangle.NO_BORDER);
					table.addCell(cell);

					cell = new PdfPCell(new Phrase("Address: " + addressField.getText()));
					cell.setFixedHeight(20);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setBorder(Rectangle.NO_BORDER);
					table.addCell(cell);

					cell = new PdfPCell(new Phrase("Car Number: " + carNumberField.getText()));
					cell.setFixedHeight(20);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setBorder(Rectangle.NO_BORDER);
					table.addCell(cell);

					document.add(table);
					document.close();

				} catch (FileNotFoundException | DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private boolean showConfirmPopUp() {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Genrating Estimate");
		alert.setHeaderText("Generatin of Estimate Document");
		alert.setContentText("Are you sure you want generate estimate document?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validateInputs() {
		// TODO Auto-generated method stub
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

		if (accidentYes.isSelected()) {
			if (accidentDateField.getValue() == null) {
				accidentDate.setId("error-label");
				flag = false;
			} else {
				accidentDate.setId("labels");
			}
			if (accidentPlaceField.getText() == null || accidentPlaceField.getText().isEmpty()) {
				accidentPlace.setId("error-label");
				flag = false;
			} else {
				accidentPlace.setId("labels");
			}
			if (accidentDescriptionField.getText() == null || accidentDescriptionField.getText().isEmpty()) {
				accidentDescription.setId("error-label");
				flag = false;
			} else {
				accidentDescription.setId("labels");
			}
			if (hourBox.getValue() == null) {
				accidentTime.setId("error-label");
				flag = false;
			} else {
				accidentTime.setId("labels");
			}
			if (minuteBox.getValue() == null) {
				accidentTime.setId("error-label");
				flag = false;
			} else {
				accidentTime.setId("labels");
			}
			if (timeIndicatorBox.getValue() == null) {
				accidentTime.setId("error-label");
				flag = false;
			} else {
				accidentTime.setId("labels");
			}
		} else {
			accidentTime.setId("labels");
			accidentDescription.setId("labels");
			accidentPlace.setId("labels");
			accidentDate.setId("labels");
		}
		if (commercialYes.isSelected()) {
			if (fitnessCertificateFile == null) {
				fitness.setId("error-label");
				flag = false;
			} else {
				fitness.setId("labels");
			}
		} else {
			fitness.setId("labels");
		}
		if (policeCaseYes.isSelected()) {
			if (firFile == null) {
				fir.setId("error-label");
				flag = false;
			} else {
				fir.setId("labels");
			}
			if (punchnamaFile == null) {
				punchnama.setId("error-label");
				flag = false;
			} else {
				punchnama.setId("labels");
			}
		} else {
			fir.setId("labels");
			punchnama.setId("labels");
		}
		return flag;
	}
}
