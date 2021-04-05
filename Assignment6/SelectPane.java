// Assignment #: 6
// Arizona State University - CSE205
// Name: Yeongbin Kim
// StudentID: 1217898110
//Lecture Date and Time: T/TH 4:30 - 5:45
//  Description: SelectPane displays a list of available department
//  from which a user can select and compute total number of faculties in multiple departments.

import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

/**
* SelectPane displays a list of available departments from which a user
* can select and compute total number of faculties for selected departments.
*/
public class SelectPane extends BorderPane {

    //declare instance variables
    private ArrayList<Department> departList;
    private Label selectLabel;
    private Label numOfFaculty;
    private ScrollPane scrollPane;
    private VBox vBox1;
    private VBox vBox2;
    private CheckBox myCheckBox;
    private int numOfFacultySelected;
    


    public SelectPane(ArrayList<Department> list) {
        /* ------------------------------ */
        /* Instantiate instance variables */
        /* ------------------------------ */
        this.departList = list;
        this.selectLabel = new Label("Select department(s)");
        this.numOfFacultySelected = 0;
        this.numOfFaculty = new Label("The total number of faculty for the selected department(s):" + numOfFacultySelected);


        // Wrap checkboxContainer in ScrollPane so formatting is
        // correct when many departments are added
        this.scrollPane = new ScrollPane();
        scrollPane.setPrefHeight(500); 
        //create an empty pane where you can add check boxes later
        this.vBox1 = new VBox();

        // Setup layout    
        this.vBox2 = new VBox();
        
        //SelectPane is a BorderPane - add the components here
        this.vBox2.getChildren().addAll(selectLabel, scrollPane, numOfFaculty);
        this.setCenter(vBox2);


    } // end of SelectPane constructor

    // This method uses the newly added parameter Department object
    // to create a CheckBox and add it to a pane created in the constructor
    // Such check box needs to be linked to its handler class
    public void updateDepartList(Department newdep) {
        // Create checkBox for new department with appropriate text
        this.myCheckBox = new CheckBox(newdep.toString());
        // Bind checkBox toggle action to event handler
        // Passes the number of faculties in each department to the handler. When the checkBox is
        // toggled,this number will be added/subtracted from the total number of selected faculties
        this.myCheckBox.setOnAction(new SelectionHandler(newdep.getNumberOfMembers()));

        // Add new checkBox to checkBox container
        this.vBox1.getChildren().add(myCheckBox);
        this.scrollPane.setContent(vBox1);
    } // end of updateDepartList method

    /**
     * SelectionHandler This class handles a checkBox toggle event. When the
     * checkBox is toggled, this number will be added/subtracted from the total
     * number of selected faculties.
     */
    private class SelectionHandler implements EventHandler<ActionEvent> {
        // Instance variable for number of faculties associated with a given department/checkBox
        private int faculties;
        
        public SelectionHandler(int members) {
            this.faculties = members; // Set instance variable
        } // end of SelectionHandler constructor

        //over-ride the abstract method handle
        public void handle(ActionEvent event) {
            // Get the object that triggered the event, and cast it to a checkBox, since
            // only a department checkBox
            // can trigger the SelectionHandler event. The cast is necessary to have access
            // to the isSelected() method
        	if (((CheckBox)event.getSource()).isSelected())
        	{
        		numOfFacultySelected += faculties;
        	}
        	else
        	{
        		numOfFacultySelected -= faculties;
        	}
            // Update the selected Faculties label with the new number of selected faculties
    		numOfFaculty.setText("The total number of faculty selected: " + numOfFacultySelected);

        } // end handle method
    } // end of SelectHandler class
} // end of SelectPane class
