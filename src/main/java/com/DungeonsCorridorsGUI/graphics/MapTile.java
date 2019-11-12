package com.DungeonsCorridorsGUI.graphics;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class MapTile {
    private boolean isUpPossible, isDownPossible, isLeftPossible, isRightPossible;
    private boolean isPreviousUp, isPreviousDown, isPreviousLeft, isPreviousRight;
    private ImageView mask;

    public MapTile( boolean isPreviousUp, boolean isPreviousDown, boolean isPreviousLeft, boolean isPreviousRight){

        /*Random randomizer = new Random();
        switch (randomizer.nextInt(6)){
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

        }*/
        initStraightCorridor();
    }

    public void initStraightCorridor(){
        if (isPreviousDown | isPreviousUp) {
            isDownPossible = true;
            isLeftPossible = false;
            isRightPossible = false;
            isUpPossible = true;
            mask = new ImageView(new Image("straight.jpg"));
        }
        if (isPreviousLeft | isPreviousRight) {
            isLeftPossible = true;
            isDownPossible = false;
            isUpPossible = false;
            isRightPossible = true;
        }


    }

    public void initLeftTurn(){
        if (isPreviousDown) {
            isDownPossible = true;
            isLeftPossible = true;
            isRightPossible = false;
            isUpPossible = false;
        }
        if (isPreviousUp) {
            isUpPossible = true;
            isLeftPossible = false;
            isRightPossible = true;
            isDownPossible = false;
        }
        if (isPreviousLeft) {
            isLeftPossible = true;
            isDownPossible = true;
            isUpPossible = false;
            isRightPossible = false;
        }
        if (isPreviousRight) {
            isRightPossible = true;
            isDownPossible = false;
            isUpPossible = true;
            isLeftPossible = false;
        }
    }

    public void initRightTurn(){
        if (isPreviousDown) {
            isDownPossible = true;
            isLeftPossible = false;
            isRightPossible = true;
            isUpPossible = false;
        }
        if (isPreviousUp) {
            isUpPossible = true;
            isLeftPossible = true;
            isRightPossible = false;
            isDownPossible = false;
        }
        if (isPreviousLeft) {
            isLeftPossible = true;
            isDownPossible = false;
            isUpPossible = true;
            isRightPossible = false;
        }
        if (isPreviousRight) {
            isRightPossible = true;
            isDownPossible = true;
            isUpPossible = false;
            isLeftPossible = false;
        }
    }

    public void initTJunction(){
        if (isPreviousDown) {
            isDownPossible = true;
            isLeftPossible = true;
            isRightPossible = true;
            isUpPossible = false;
        }
        if (isPreviousUp) {
            isUpPossible = true;
            isLeftPossible = true;
            isRightPossible = true;
            isDownPossible = false;
        }
        if (isPreviousLeft) {
            isLeftPossible = true;
            isDownPossible = true;
            isUpPossible = true;
            isRightPossible = false;
        }
        if (isPreviousRight) {
            isRightPossible = true;
            isDownPossible = true;
            isUpPossible = true;
            isLeftPossible = false;
        }
    }

    public void initXJunction(){
       isLeftPossible = true;
       isRightPossible = true;
       isUpPossible = true;
       isDownPossible = true;
    }

    public void initDeadEnd(){
        if (isPreviousDown) {
            isDownPossible = true;
            isLeftPossible = false;
            isRightPossible = false;
            isUpPossible = false;
        }
        if (isPreviousUp) {
            isUpPossible = true;
            isLeftPossible = false;
            isRightPossible = false;
            isDownPossible = false;
        }
        if (isPreviousLeft) {
            isLeftPossible = true;
            isDownPossible = false;
            isUpPossible = false;
            isRightPossible = false;
        }
        if (isPreviousRight) {
            isRightPossible = true;
            isDownPossible = false;
            isUpPossible = false;
            isLeftPossible = false;
        }
    }

}
