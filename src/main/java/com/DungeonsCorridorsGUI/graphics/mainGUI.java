package com.DungeonsCorridorsGUI.graphics;

import com.DungeonsCorridorsGUI.internal.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    EquipmentPane equipmentPane = new EquipmentPane(hero);
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

        equipmentPane.getEquTree().getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            verifyWeapon();
            verifyArmor();
            heroPane.showStats();
        });

        buttonArea.setInterfaceToTravel();
        buttonArea.getButton1().setOnAction( e -> { int  tmpPosY;
                                                    tmpPosY = mainMap.getHeroPosY();
                                                    if (!playerIsDead) {mainMap.moveUp();
                                                    if (tmpPosY != mainMap.getHeroPosY()) {checkEncounter();}
                                                    heroPane.showStats();
                                                    verifyGameOver(window);}
        });
        buttonArea.getButton2().setOnAction( e -> { if (!playerIsDead) {
                                                    int  tmpPosY;
                                                    tmpPosY = mainMap.getHeroPosY();
                                                    mainMap.moveDown();
                                                    if (tmpPosY != mainMap.getHeroPosY()) {checkEncounter();}
                                                    heroPane.showStats();
                                                    verifyGameOver(window);}
        });
        buttonArea.getButton3().setOnAction( e -> { if (!playerIsDead) {
                                                    int  tmpPosX;
                                                    tmpPosX = mainMap.getHeroPosX();
                                                    mainMap.moveRight();
                                                    if (tmpPosX != mainMap.getHeroPosX()) {checkEncounter();}
                                                    heroPane.showStats();
                                                    verifyGameOver(window);}
        });
        buttonArea.getButton4().setOnAction( e -> { if (!playerIsDead) {
                                                    int  tmpPosX;
                                                    tmpPosX = mainMap.getHeroPosX();
                                                    mainMap.moveLeft();
                                                    if (tmpPosX != mainMap.getHeroPosX()) {checkEncounter();};
                                                    heroPane.showStats();
                                                    verifyGameOver(window);}
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
        if (encounterChance.nextInt(100)+1 >= 50) {
            Monster monster = new Monster(10,new Dice(4), 0, "RAT", 10, 1);
            console.addMessage(" You encounter a hostile " + monster.getName() + " !");
            while (hero.getHP() > 0 && !monsterIsDead){

               //Hero Attacks
               if (hero.getStats().getStrength().getModifier() + d20.cast() > monster.getArmorClass()) {
                   dmgDoneByPlayer = hero.getEquippedWeapon().getDamageDice().cast() + hero.getEquippedWeapon().getDmgModifier() + hero.getStats().getStrength().getModifier();
                   if (dmgDoneByPlayer < 1) {
                       dmgDoneByPlayer = 0;
                   }
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
               Dice ExpDice = new Dice(100);
               int tmpExp = hero.getExp()+ExpDice.cast()+50;
               hero.setExp(tmpExp);
           }
        }

    }


    public void verifyWeapon(){
        for (Weapon w : hero.getEquipmentSet().getWeapons())
        {
            if (equipmentPane.getSelectedWeapon().equals(w.getName())) {
                hero.setEquippedWeapon(w);
            }
            else {
            }
        }
    }

    public void verifyArmor(){
        for (Armor a : hero.getEquipmentSet().getArmors()){
            if (equipmentPane.getSelectedArmor().equals(a.getName())) {
                hero.setEquippedArmor(a);
            }
        }
    }

    public void verifyGameOver(Stage window){
        if (playerIsDead || hero.getLevel() == 5){

            VBox gameOverArea = new VBox();
            gameOverArea.setMinHeight(200);
            gameOverArea.setMaxHeight(200);
            gameOverArea.setMinWidth(200);
            gameOverArea.setMaxWidth(200);
            gameOverArea.setAlignment(Pos.CENTER);

            Label gameOverLabel = new Label("Game Over");

            gameOverArea.getChildren().add(gameOverLabel);

            Scene gameOverScene = new Scene(gameOverArea);

            Stage gameOverWindow = new Stage();
            gameOverWindow.setScene(gameOverScene);

            gameOverWindow.initModality(Modality.APPLICATION_MODAL);

            gameOverWindow.showAndWait();

            window.close();
        }

    }

}