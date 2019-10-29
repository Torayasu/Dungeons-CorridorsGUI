package com.DungeonsCorridorsGUI.graphics;

import com.DungeonsCorridorsGUI.internal.Armor;
import com.DungeonsCorridorsGUI.internal.AttributeSet;
import com.DungeonsCorridorsGUI.internal.Hero;
import com.DungeonsCorridorsGUI.internal.Weapon;
import javafx.geometry.Pos;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;

public class EquipmentPane {

    private VBox equipmentPane = new VBox();

    TreeItem<String> root, armor, weapon, items, gold;
    TreeView<String> equTree;
    Hero hero;


    public EquipmentPane(Hero hero){
        this.hero = hero;

        root = new TreeItem<>();
        root.setExpanded(true);

        armor = makeBranch("Armor", root);
        weapon = makeBranch("Weapon", root);
        items = makeBranch("Items", root);
        gold = makeBranch("Gold", root);

        addWeapons();

        addArmors();

        makeBranch("Health Potion", items);
        makeBranch("Mana Potion", items);

        makeBranch("1000", gold);

        equTree = new TreeView<>(root);
        equTree.setShowRoot(false);
        equTree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue!= null)
                System.out.println(newValue.getValue());
        });
        equipmentPane.getChildren().add(equTree);
        equipmentPane.setAlignment(Pos.TOP_LEFT);

    }

    public VBox initEquipmentPane(){
        return equipmentPane;
    }

    public void addWeapon(Weapon weaponToBeAdded) {
        makeBranch(weaponToBeAdded.getName(),weapon);
    }

    public void addArmor(Armor armorToBeAdded) {
        makeBranch(armorToBeAdded.getName(),armor);
    }

    public void addWeapons() {
        for(Weapon w : hero.getEquipmentSet().getWeapons()){
            makeBranch(w.getName(),weapon);
        }
    }

    public void addArmors() {
        for(Armor a : hero.getEquipmentSet().getArmors()){
            makeBranch(a.getName(),armor);
        }
    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
