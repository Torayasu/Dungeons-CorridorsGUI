package com.DungeonsCorridorsGUI.graphics;

import com.DungeonsCorridorsGUI.internal.AttributeSet;
import com.DungeonsCorridorsGUI.internal.Dice;
import com.DungeonsCorridorsGUI.internal.Hero;
import com.DungeonsCorridorsGUI.internal.Monster;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;


public class mainGUI extends Application {

    Stage window;
    Hero hero = new Hero(new AttributeSet(1,1,1,1,1,1));
    Console console = new Console();
    ButtonInterface buttonArea = new ButtonInterface();
    boolean playerIsDead = false;


    public mainGUI() {
    }

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


        EquipmentPane equipmentPane = new EquipmentPane(hero);
        HeroPane heroPane = new HeroPane(hero);
        Map mainMap = new Map();
        MenuDungeons mainMenu = new MenuDungeons();
        MenuBar menu = mainMenu.initMenuDungeons();

        window = primaryStage;
        window.setMaximized(true);
        window.setResizable(false);
        window.setTitle("Dungeons&Corridors");

        VBox invArea = equipmentPane.initEquipmentPane();
        VBox heroArea = heroPane.initHeroPane();
        VBox upperArea = new VBox();
        upperArea.setMaxHeight(150);
        VBox statusArea = console.initConsole();
        statusArea.setMaxHeight(150);
        upperArea.getChildren().addAll(menu,statusArea);
        GridPane actionArea = buttonArea.initButtonInterface();
        GridPane mapArea = mainMap.initMap();

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
        mainArea.setTop(upperArea);
        mainArea.setLeft(heroArea);
        mainArea.setRight(invArea);
        mainArea.setCenter(mapArea);


        buttonArea.setInterfaceToTravel();
        buttonArea.getButton1().setOnAction( e -> { if (!playerIsDead) {mainMap.moveUp();
                                                    checkEncounter();
                                                    heroPane.showStats();}
        });
        buttonArea.getButton2().setOnAction( e -> { if (!playerIsDead) {mainMap.moveDown();
                                                    checkEncounter();
                                                    heroPane.showStats();}
        });
        buttonArea.getButton3().setOnAction( e -> { if (!playerIsDead) {
                                                    mainMap.moveRight();
                                                    checkEncounter();
                                                    heroPane.showStats();}
        });
        buttonArea.getButton4().setOnAction( e -> { if (!playerIsDead) {
                                                    mainMap.moveLeft();
                                                    checkEncounter();
                                                    heroPane.showStats();}
        });


        Scene mainScene = new Scene(mainArea);
        window.setScene(mainScene);
        window.show();
    }

    public void checkEncounter()  {
        Random encounterChance = new Random();
        Dice d20 = new Dice(20);
        boolean monsterIsDead = false;
        int dmgDoneByPlayer = 0;
        int dmgDoneByMonster = 0;
        int tmpHPofPlayer = 0;
        boolean didPlayerHit = false;
        boolean didMonsterHit = false;
        if (encounterChance.nextInt(100)+1 >= 50) {
            Monster monster = new Monster(10,new Dice(4), 0, "RAT", 10, 1);
            console.addMessage(" You encounter a hostile " + monster.getName() + " !");
            while (hero.getHP() > 0 && !monsterIsDead){

               //Hero Attacks
               if (hero.getStats().getStrength().getModifier() + d20.cast() > monster.getArmorClass()) {
                   dmgDoneByPlayer = hero.getEquippedWeapon().getDamageDice().cast() + hero.getEquippedWeapon().getDmgModifier() + hero.getStats().getStrength().getModifier();
                   monster.setHP(monster.getHP() - dmgDoneByPlayer);
                   console.addMessage(" You have done " + dmgDoneByPlayer + " damage to " + monster.getName());
               }
               else {
                   console.addMessage("You have missed !");
               }
               if( monster.getHP() <= 0) {
                   monsterIsDead = true;
                   console.addMessage(monster.getName() + " is Dead !");

               }
               //Monster Attacks
               if (!monsterIsDead) {
                   if (d20.cast() + monster.getMelee() > hero.getArmorClass() ) {
                       dmgDoneByMonster = monster.getDmgDice().cast() + monster.getDmgModifier();
                       console.addMessage(monster.getName() + " did " + dmgDoneByMonster + " damage to you !");
                       tmpHPofPlayer = hero.getHP() - dmgDoneByMonster;
                       hero.setHP(tmpHPofPlayer);
                   }
                   else {
                       console.addMessage("Enemy " +monster.getName() + " missed !");
                   }
               }
           }
           if (hero.getHP() <= 0) {
               console.addMessage("You are DEAD !");
               playerIsDead = true;
           }
           if (monsterIsDead) {
               int tmpExp = hero.getExp()+100;
               hero.setExp(tmpExp);
           }
        }

    }


}