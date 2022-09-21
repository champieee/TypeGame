package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

        Player one = new Player();
        Rect rect = new Rect();
        Txt text = new Txt();
        Lbl lbl = new Lbl();
        TxtField txtField = new TxtField();
        lbl.setText("Score: ");


        x.getChildren().addAll(rect.cR(), text.cT(), lbl.cL(), txtField.cTF());
        x.setAlignment(lbl.cL(), Pos.TOP_CENTER);
        x.setAlignment(txtField.cTF(), Pos.BOTTOM_CENTER);
        Scene start = new Scene(x, 600, 600);

        Wordlist wordlist = new Wordlist();
        wordlist.copyArray();
        String ranWord = wordlist.ranWord();
        System.out.println(ranWord);

        final long[] startTime = new long[1];
        startTime[0] = System.currentTimeMillis();

        AtomicInteger score1 = new AtomicInteger();
        text.setText(wordlist.ranWord());
        txtField.cTF().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (txtField.getText().equals(text.getText())) {
                    score1.getAndIncrement();
                    System.out.println(score1.get());
                    lbl.setText("Score: " + score1);
                    text.setText(wordlist.ranWord());
                    txtField.clearText();
                }
              }
            });


        stage.setScene(start);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}