package com.DungeonsCorridorsGUI.graphics;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

public class Console {

    private VBox consoleArea = new VBox();
    private LinkedList<Label> messages = new LinkedList<>();
    TreeView<String> consoleTree;
    TreeItem<String> root;

    public Console(){

        messages.addLast(new Label("Welcome to Dungeons and Corridors !"));
        messages.addLast(new Label("@Copyright Torayasu 2019"));

        root = new TreeItem<>();
        consoleTree = new TreeView<>(root);
        consoleTree.setShowRoot(false);
        makeBranch("Welcome to Dungeons and Corridors !",root);
        makeBranch("@Copyright Torayasu 2019",root);
        consoleArea.getChildren().add(consoleTree);
        consoleArea.setMaxHeight(150);
        /*row1.setText("Welcome to Dungeons & Corridors");
        row2.setText("@Copyright Torayasu 2019");
        row3.setText("Let the adventure begin !");
        row4.setText("You stare a murky underground tunnel");
        row5.setText("Take a direction");
        consoleArea.setAlignment(Pos.CENTER);
        consoleArea.getChildren().addAll(row1,row2,row3,row4,row5);*/

    }

    public VBox initConsole(){
        return consoleArea;
    }

    public void addMessage(String message){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        makeBranch(now.format(format) + " : " + message,root);
        consoleTree.scrollTo(65535);
    }

    public void clearConsole() {

    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

}
