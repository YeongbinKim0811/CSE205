// Assignment #7: Arizona State University CSE205
//          Name: Yeongbin Kim
//     StudentID: 1217898110
//       Lecture: T/TH 4:30 - 5:45
//   Description: CirclePane class creates a pane where we can use
//                mouse key to drag on canvass and there will be some color following
//                the mouse. We can also use combo boxes to change its colors and stroke widths

//import any necessary classes here
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CirclePane extends BorderPane
{
    //instance variables
    private ComboBox<String> primaryColorCombo;
    private ComboBox<String> bgColorCombo;
    private ComboBox<String> widthCombo;
    private Circle[][] circleArray;
    private Color primaryColor;
    private Color secondaryColor;
    private Color bgColor;
    private int selectWidth;
    private Label label1;	//Label for PrimaryColor
    private Label label2;	//Label for BackgroundColor
    private Label label3;	//Label for StrokeWidth
    private final int NUM_COL =6, NUM_ROW = 6, RADIUS = 40;
    private GridPane canvas;	//this is where circles are drawn
    private Circle circle;

    //constructor
    public CirclePane()
    {
        //Step #1: Initialize instance variables and set up the layout
		primaryColorCombo = new ComboBox<String>();
		primaryColorCombo.getItems().addAll("Black", "Red", "Green", "Blue");
		primaryColorCombo.setValue("Black");     //Set default value
		primaryColor = Color.BLACK;
		secondaryColor = Color.GRAY;
		bgColorCombo = new ComboBox<String>();
		bgColorCombo.getItems().addAll("White", "Beige", "AliceBlue", "Gold");
		bgColorCombo.setValue("White");     //Set default value
		widthCombo = new ComboBox<String>();
		widthCombo.getItems().addAll("1", "3", "5", "7");
		widthCombo.setValue("1");	//Set default value
		primaryColor = Color.BLACK;
		secondaryColor = Color.GRAY;
		bgColor = Color.WHITE;
		selectWidth = 1;
		label1 = new Label("PrimaryColor");
		label2 = new Label("BackgroundColor");
		label3 = new Label("StrokeWidth");
		
        //Instantiate the two dimensional circleArray that contains
        //6 columns and 6 rows of circles (36 in total)
		circleArray = new Circle[NUM_ROW][NUM_COL];

        //instantiate canvas and set its width and height
        canvas = new GridPane();
        canvas.setPrefWidth(2*RADIUS * NUM_COL);
        canvas.setPrefHeight(2*RADIUS * NUM_ROW);

        //Use nested loop to instantiate the 6 columns by 6 rows of
        //Circle objects, add them inside the circleArrary
        for (int i = 0; i < circleArray.length; i++)
        {
        	for (int j = 0; j < circleArray[i].length; j++)
        	{
        		circle = new Circle(RADIUS, RADIUS, RADIUS);
        		circle.setFill(bgColor);
        		circle.setStroke(Color.BLACK);
        		circle.setStrokeWidth(selectWidth);
        		circleArray[i][j] = circle;
        		canvas.add(circle, j, i);
        	}
        }

        //leftPane is a VBox, it should contain labels and the 3 comboBox
        VBox leftPane = new VBox();
        leftPane.setSpacing(20);
        leftPane.setPadding(new Insets(10, 10, 10, 10));
        leftPane.setStyle("-fx-border-color: black");
        leftPane.getChildren().addAll(label1, primaryColorCombo, label2, bgColorCombo, label3, widthCombo);

        //add leftPane and canvas to CirclePane
        this.setLeft(leftPane);
        this.setRight(canvas);

        //Step 3: register the source nodes with its handler objects
        canvas.setOnMouseDragged(new MouseHandler());
        canvas.setOnMouseReleased(new MouseHandler());
        primaryColorCombo.setOnAction(new PrimaryColorHandler());
        bgColorCombo.setOnAction(new BackgroundColorHandler());
        widthCombo.setOnAction(new WidthHandler());
    }

    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent>
    {
        public void handle(MouseEvent event)
        {
        	if (event.getEventType() == MouseEvent.MOUSE_DRAGGED)
        	{
	       		double draggedPointX = event.getX();     //This is a horizontal position of the event
	       		draggedPointX = (int) (draggedPointX / (2 * RADIUS));     //Make draggedPointX into integer
        		double draggedPointY = event.getY();     //This is a vertical position of the event
        		draggedPointY = (int) (draggedPointY / (2 * RADIUS));     //Make draggedPointY into integer
           		for (int row = 0; row < circleArray.length; row++)
        		{
        			for (int col = 0; col < circleArray[row].length; col++)
        			{
        				if (draggedPointX == col && draggedPointY == row)
        				{
        					for (int i = 0; i < circleArray.length; i++)     //This nested for loop is for letting back the color of previous circle to bgColor
        					{
        						for (int j = 0; j < circleArray[i].length; j++)
        						{
        							circleArray[i][j].setFill(bgColor);
        						}
        					}
        					circleArray[row][col].setFill(primaryColor);
        					if (row >= 1 && row <= 4 && col >= 1 && col <= 4)
        					{
        						circleArray[row+1][col].setFill(secondaryColor);
        						circleArray[row-1][col].setFill(secondaryColor);
        						circleArray[row][col+1].setFill(secondaryColor);
        						circleArray[row][col-1].setFill(secondaryColor);
        					}
        					if (row == 0)
        					{
        						circleArray[row+1][col].setFill(secondaryColor);
        					}
        					if (row == 5)
        					{
        						circleArray[row-1][col].setFill(secondaryColor);
        						
        					}
        					if (col >= 1 && col <= 4)
    						{
    							circleArray[row][col-1].setFill(secondaryColor);
    							circleArray[row][col+1].setFill(secondaryColor);
    						}
        					if (col == 0)
        					{
        						circleArray[row][col+1].setFill(secondaryColor);
        					}
        					if (col == 5)
        					{
        						circleArray[row][col-1].setFill(secondaryColor);
        					}
        					if (row >= 1 && row <= 4)
        					{
        						circleArray[row+1][col].setFill(secondaryColor);
        						circleArray[row-1][col].setFill(secondaryColor);
        					}
        				}
        			}
        		}
        	}
        }
    }//end MouseHandler

	//Step #2(B) - Primary and secondary color handler
    private class PrimaryColorHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
			if (primaryColorCombo.getValue().equalsIgnoreCase("black"))
			{
				primaryColor = Color.BLACK;
				secondaryColor = Color.GRAY;
			}
			else if (primaryColorCombo.getValue().equalsIgnoreCase("red"))
			{
				primaryColor = Color.RED;
				secondaryColor = Color.PINK;
			}
			else if (primaryColorCombo.getValue().equalsIgnoreCase("green"))
			{
				primaryColor = Color.GREEN;
				secondaryColor = Color.LIGHTGREEN;
			}
			else if (primaryColorCombo.getValue().equalsIgnoreCase("blue"))
			{
				primaryColor = Color.BLUE;
				secondaryColor = Color.POWDERBLUE;
			}

		}
    }//end PrimaryColorHandler

    //Step #2(C): background color handler
    //Write a private class called BackgroundColorHandler that handles the background
    //color changes
    private class BackgroundColorHandler implements EventHandler<ActionEvent>
    {
    	public void handle(ActionEvent event)
    	{
    		if (bgColorCombo.getValue().equalsIgnoreCase("white"))
    		{
    			bgColor = Color.WHITE;
    		}
    		else if (bgColorCombo.getValue().equalsIgnoreCase("beige"))
    		{
    			bgColor = Color.BEIGE;
    		}
    		else if (bgColorCombo.getValue().equalsIgnoreCase("aliceblue"))
    		{
    			bgColor = Color.ALICEBLUE;
    		}
    		else if (bgColorCombo.getValue().equalsIgnoreCase("gold"))
    		{
    			bgColor = Color.GOLD;
    		}
    		
            for (int row = 0; row < circleArray.length; row++)
            {
            	for (int col = 0; col < circleArray[row].length; col++)
            	{
            		circleArray[row][col].setFill(bgColor);
            	}
            }
    	}
    }

    //Step #2(D): handle the stroke width
    private class WidthHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
        	selectWidth = Integer.parseInt(widthCombo.getValue());
            for (int row = 0; row < circleArray.length; row++)
            {
            	for (int col = 0; col < circleArray[row].length; col++)
            	{
               		circleArray[row][col].setStrokeWidth(selectWidth);
            	}
            }
        }
    }//end of WidthHandler
} //end of CirclePane