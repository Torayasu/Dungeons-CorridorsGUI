import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.LinkedList;

public class Console {

    private VBox consoleArea = new VBox();
    private Label row1 = new Label();
    private Label row2 = new Label();
    private Label row3 = new Label();
    private LinkedList<String> messages = new LinkedList<>();

    public Console(){
        row1.setText("Welcome to Dungeons & Corridors");
        row2.setText("@Copyright Torayasu 2019");
        row3.setText("Let the adventure begin !");
        consoleArea.setAlignment(Pos.CENTER);
        consoleArea.getChildren().addAll(row1,row2,row3);

    }

    public VBox initConsole(){
        messages.push(row1.getText());
        messages.push(row2.getText());
        messages.push(row3.getText());
        return consoleArea;
    }

    public void addMessage(String message){
        messages.push(message);
        row3.setText(row2.getText());
        row2.setText(row1.getText());
        row1.setText(message);
    }

    public void clearConsole() {
        row1.setText("");
        row2.setText("");
        row3.setText("");
    }

}
