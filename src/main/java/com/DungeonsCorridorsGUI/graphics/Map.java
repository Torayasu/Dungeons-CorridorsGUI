package com.DungeonsCorridorsGUI.graphics;

import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;

public class Map {

    private GridPane map = new GridPane();
    private MapTile[][] tiles = new MapTile[11][11];
    private int heroPosX = 5;
    private int heroPosY = 5;

    public Map() throws FileNotFoundException {
        //Init Map Tiles here
        map.setHgap(-1);
        map.setVgap(-1);
        for (int i = 1; i < tiles.length-1; i++){
            tiles[i][0] = new MapTile(3);
            GridPane.setConstraints(tiles[i][0].getMainBox(),i,0);
            map.getChildren().add(tiles[i][0].getMainBox());
        }
        for (int i = 1; i < tiles.length-1; i++) {
            for (int j = 1; j < tiles[0].length-1; j++) {
                tiles[i][j] = new MapTile(4);
                GridPane.setConstraints(tiles[i][j].getMainBox(),i,j);
                map.getChildren().add(tiles[i][j].getMainBox());
            }
        }

        for (int i = 1; i < tiles.length-1; i++){
            tiles[i][10] = new MapTile(3);
            GridPane.setConstraints(tiles[i][10].getMainBox(),i,10);
            tiles[i][10].getMask().setRotate(180);
            map.getChildren().add(tiles[i][10].getMainBox());

        }
        for (int i = 1; i < tiles[0].length-1; i++){
            tiles[0][i] = new MapTile(3);
            GridPane.setConstraints(tiles[0][i].getMainBox(),0,i);
            tiles[0][i].getMask().setRotate(270);
            map.getChildren().add(tiles[0][i].getMainBox());

            tiles[10][i] = new MapTile(3);
            GridPane.setConstraints(tiles[10][i].getMainBox(),10,i);
            tiles[10][i].getMask().setRotate(90);
            map.getChildren().add(tiles[10][i].getMainBox());

        }


        tiles[0][0] = new MapTile(2);
        GridPane.setConstraints(tiles[0][0].getMainBox(),0,0);
        map.getChildren().add(tiles[0][0].getMainBox());
        tiles[0][10] = new MapTile(2);
        GridPane.setConstraints(tiles[0][10].getMainBox(),0,10);
        tiles[0][10].getMask().setRotate(270);
        map.getChildren().add(tiles[0][10].getMainBox());
        tiles[10][0] = new MapTile(1);
        GridPane.setConstraints(tiles[10][0].getMainBox(),10,0);
        map.getChildren().add(tiles[10][0].getMainBox());
        tiles[10][10] = new MapTile(1);
        tiles[10][10].getMask().setRotate(90);
        GridPane.setConstraints(tiles[10][10].getMainBox(),10,10);
        map.getChildren().add(tiles[10][10].getMainBox());


        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tiles[i][j].makeBlank();
            }
        }

        tiles[heroPosX][heroPosY].unBlank();
        tiles[heroPosX][heroPosY].showHero();

    }

    public GridPane initMap() {return map;}

    public void moveUp(){
        if (heroPosY > 0) {
            tiles[heroPosX][heroPosY].hideHero();
            heroPosY--;
            tiles[heroPosX][heroPosY].unBlank();
            tiles[heroPosX][heroPosY].showHero();
        }
    }

    public void moveDown(){
        if (heroPosY < 10) {
            tiles[heroPosX][heroPosY].hideHero();
            heroPosY++;
            tiles[heroPosX][heroPosY].unBlank();
            tiles[heroPosX][heroPosY].showHero();

        }
    }

    public void moveRight(){
        if (heroPosX < 10) {
            tiles[heroPosX][heroPosY].hideHero();
            heroPosX++;
            tiles[heroPosX][heroPosY].unBlank();
            tiles[heroPosX][heroPosY].showHero();
        }
    }

    public void moveLeft(){
        if (heroPosX > 0) {
            tiles[heroPosX][heroPosY].hideHero();
            heroPosX--;
            tiles[heroPosX][heroPosY].unBlank();
            tiles[heroPosX][heroPosY].showHero();

        }
    }

    public int getHeroPosX() {
        return heroPosX;
    }

    public int getHeroPosY() {
        return heroPosY;
    }
}
