import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AssignmentFX extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Define UI Controls
		Label headLbl = new Label("Airport Ride Calculator");
		headLbl.setAlignment(Pos.CENTER);
		headLbl.setUnderline(true);
		
		Label descLbl = new Label("From: ");
		headLbl.setAlignment(Pos.CENTER_LEFT);
		
		ComboBox<String> locationList = new ComboBox<String>();
		locationList.getItems().add("Cestar College");
		locationList.getItems().add("Brampton");
		
		CheckBox extraluggageChkBox = new CheckBox("Extra luggage?");
		CheckBox petsChkBox = new CheckBox("Pets");
		CheckBox etrChkBox = new CheckBox("Use 407 ETR?");
		CheckBox tipChkBox = new CheckBox("Add Tip?");
		
		Button calcButton = new Button("Calculate");
		
		Label resultLbl = new Label("");
		
		// Create Layout Manager
		HBox hRoot = new HBox();
		hRoot.setSpacing(5);
		hRoot.getChildren().add(descLbl);
		hRoot.getChildren().add(locationList);
		hRoot.setAlignment(Pos.CENTER);
		
		VBox vRoot = new VBox();
		vRoot.setSpacing(12);
		vRoot.getChildren().add(headLbl);
		vRoot.getChildren().addAll(hRoot);
		vRoot.getChildren().add(extraluggageChkBox);
		vRoot.getChildren().add(petsChkBox);
		vRoot.getChildren().add(etrChkBox);
		vRoot.getChildren().add(tipChkBox);
		vRoot.getChildren().add(calcButton);
		vRoot.getChildren().add(resultLbl);
		
		vRoot.setAlignment(Pos.CENTER);
		
		//Creating Scene
		Scene scene = new Scene(vRoot,250,400);
	
		
		//creating stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("Assignment_3_4");
		primaryStage.show();
		
	}

}
