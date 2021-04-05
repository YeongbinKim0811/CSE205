// Assignment 6: ASU - CSE 205
// Name: Yeongbin Kim
// StudentID: 1217898110
//Lecture Date and Time: T/TH 4:30 - 5:45
//  Description: GeneratePane creates a pane where a user can enter
//  department information and create a list of available departments.

/* --------------- */
/* Import Packages */
/* --------------- */

import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import

// JavaFX classes
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * GeneratePane builds a pane where a user can enter a department
 * information and create a list of available departments.
 */
public class GeneratePane extends HBox {
    /* ------------------ */
    /* Instance variables */
    /* ------------------ */

    ArrayList<Department> departList;
    private SelectPane selectPane; // The relationship between GeneratePane and SelectPane is Aggregation
    //declare and init
    private Button addADepartment;
    private TextField departmentTitleField;
    private TextField numOfFacultyField;
    private TextField nameOfUniversityField;
    private Label myLabel1;
    private Label departmentTitle;
    private Label numberOfFaculty;
    private Label nameOfUniversity;
    private TextArea myTextArea;
    private GridPane gridPane;
    private BorderPane buttonPane;
    private VBox pane1;
    private VBox pane2;
    
    /**
     * CreatePane constructor
     *
     * @param list   the list of departments
     * @param sePane the SelectPane instance
     */
    public GeneratePane(ArrayList<Department> list, SelectPane sePane) {
        /* ------------------------------ */
        /* Instantiate instance variables */
        /* ------------------------------ */
    	this.departList = list;
    	this.selectPane = sePane;

        //initialize each instance variable (textfields, labels, textarea, button, etc.)
    	//and set up the layout
    	this.addADepartment = new Button("Add a Department");
    	this.departmentTitleField = new TextField();
    	this.numOfFacultyField = new TextField();
    	this.nameOfUniversityField = new TextField();
    	this.myLabel1 = new Label();
    	this.departmentTitle = new Label("Department Title");
    	this.numberOfFaculty = new Label("Number of faculty");
    	this.nameOfUniversity = new Label("Name of University");
    	this.myTextArea = new TextArea("No Department");
    	//create a GridPane to hold labels & text fields.
    	//you can choose to use .setPadding() or setHgap(), setVgap()
    	//to control the spacing and gap, etc.
    	this.gridPane = new GridPane();
    	gridPane.setAlignment(Pos.TOP_CENTER);
    	gridPane.setPadding(new Insets(5, 5, 5, 5));
    	gridPane.setHgap(5.5);
    	gridPane.setVgap(5.5);
    	// Set both left and right columns to 50% width (half of window)
    	ColumnConstraints halfWidth = new ColumnConstraints();
    	halfWidth.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);
        gridPane.add(departmentTitle, 0, 0);
        gridPane.add(departmentTitleField, 1, 0);
        gridPane.add(numberOfFaculty, 0, 1);
        gridPane.add(numOfFacultyField, 1, 1);
        gridPane.add(nameOfUniversity, 0, 2);
        gridPane.add(nameOfUniversityField, 1, 2);
		//You might need to create a sub pane to hold the button
        this.buttonPane = new BorderPane();
        buttonPane.setCenter(addADepartment);
        buttonPane.setTop(gridPane);
        addADepartment.setOnAction(new ButtonHandler());
        //Set up the layout for the left half of the GeneratePane.
        this.pane1 = new VBox();
        pane1.setPrefSize(500, 500);
        
        pane1.setSpacing(5);
        pane1.getChildren().addAll(myLabel1, buttonPane);
		//the right half of the GeneratePane is simply a TextArea object
		//Note: a ScrollPane will be added to it automatically when there are no more space
		//Add the left half and right half to the GeneratePane
        this.pane2 = new VBox();
        pane2.setPrefSize(500, 500);
        myTextArea.setPrefSize(500, 300);
        pane2.getChildren().add(myTextArea);

        this.getChildren().addAll(pane1, pane2);
		//Note: GeneratePane extends from HBox
		//register/link source object with event handler
        // Bind button click action to event handler

    } // end of constructor

    /**
     * ButtonHandler ButtonHandler listens to see if the button "Add a department" is pushed
     * or not, When the event occurs, it get a department's Title, number of faculties,
     * and its university information from the relevant text fields, then create a
     * new department and adds it to the departList. Meanwhile it will display the department's
     * information inside the text area. using the toString method of the Department
     * class. It also does error checking in case any of the text fields are empty,
     * or a non-numeric value was entered for number of faculty
     */
    private class ButtonHandler implements EventHandler<ActionEvent> {
        /**
         * handle Override the abstract method handle()
        */
        public void handle(ActionEvent event) {
            // Declare local variables
            Department newDepart;
            int numOfFaculty = 0;

            // If any field is empty, set isEmptyFields flag to true
            if (departmentTitleField.getText().equals("") || numOfFacultyField.getText().equals("") || nameOfUniversityField.getText().equals(""))
            {
            	myLabel1.setTextFill(Color.RED);
            	myLabel1.setText("Please fill all fields");     // Display error message if there are empty fields
            }
            else
            {
            	// If all fields are filled, try to add the department
            	try {
                    	/*
                    	 * Cast faculties Field to an integer, throws NumberFormatException if unsuccessful
                    	 */
            			numOfFaculty = Integer.parseInt(numOfFacultyField.getText());
            			// Data is valid, so create new Department object and populate data
            			newDepart = new Department();
            			newDepart.setDeptName(departmentTitleField.getText());
            			newDepart.setNumberOfMembers(numOfFaculty);
            			newDepart.setUniversity(nameOfUniversityField.getText());
            			// Loop through existing departments to check for duplicates
            			// do not add it to the list if it exists and display a message
            			for (int i = 0; i < departList.size(); i++)
            			{
            				if (departList.get(i).getDeptName().equals(newDepart.getDeptName()) && departList.get(i).getUniversity().equals(newDepart.getUniversity()))
            				{
            					throw new Exception();
            				}
            			}
            			// department is not a duplicate, so display it and add it to list
            			if (departList.size() == 0)
            			{
            				myTextArea.clear();
            			}
            			departList.add(newDepart);
            			myTextArea.appendText(newDepart.toString());
            			myLabel1.setTextFill(Color.RED);
            			myLabel1.setText("Department added");
            			departmentTitleField.clear();
            			numOfFacultyField.clear();
            			nameOfUniversityField.clear();
            			selectPane.updateDepartList(newDepart);

                	} //end of try
                	catch (NumberFormatException e) {
                		// If the number of faculties entered was not an integer, display an error
                		myLabel1.setTextFill(Color.RED);
                		myLabel1.setText("Please enter an integer for the number of faculty");
                	} 
                	catch (Exception e) {
                		// Catches generic exception and displays message
                		// Used to display 'Department is not added - already exist' message if department already exist
                		myLabel1.setTextFill(Color.RED);
                		myLabel1.setText("Department not added - already exist");

                	}
            }
           
        } // end of handle() method
    } // end of ButtonHandler class
} // end of GeneratePane class


