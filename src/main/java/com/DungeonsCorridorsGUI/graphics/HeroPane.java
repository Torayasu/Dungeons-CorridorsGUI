package com.DungeonsCorridorsGUI.graphics;

import com.DungeonsCorridorsGUI.internal.AttributeSet;
import com.DungeonsCorridorsGUI.internal.Hero;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class HeroPane {
    private VBox heroPane = new VBox();
    ArrayList<Label> labels = new ArrayList<Label>();
    Hero hero;

    public HeroPane(Hero hero){
        this.hero = hero;
        showStats();
    }

    public VBox initHeroPane(){
        return heroPane;
    }

    public void setStats(AttributeSet newStats) {
        hero.setStats(newStats);
    }

    public void showStats() {
        labels.clear();
        heroPane.getChildren().clear();
        labels.add(new Label("Strength:      " + hero.getStats().getStrength()));
        labels.add(new Label("Dexterity:     " + hero.getStats().getDexterity()));
        labels.add(new Label("Constitution   " + hero.getStats().getConstitution()));
        labels.add(new Label("Wisdom:        " + hero.getStats().getWisdom()));
        labels.add(new Label("Intelligence:  " + hero.getStats().getIntelligence()));
        labels.add(new Label("Charisma:      " + hero.getStats().getCharisma()));
        labels.add(new Label("HP:            " + hero.getHP()));
        for (Label l : labels){
            heroPane.getChildren().add(l);
        }
    }
}
