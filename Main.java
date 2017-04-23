package sample;

import javafx.application.Application;
import javafx.event.*;
import javafx.event.Event;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import java.awt.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        Scene scene = new Scene(grid, 600, 450);
        primaryStage.setScene(scene);

        final TextArea out = new TextArea("Fibbonachi: Enter a number between 2 and 100.");
        out.setEditable(false);
        out.setPrefWidth(600);
        out.setPrefHeight(400);
        grid.add(out, 0, 0);

        final TextField in = new TextField();
        in.setPrefWidth(600);
        grid.add(in, 0, 1);

        EventHandler handler = new EventHandler() {
            @Override
            public void handle(Event event) {
                String s = new String(in.getText());
                in.setText("");

                try{
                    int i = Integer.parseInt(s);
                    int answer = 0;
                    if ( i > 1 && i < 101){
                        for(int x = 0;x <= i; x++){
                            answer += x;
                        }
                        out.setText("The answer is " + Integer.toString(answer) + ", my guy.");
                    }else{out.setText("Bad number, dude.");}

                } catch(Exception E){
                    out.setText("Invalid input, pal.");
                }//end catch
            }//end event
        };//end event handler

        in.setOnAction(handler);

        primaryStage.show();
    }//end class


    public static void main(String[] args) {
        launch(args);
    }
}
