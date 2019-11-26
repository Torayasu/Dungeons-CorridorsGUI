package com.DungeonsCorridorsGUI.graphics;

import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Console {

    private VBox consoleArea = new VBox();
    private LinkedList<Label> messages = new LinkedList<>();
    private TreeView<String> consoleTree;
    private TreeItem<String> root;

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


    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

}
