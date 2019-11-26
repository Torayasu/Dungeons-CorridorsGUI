package com.DungeonsCorridorsGUI.graphics;

import com.DungeonsCorridorsGUI.internal.AttributeSet;
import com.DungeonsCorridorsGUI.internal.Hero;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class CharacterCreationWindow {
    private Scene scene;
    private GridPane gridPane = new GridPane();
    private ArrayList<AttributeSettingButtons> attributes = new ArrayList<>();
    private Label infoLabel = new Label();
    private Hero hero;

    public CharacterCreationWindow(Hero hero){
        this.hero = hero;
        attributes.add(new AttributeSettingButtons("Strength"));
        attributes.add(new AttributeSettingButtons("Dexterity"));
        attributes.add(new AttributeSettingButtons("Constitution"));
        attributes.add(new AttributeSettingButtons("Wisdom"));
        attributes.add(new AttributeSettingButtons("Intelligence"));
        attributes.add(new AttributeSettingButtons("Charisma"));

        attributes.get(0).getPlusButton().setOnAction(e -> increaseAttribute(attributes.get(0)));
        attributes.get(1).getPlusButton().setOnAction(e -> increaseAttribute(attributes.get(1)));
        attributes.get(2).getPlusButton().setOnAction(e -> increaseAttribute(attributes.get(2)));
        attributes.get(3).getPlusButton().setOnAction(e -> increaseAttribute(attributes.get(3)));
        attributes.get(4).getPlusButton().setOnAction(e -> increaseAttribute(attributes.get(4)));
        attributes.get(5).getPlusButton().setOnAction(e -> increaseAttribute(attributes.get(5)));

        attributes.get(0).getMinusButton().setOnAction(e -> decreaseAttribute(attributes.get(0)));
        attributes.get(1).getMinusButton().setOnAction(e -> decreaseAttribute(attributes.get(1)));
        attributes.get(2).getMinusButton().setOnAction(e -> decreaseAttribute(attributes.get(2)));
        attributes.get(3).getMinusButton().setOnAction(e -> decreaseAttribute(attributes.get(3)));
        attributes.get(4).getMinusButton().setOnAction(e -> decreaseAttribute(attributes.get(4)));
        attributes.get(5).getMinusButton().setOnAction(e -> decreaseAttribute(attributes.get(5)));


        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        GridPane.setConstraints(attributes.get(0).initAttributeSettingButtons(),2,0);
        GridPane.setConstraints(attributes.get(1).initAttributeSettingButtons(),2,1);
        GridPane.setConstraints(attributes.get(2).initAttributeSettingButtons(),2,2);
        GridPane.setConstraints(attributes.get(3).initAttributeSettingButtons(),2,3);
        GridPane.setConstraints(attributes.get(4).initAttributeSettingButtons(),2,4);
        GridPane.setConstraints(attributes.get(5).initAttributeSettingButtons(),2,5);
        GridPane.setConstraints(infoLabel,2,6);
        infoLabel.setText("Sum of all attribute points can't exceed 60 points. \n Individual attribute can't exceed 18 points \n Close this window, when you are done setting up");


        for (AttributeSettingButtons aSB : attributes){
            gridPane.getChildren().add(aSB.initAttributeSettingButtons());
        }
        gridPane.getChildren().add(infoLabel);

        scene = new Scene(gridPane);
    }


    public void increaseAttribute(AttributeSettingButtons aSB){
        int tmpStatValue = Integer.valueOf(aSB.getAttributeValueField().getText());
        int sum = summarizeStats();
        if (sum < 60 && tmpStatValue < 18){
            aSB.getAttributeValueField().setText(String.valueOf(++tmpStatValue));
        }
    }

    public void decreaseAttribute(AttributeSettingButtons aSB){
        int tmpStatValue = Integer.valueOf(aSB.getAttributeValueField().getText());
        if (tmpStatValue > 1){
            aSB.getAttributeValueField().setText(String.valueOf(--tmpStatValue));
        }
    }

    public int summarizeStats(){
        int sum = 0;
        for (AttributeSettingButtons internalASB : attributes) {
            sum += Integer.valueOf(internalASB.getAttributeValueField().getText());
        }
        return sum;
    }

    public void initTheHero(){
        hero.setStats(new AttributeSet(
                Integer.valueOf(attributes.get(0).getAttributeValueField().getText()),
                Integer.valueOf(attributes.get(1).getAttributeValueField().getText()),
                Integer.valueOf(attributes.get(2).getAttributeValueField().getText()),
                Integer.valueOf(attributes.get(3).getAttributeValueField().getText()),
                Integer.valueOf(attributes.get(4).getAttributeValueField().getText()),
                Integer.valueOf(attributes.get(5).getAttributeValueField().getText())));
    }


    public Scene getScene() {
        return scene;
    }
}
