import javafx.geometry.Pos;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;

public class EquipmentPane {

    private VBox equipmentPane = new VBox();

    TreeItem<String> root, armor, weapon, items, gold;
    TreeView<String> equTree;


    public EquipmentPane(){
        root = new TreeItem<>();
        root.setExpanded(true);

        armor = makeBranch("Armor", root);
        weapon = makeBranch("Weapon", root);
        items = makeBranch("Weapon", root);
        gold = makeBranch("Weapon", root);

        makeBranch("IronArmor", armor);
        makeBranch("Steel Armor", armor);

        makeBranch("Dagger",weapon);
        makeBranch("Sword", weapon);

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

    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
