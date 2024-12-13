package edu.miracosta.cs112.lab07;//package name here depending on your IDE

import javafx.application.Application;  //abstract class used for JavaFX GUI's
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;              //class for GUI window
import javafx.scene.Scene;              //class for specific view in GUI window
import javafx.scene.layout.VBox;        //class for layout pane, organized top-to-bottom
import javafx.scene.control.Label;      //class for label component
import javafx.scene.control.Button;     //class for button component
import javafx.event.EventHandler;       //interface for handling events
import javafx.event.ActionEvent;        //class for type of event for action (like button or key pressed)

public class HelloApplication extends Application implements EventHandler<ActionEvent>  { //inheriting core functionality + this class will handle events

    /*** DRIVER main ***/
    public static void main(String[] args) {
        launch(args); //method from Application class, must be called to setup javafx application
    }

    Button button1, button2;
    Label label1, label2;
    TextField textField;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello GUI: Andrew Sorem");
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        AnchorPane anchorPane = new AnchorPane();

        label1 = new Label("Hello GUI World");
        anchorPane.setTopAnchor(label1, 30.0);
        anchorPane.setRightAnchor(label1, 30.0);
        anchorPane.getChildren().add(label1);

        label2 = new Label("Hello World");
        anchorPane.setTopAnchor(label2, 30.0);
        anchorPane.setLeftAnchor(label2, 30.0);
        anchorPane.getChildren().add(label2);
        layout.getChildren().add(anchorPane);

        textField = new TextField();
        textField.setPromptText("Enter text here");
        anchorPane.setTopAnchor(textField, 150.0);
        anchorPane.setLeftAnchor(textField, 75.0);
        anchorPane.setRightAnchor(textField, 75.0);
        anchorPane.getChildren().add(textField);

        button1 = new Button("Change Label Text");
        anchorPane.setBottomAnchor(button1, 30.0);
        anchorPane.setRightAnchor(button1, 30.0);
        anchorPane.getChildren().add(button1);
        button1.setOnAction(this);

        button2 = new Button("Laugh");
        anchorPane.setBottomAnchor(button2, 30.0);
        anchorPane.setLeftAnchor(button2, 30.0);
        anchorPane.getChildren().add(button2);
        button2.setOnAction(this);
    }

    public void handle(ActionEvent e) {
        if (e.getSource() == button1) {
            String enteredText = textField.getText(); // Get the text from the TextField
            label1.setText(enteredText);
        }
        if (e.getSource() == button2) {
            label2.setText("HEHEHEHAW!!");
        }
    }
}