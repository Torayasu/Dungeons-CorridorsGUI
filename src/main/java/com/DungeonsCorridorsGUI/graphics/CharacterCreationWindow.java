package com.DungeonsCorridorsGUI.graphics;

import com.DungeonsCorridorsGUI.internal.AttributeSet;
import com.DungeonsCorridorsGUI.internal.AttributeSettingButtons;
import com.DungeonsCorridorsGUI.internal.Hero;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class CharacterCreationWindow {
    private Scene scene;
    private GridPane gridPane = new GridPane();
    private ArrayList<AttributeSettingButtons> attributes = new ArrayList<>();
    private Button doneButton = new Button("Done");
    private Button verifyButton = new Button("Verify");
    private boolean pointLimitExceeded = false;
    private Hero hero;

    public CharacterCreationWindow(Hero hero){
        this.hero = hero;
        attributes.add(new AttributeSettingButtons("Strength"));
        attributes.add(new AttributeSettingButtons("Dexterity"));
        attributes.add(new AttributeSettingButtons("Constitution"));
        attributes.add(new AttributeSettingButtons("Wisdom"));
        attributes.add(new AttributeSettingButtons("Intelligence"));
        attributes.add(new AttributeSettingButtons("Charisma"));

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        GridPane.setConstraints(attributes.get(0).initAttributeSettingButtons(),2,0);
        GridPane.setConstraints(attributes.get(1).initAttributeSettingButtons(),2,1);
        GridPane.setConstraints(attributes.get(2).initAttributeSettingButtons(),2,2);
        GridPane.setConstraints(attributes.get(3).initAttributeSettingButtons(),2,3);
        GridPane.setConstraints(attributes.get(4).initAttributeSettingButtons(),2,4);
        GridPane.setConstraints(attributes.get(5).initAttributeSettingButtons(),2,5);


        for (AttributeSettingButtons aSB : attributes){
            gridPane.getChildren().add(aSB.initAttributeSettingButtons());
        }

        verifyButton.setOnAction(e -> verifyAttributes());

        scene = new Scene(gridPane);
    }

    public void verifyAttributes(){
        int sum =0;
        for (AttributeSettingButtons aSB : attributes) {
            sum += Integer.valueOf(aSB.getAttributeValueField().getText());
        }
        if (sum >= 30){
            pointLimitExceeded = true;
        }
        else {
            pointLimitExceeded = false;
        }

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
