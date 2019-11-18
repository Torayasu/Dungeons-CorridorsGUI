package com.DungeonsCorridorsGUI.graphics;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapTile {
    private StackPane mainBox = new StackPane();
    private ImageView mask, blankMask;
    private Image heroIcon, blank;
    private ImageView heroView;

    public MapTile( int caseOfTile) throws FileNotFoundException {

        try {
            heroIcon = new Image(new FileInputStream("C:\\Users\\pljawil2\\IdeaProjects\\Dungeons-CorridorsGUI\\src\\main\\resources\\images\\heroIcon.jpg"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        heroView = new ImageView(heroIcon);

        try {
            blank = new Image(new FileInputStream("C:\\Users\\pljawil2\\IdeaProjects\\Dungeons-CorridorsGUI\\src\\main\\resources\\images\\blank.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        blankMask = new ImageView(blank);



        switch (caseOfTile){
            case 0: {
                initStraightCorridor();
            }
            break;
            case 1: {
                initLeftTurn();
            }
            break;
            case 2: {
                initRightTurn();
            }
            break;
            case 3: {
                initTJunction();
            }
            break;
            case 4: {
                initXJunction();
            }
            break;
            case 5: {
                initDeadEnd();
            }
            break;
        }
    }

    public void initStraightCorridor() throws FileNotFoundException {
        Image straight = null;
        try {
            straight = new Image(new FileInputStream("C:\\Users\\pljawil2\\IdeaProjects\\Dungeons-CorridorsGUI\\src\\main\\resources\\images\\straight.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mask = new ImageView(straight);
        mainBox.getChildren().add(mask);
    }

    public void initLeftTurn(){
        Image leftTurn = null;
        try {
            leftTurn = new Image(new FileInputStream("C:\\Users\\pljawil2\\IdeaProjects\\Dungeons-CorridorsGUI\\src\\main\\resources\\images\\left_turn.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mask = new ImageView(leftTurn);
        mainBox.getChildren().add(mask);
    }

    public void initRightTurn()
    {
        Image rightTurn = null;
        try {
            rightTurn = new Image(new FileInputStream("C:\\Users\\pljawil2\\IdeaProjects\\Dungeons-CorridorsGUI\\src\\main\\resources\\images\\right_turn.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mask = new ImageView(rightTurn);
        mainBox.getChildren().add(mask);
    }

    public void initTJunction(){
        Image TJunction = null;
        try {
            TJunction = new Image(new FileInputStream("C:\\Users\\pljawil2\\IdeaProjects\\Dungeons-CorridorsGUI\\src\\main\\resources\\images\\T_junction.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mask = new ImageView(TJunction);
        mainBox.getChildren().add(mask);

    }

    public void initXJunction(){
        Image XJunction = null;
        try {
            XJunction = new Image(new FileInputStream("C:\\Users\\pljawil2\\IdeaProjects\\Dungeons-CorridorsGUI\\src\\main\\resources\\images\\x_junction.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mask = new ImageView(XJunction);
        mainBox.getChildren().add(mask);
    }

    public void initDeadEnd(){

    }

    public StackPane getMainBox() {
        return mainBox;
    }

    public void showHero(){
        mainBox.getChildren().add(heroView);
    }

    public void hideHero(){
        mainBox.getChildren().remove(heroView);
    }

    public ImageView getMask() {
        return mask;
    }

    public void makeBlank () {
        mainBox.getChildren().clear();
        mainBox.getChildren().add(blankMask);
    }

    public void unBlank() {
        mainBox.getChildren().clear();
        mainBox.getChildren().add(mask);
    }
}
