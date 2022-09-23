package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Thingy");

        StackPane x = new StackPane();
        StackPane x2 = new StackPane();

        Player one = new Player();
        Rect rect = new Rect();
        Txt text = new Txt();
        Lbl lbl = new Lbl();
        TxtField txtField = new TxtField();
        lbl.setText("Score: ");


        x.getChildren().addAll(rect.cR(), text.cT(), lbl.cL(), txtField.cTF());
        x.setAlignment(lbl.cL(), Pos.TOP_CENTER);
        x.setAlignment(txtField.cTF(), Pos.BOTTOM_CENTER);
        StackPane.setMargin(txtField.cTF(), new Insets(100,100,100,100));
        StackPane.setMargin(lbl.cL(), new Insets(100,100,100,100));
        Scene start = new Scene(x, 600, 600);



        Player two = new Player();
        Rect rect2 = new Rect();
        Txt text2 = new Txt();
        Lbl lbl2 = new Lbl();
        TxtField txtField2 = new TxtField();

        Button b = new Button("Start Game");
        StackPane starti = new StackPane();
        starti.getChildren().addAll(b);
        starti.setAlignment(b, Pos.CENTER);
        Scene startScene = new Scene(starti, 600, 600);


        Button b1 = new Button("Player 2's turn");
        StackPane starti1 = new StackPane();
        starti1.getChildren().addAll(b1);
        starti1.setAlignment(b1, Pos.CENTER);
        Scene secondScene = new Scene(starti1, 600, 600);

        Lbl winner = new Lbl();
        StackPane winS = new StackPane();
        winS.getChildren().addAll(winner.cL());
        winS.setAlignment(winner.cL(), Pos.CENTER);
        Scene resultScreen = new Scene(winS, 600, 600);

        x2.getChildren().addAll(rect2.cR(), text2.cT(), lbl2.cL(), txtField2.cTF());
        x2.setAlignment(lbl2.cL(), Pos.TOP_CENTER);
        x2.setAlignment(txtField2.cTF(), Pos.BOTTOM_CENTER);
        StackPane.setMargin(txtField2.cTF(), new Insets(100,100,100,100));
        StackPane.setMargin(lbl2.cL(), new Insets(100,100,100,100));
        Scene secondPlayer = new Scene(x2, 600, 600);

        Wordlist wordlist = new Wordlist();
        wordlist.copyArray();
        String ranWord = wordlist.ranWord();
        System.out.println(ranWord);

        final long[] startTime = new long[2];

        AtomicInteger score = new AtomicInteger();
        text.setText(wordlist.ranWord());
        txtField.cTF().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (txtField.getText().equals(text.getText())) {
                    score.getAndIncrement();
                    System.out.println(score.get());
                    lbl.setText("Score: " + score);
                    text.setText(wordlist.ranWord());
                    txtField.clearText();
                }
                if (score.get() == 10) {
                    System.out.println("Reached ten");
                    long endTime = System.currentTimeMillis();
                    long totalTime = (endTime - startTime[0]);
                    one.setScore((int)(totalTime/1000));
                    System.out.println(one.getScore());
                    score.set(0);
                    stage.setScene(secondScene);
                    stage.show();
                }
            }
        });

        text2.setText(wordlist.ranWord());
        txtField2.cTF().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (txtField2.getText().equals(text2.getText())) {
                    score.getAndIncrement();
                    System.out.println(score.get());
                    lbl2.setText("Score: " + score);
                    text2.setText(wordlist.ranWord());
                    txtField2.clearText();
                }
                if (score.get() == 10) {
                    System.out.println("Reached ten");
                    long endTime = System.currentTimeMillis();
                    long totalTime = (endTime - startTime[1]);
                    two.setScore((int)(totalTime/1000));
                    System.out.println(two.getScore());
                    winner.setText(one.returnWinner(one.getScore(), two.getScore()));
                    stage.setScene(resultScreen);
                    stage.show();
                }
            }
        });

        b.setOnAction(actionEvent -> {
            startTime[0] = System.currentTimeMillis();
            stage.setScene(start);
        });

        b1.setOnAction(actionEvent -> {
            startTime[1] = System.currentTimeMillis();
            stage.setScene(secondPlayer);
        });



        stage.setScene(startScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}