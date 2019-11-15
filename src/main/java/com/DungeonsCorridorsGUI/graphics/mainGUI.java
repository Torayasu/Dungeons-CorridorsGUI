package com.DungeonsCorridorsGUI.graphics;

import com.DungeonsCorridorsGUI.graphics.ButtonInterface;
import com.DungeonsCorridorsGUI.graphics.CharacterCreationWindow;
import com.DungeonsCorridorsGUI.graphics.Console;
import com.DungeonsCorridorsGUI.graphics.EquipmentPane;
import com.DungeonsCorridorsGUI.internal.AttributeSet;
import com.DungeonsCorridorsGUI.internal.Hero;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class mainGUI extends Application {

    Stage window;
    Hero hero = new Hero(new AttributeSet(1,1,1,1,1,1));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Here we will show the Title Screen

        // Here I will handle the character creation
        CharacterCreationWindow characterCreationWindow = new CharacterCreationWindow(hero);
        Stage newWindow = new Stage();
        Scene newScene = characterCreationWindow.getScene();
        newWindow.setScene(newScene);
        newWindow.setMaximized(false);
        newWindow.setMaxHeight(600);
        newWindow.setMaxWidth(600);
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.setOnCloseRequest(e -> characterCreationWindow.initTheHero());
        newWindow.showAndWait();

        Console console = new Console();
        ButtonInterface buttonArea = new ButtonInterface();
        EquipmentPane equipmentPane = new EquipmentPane(hero);
        HeroPane heroPane = new HeroPane(hero);
        Map mainMap = new Map();

        window = primaryStage;
        window.setMaximized(true);
        window.setResizable(false);
        window.setTitle("Dungeons&Corridors");

        VBox invArea = equipmentPane.initEquipmentPane();
        VBox heroArea = heroPane.initHeroPane();
        VBox statusArea = console.initConsole();
        GridPane actionArea = buttonArea.initButtonInterface();
        GridPane mapArea = mainMap.initMap();

        //Image mapBackground = new Image(new FileInputStream("C:\\Users\\pljawil2\\IdeaProjects\\com.Dungeons&CorridorsGUI\\src\\main\\resources\\front.jpg"));

        //ImageView mapBackgroundView = new ImageView(mapBackground);
        //mapBackgroundView.setPreserveRatio(true);

        Border standardBorder = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT));

        invArea.setAlignment(Pos.CENTER);
        invArea.setBorder(standardBorder);
        heroArea.setAlignment(Pos.CENTER);
        heroArea.setBorder(standardBorder);
        statusArea.setAlignment(Pos.CENTER);
        statusArea.setBorder(standardBorder);
        actionArea.setAlignment(Pos.CENTER);
        actionArea.setBorder(standardBorder);
        mapArea.setAlignment(Pos.CENTER);
        mapArea.setBorder(standardBorder);


        BorderPane mainArea = new BorderPane();
        mainArea.setPadding(new Insets(20));
        mainArea.setBottom(actionArea);
        mainArea.setTop(statusArea);
        mainArea.setLeft(heroArea);
        mainArea.setRight(invArea);
        mainArea.setCenter(mapArea);


        buttonArea.setInterfaceToTravel();
        buttonArea.getButton1().setOnAction( e -> mainMap.moveUp());
        buttonArea.getButton2().setOnAction( e -> mainMap.moveDown());
        buttonArea.getButton3().setOnAction( e -> mainMap.moveRight());
        buttonArea.getButton4().setOnAction( e -> mainMap.moveLeft());


        Scene mainScene = new Scene(mainArea);
        window.setScene(mainScene);
        window.show();
    }



}