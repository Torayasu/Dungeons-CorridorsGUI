import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class mainGUI extends Application {

    Stage window;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setMaximized(true);
        window.setResizable(false);
        window.setTitle("Dungeons&Corridors");

        VBox invArea = new VBox();
        VBox heroArea = new VBox();
        HBox statusArea = new HBox();
        HBox actionArea = new HBox();
        GridPane mapArea = new GridPane();

        Image mapBackground = new Image(new FileInputStream("C:\\Users\\pljawil2\\IdeaProjects\\com.Dungeons&CorridorsGUI\\src\\main\\resources\\front.jpg"));
        ImageView mapBackgroundView = new ImageView(mapBackground);
        mapBackgroundView.setPreserveRatio(true);

        Border standardBorder = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT));

        invArea.setAlignment(Pos.CENTER);
        invArea.setBorder(standardBorder);
        heroArea.setAlignment(Pos.CENTER);
        heroArea.setBorder(standardBorder);
        statusArea.setAlignment(Pos.CENTER);
        statusArea.setBorder(standardBorder);
        actionArea.setAlignment(Pos.CENTER);
        actionArea.setBorder(standardBorder);
        mapArea.setAlignment(Pos.CENTER);
        mapArea.setBorder(standardBorder);


        BorderPane mainArea = new BorderPane();
        mainArea.setPadding(new Insets(20));
        mainArea.setBottom(actionArea);
        mainArea.setTop(statusArea);
        mainArea.setLeft(heroArea);
        mainArea.setRight(invArea);
        mainArea.setCenter(mapArea);

        Button actionButton = new Button();
        actionButton.setText("This will be a button to perform an action");

        Label inventoryLabel = new Label();
        inventoryLabel.setText("Here will be the inventory");

        Label heroLabel = new Label();
        heroLabel.setText("Here we will see the hero stats");
        Label statusLabel = new Label();
        statusLabel.setText("Here we will see status of the game, text messages from console");
        Label mapLabel = new Label();
        mapLabel.setText("This is the place for the map");

        actionArea.getChildren().add(actionButton);
        statusArea.getChildren().add(statusLabel);
        heroArea.getChildren().add(heroLabel);
        invArea.getChildren().add(inventoryLabel);
        mapArea.getChildren().addAll(mapLabel, mapBackgroundView);

        Scene mainScene = new Scene(mainArea);
        window.setScene(mainScene);
        window.show();
    }

}