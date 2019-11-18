package com.DungeonsCorridorsGUI.graphics;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ButtonInterface {
    private GridPane buttonInterfaceArea = new GridPane();
    private Button button1 = new Button();
    private Button button2 = new Button();
    private Button button3 = new Button();
    private Button button4 = new Button();

    public ButtonInterface(){
        GridPane.setConstraints(button1,1,0);
        GridPane.setConstraints(button2,1,2);
        GridPane.setConstraints(button3,2,1);
        GridPane.setConstraints(button4,0,1);
        buttonInterfaceArea.getChildren().addAll(button1,button2,button3,button4);
        button1.setText(" Add message");
        button2.setText(" Inactive Button");
        button3.setText(" Inactive Button");
        button4.setText(" Inactive Button");
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
    }

    public GridPane initButtonInterface(){
        return buttonInterfaceArea;
    }

    public void setInterfaceToTravel(){
        button1.setText("  Go Up  ");
        button2.setText("Go Down");
        button3.setText("Go Right");
        button4.setText("Go Left");
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
    }

    public void setInterfaceToBattle (){
        button1.setText(" Attack");
        button2.setText(" Drink Potion");
        button3.setText(" Inactive Button");
        button4.setText(" Inactive Button");
        button3.setDisable(true);
        button4.setDisable(true);
    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
    }

    public Button getButton3() {
        return button3;
    }

    public Button getButton4() {
        return button4;
    }
}
