package com.DungeonsCorridorsGUI.graphics;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class AttributeSettingButtons extends Node {

    private Button plusButton = new Button("+");
    private Button minusButton = new Button("-");
    private Label label = new Label();
    private TextArea attributeValueField = new TextArea("10");

    private GridPane layout = new GridPane();

    public AttributeSettingButtons(String attributeName){
        label.setText(attributeName);
        plusButton.setPrefSize(30,30);
        minusButton.setPrefSize(30,30);
        label.setPrefSize(100, 30);
        attributeValueField.setPrefSize(100,30);
        attributeValueField.setEditable(false);

        GridPane.setConstraints(label,0,0);
        GridPane.setConstraints(attributeValueField,0,1);
        GridPane.setConstraints(plusButton,1,0);
        GridPane.setConstraints(minusButton,1,1);
        layout.getChildren().addAll(label,plusButton,minusButton,attributeValueField);
    }

    public GridPane initAttributeSettingButtons(){
        return layout;
    }


    public TextArea getAttributeValueField() {
        return attributeValueField;
    }

    public Button getPlusButton() {
        return plusButton;
    }

    public Button getMinusButton() {
        return minusButton;
    }
}
