import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AssignmentFX extends Application {

	public static void main(String[] args) {
		//Start Application
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Defining UI Controls for Airport Ride Calculator
		// Header Label
		Label headLbl = new Label("Airport Ride Calculator");
		headLbl.setUnderline(true);

		Label descLbl = new Label("From: ");

		// Dropdown List to select Origin of Trip
		ComboBox<String> locationList = new ComboBox<String>();
		locationList.getItems().add("Cestar College");
		locationList.getItems().add("Brampton");

		// Additional charges/services which user can opt for
		CheckBox extraluggageChkBox = new CheckBox("Extra luggage?");
		CheckBox petsChkBox = new CheckBox("Pets");
		CheckBox etrChkBox = new CheckBox("Use 407 ETR?");
		CheckBox tipChkBox = new CheckBox("Add Tip?");

		Button calcButton = new Button("CALCULATE");

		// Result Label to show final cost of trip or error if any
		Label resultLbl = new Label("");

		// Logic to calculate Ride Fare when clicked on Calculate Button
		calcButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				String location = locationList.getSelectionModel().getSelectedItem();
				boolean isValidLocation = true;
				double etrDistanceBrampton = 12;
				double etrDistanceCestar = 15;
				double tripCost = 0;
				//reset etrCheckBox Text
				etrChkBox.setText("Use 407 ETR?");

				if (("Cestar College").equals(location)) {

					tripCost = 51;

					if (etrChkBox.isSelected()) {
						tripCost += etrDistanceCestar * 0.25;
						etrChkBox.setText("Use 407 ETR? (" + etrDistanceCestar + "kms )");
					}

				} else if (("Brampton").equals(location)) {

					tripCost = 38;

					if (etrChkBox.isSelected()) {
						tripCost += etrDistanceBrampton * 0.25;
						etrChkBox.setText("Use 407 ETR? (" + etrDistanceBrampton + "kms )");
					}

				} else {
					isValidLocation = false;
					resultLbl.setText("Please select location !");
				}

				// If location is valid i.e. Cestar College or Brampton then calculate final
				// fare.
				if (isValidLocation) {

					if (extraluggageChkBox.isSelected())
						tripCost += 10;
					if (petsChkBox.isSelected())
						tripCost += 6;

					// Calculating Tax @13%
					tripCost *= 1.13;

					if (tipChkBox.isSelected())
						tripCost *= 1.15;

					// Converting final result with 2 decimal precision
					DecimalFormat deciFormat = new DecimalFormat("###.##");
					double tripCostWithPrecision = Double.parseDouble(deciFormat.format(tripCost));

					// Update result label with final output
					resultLbl.setText("The total fare is: " + tripCostWithPrecision);
				}
			}
		});

		// Defining Layout Manager

		// Horizontal Layout Manager
		HBox hRoot = new HBox();
		hRoot.setSpacing(5);
		hRoot.getChildren().add(descLbl);
		hRoot.getChildren().add(locationList);
		hRoot.setAlignment(Pos.CENTER);

		// Using GridPane layout to alignment checkboxes  and corresponding text in grid form
		GridPane gRoot = new GridPane();
		gRoot.setVgap(15);
		gRoot.addRow(0, extraluggageChkBox);
		gRoot.addRow(1, petsChkBox);
		gRoot.addRow(2, etrChkBox);
		gRoot.addRow(3, tipChkBox);
		gRoot.setAlignment(Pos.CENTER);

		//VBox is the main layout which will have all UI and other layout managers as its children
		VBox vRoot = new VBox();
		vRoot.setSpacing(15);
		vRoot.getChildren().add(headLbl);
		vRoot.getChildren().add(hRoot);
		vRoot.getChildren().add(gRoot);
		vRoot.getChildren().add(calcButton);
		vRoot.getChildren().add(resultLbl);
		vRoot.setAlignment(Pos.CENTER);

		// Creating Scene with dimension 350 x 300
		Scene scene = new Scene(vRoot, 300, 350);

		// creating stage and setting scene
		primaryStage.setScene(scene);
		primaryStage.setTitle("AirRideLimo.com");
		primaryStage.show();

	}

}
