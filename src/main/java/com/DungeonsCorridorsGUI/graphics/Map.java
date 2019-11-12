package com.DungeonsCorridorsGUI.graphics;

import javafx.scene.layout.GridPane;

public class Map {

    private GridPane map = new GridPane();
    private MapTile[][] tiles = new MapTile[11][11];

    public Map(){
        //Init Map Tiles here
        initFirstCircle();
    }

    public GridPane initMap() {return map;}

    public void initFirstCircle(){}


}
