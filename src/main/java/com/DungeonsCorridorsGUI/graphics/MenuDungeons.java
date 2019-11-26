package com.DungeonsCorridorsGUI.graphics;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuDungeons {
    private MenuBar menuBar;
    private Menu fileMenu;
    private Menu helpMenu;
    private MenuItem NewGame, SaveGame, LoadGame;
    private MenuItem About;

    public MenuDungeons() {
        NewGame = new MenuItem("Start a New Game");
        SaveGame = new MenuItem("Save current game");
        LoadGame = new MenuItem("Load a game");
        NewGame.setDisable(true);
        SaveGame.setDisable(true);
        LoadGame.setDisable(true);

        About = new MenuItem("About");
        About.setOnAction(e -> displayAbout());

        fileMenu = new Menu("File");
        helpMenu = new Menu("Help");

        fileMenu.getItems().addAll(NewGame,SaveGame,LoadGame);
        helpMenu.getItems().add(About);

        menuBar = new MenuBar();

        menuBar.getMenus().addAll(fileMenu,helpMenu);

    }
    public MenuBar initMenuDungeons (){
        return menuBar;
    }

    public void displayAbout(){
        Stage aboutWindow = new Stage();
        VBox aboutVBox = new VBox();
        Label label = new Label("Here the help message will appear \n And it will be helpful \n Sooo very helpful \n");

        aboutVBox.getChildren().add(label);
        Scene aboutScene = new Scene(aboutVBox);
        aboutWindow.setScene(aboutScene);
        aboutWindow.initModality(Modality.APPLICATION_MODAL);
        aboutWindow.showAndWait();
    }
}
