package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {

    ArrayList<Integer> scoreList = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Project");

        Audio ding = new Audio();

        StackPane menu = new StackPane();
        Circle cen = new Circle(100, 100, 100, Color.CORNFLOWERBLUE);
        Text title = new Text("Type Thing");
        title.setFont(Font.font("Abyssinia SIL", FontWeight.BOLD, FontPosture.REGULAR,20));
        title.setFill(Color.ANTIQUEWHITE);
        Button firOpt = new Button();
        firOpt.setText("Single Player");
        Button secOpt = new Button();
        secOpt.setText("Multi-Player");
        Button scorOpt = new Button();
        scorOpt.setText("Highest Score");
        Button qOpt = new Button();
        qOpt.setText("Game Rules");

        menu.getChildren().addAll(cen, title, firOpt, secOpt, scorOpt, qOpt);
        StackPane.setAlignment(firOpt, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(secOpt, Pos.TOP_LEFT);
        StackPane.setAlignment(scorOpt, Pos.TOP_RIGHT);
        StackPane.setAlignment(qOpt, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(firOpt, new Insets(100, 100, 100,100));
        StackPane.setMargin(secOpt, new Insets(100, 100, 100,100));
        StackPane.setMargin(scorOpt, new Insets(100, 100, 100,100));
        StackPane.setMargin(qOpt, new Insets(100, 100, 100,100));

        Scene menuSc = new Scene(menu, 600, 400);

        StackPane rulePane = new StackPane();
        Text rules = new Text();
        rules.setFont(Font.font("Abyssinia SIL", FontWeight.BOLD, FontPosture.REGULAR,16));
        rules.setText("""
                1. Type the word exactly how you see it in the box to get a point\s

                2. The time it takes for you to get 10 points will be your score\s

                3. The multi-player button will face 2 people against each other\s
                \s
                4. The single-player button will time how fast it takes you to reach 10 points""");

        Button rret = new Button("Return to Menu");
        rulePane.getChildren().addAll(rules, rret);
        StackPane.setAlignment(rules, Pos.TOP_CENTER);
        StackPane.setAlignment(rret, Pos.CENTER);
        StackPane.setMargin(rules, new Insets(20,10,10,10));
        Scene ruleSc = new Scene(rulePane, 600, 600);

        StackPane x = new StackPane();
        StackPane x2 = new StackPane();
        StackPane x3 = new StackPane();
        StackPane x4 = new StackPane();

        Player one = new Player();
        Rect rect = new Rect();
        Txt text = new Txt();
        Lbl lbl = new Lbl();
        TxtField txtField = new TxtField();
        lbl.setText("Score: ");

        Player two = new Player();
        Rect rect2 = new Rect();
        Txt text2 = new Txt();
        Lbl lbl2 = new Lbl();
        TxtField txtField2 = new TxtField();

        Player single = new Player();
        Rect rect3 = new Rect();
        Txt text3 = new Txt();
        Lbl lbl3 = new Lbl();
        TxtField txtField3 = new TxtField();

        Button b = new Button("Start Game");
        StackPane starti = new StackPane();
        starti.getChildren().addAll(b);
        StackPane.setAlignment(b, Pos.CENTER);
        Scene startScene = new Scene(starti, 600, 600);

        Button b1 = new Button("Player 2's turn");
        StackPane starti1 = new StackPane();
        starti1.getChildren().addAll(b1);
        StackPane.setAlignment(b1, Pos.CENTER);
        Scene secondScene = new Scene(starti1, 600, 600);

        x.getChildren().addAll(rect.cR(), text.cT(), lbl.cL(), txtField.cTF());
        StackPane.setAlignment(lbl.cL(), Pos.TOP_CENTER);
        StackPane.setAlignment(txtField.cTF(), Pos.BOTTOM_CENTER);
        StackPane.setMargin(txtField.cTF(), new Insets(100,100,100,100));
        StackPane.setMargin(lbl.cL(), new Insets(100,100,100,100));
        Scene start = new Scene(x, 600, 600);

        x2.getChildren().addAll(rect2.cR(), text2.cT(), lbl2.cL(), txtField2.cTF());
        StackPane.setAlignment(lbl2.cL(), Pos.TOP_CENTER);
        StackPane.setAlignment(txtField2.cTF(), Pos.BOTTOM_CENTER);
        StackPane.setMargin(txtField2.cTF(), new Insets(100,100,100,100));
        StackPane.setMargin(lbl2.cL(), new Insets(100,100,100,100));
        Scene secondPlayer = new Scene(x2, 600, 600);

        x3.getChildren().addAll(rect3.cR(), text3.cT(), lbl3.cL(), txtField3.cTF());
        StackPane.setAlignment(lbl3.cL(), Pos.TOP_CENTER);
        StackPane.setAlignment(txtField3.cTF(), Pos.BOTTOM_CENTER);
        StackPane.setMargin(txtField3.cTF(), new Insets(100,100,100,100));
        StackPane.setMargin(lbl3.cL(), new Insets(100,100,100,100));
        Scene singlePlayer = new Scene(x3, 600, 600);

        Lbl hSC = new Lbl();
        Button scorRet = new Button("Return to Menu");
        x4.getChildren().addAll(hSC.cL(), scorRet);
        StackPane.setAlignment(hSC.cL(), Pos.CENTER);
        StackPane.setAlignment(scorRet, Pos.BOTTOM_CENTER);
        StackPane.setMargin(scorRet, new Insets(100,100,100,100));
        Scene hScene = new Scene(x4, 600, 600);

        Lbl winner = new Lbl();
        Button retur = new Button("Return to Menu");
        StackPane winS = new StackPane();
        winS.getChildren().addAll(winner.cL(), retur);
        StackPane.setAlignment(winner.cL(), Pos.CENTER);
        StackPane.setAlignment(retur, Pos.BOTTOM_CENTER);
        StackPane.setMargin(retur, new Insets(100,100,100,100));
        Scene resultScreen = new Scene(winS, 600, 600);

        Lbl time = new Lbl();
        Button retur1 = new Button("Return to Menu");
        StackPane tS = new StackPane();
        tS.getChildren().addAll(time.cL(), retur1);
        StackPane.setAlignment(time.cL(), Pos.CENTER);
        StackPane.setAlignment(retur1, Pos.BOTTOM_CENTER);
        StackPane.setMargin(retur1, new Insets(100,100,100,100));
        Scene timeSc = new Scene(tS, 600, 600);

        Wordlist wordlist = new Wordlist();
        wordlist.copyArray();
        String ranWord = wordlist.ranWord();
        System.out.println(ranWord);

        final long[] startTime = new long[2];

        AtomicInteger score = new AtomicInteger();
        text.setText(wordlist.ranWord());
        lbl.setText("Score: 0");
        txtField.cTF().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (txtField.getText().equals(text.getText())) {
                    ding.playMedia();
                    score.getAndIncrement();
                   // System.out.println(score.get());
                    lbl.setText("Score: " + score);
                    text.setText(wordlist.ranWord());
                    txtField.clearText();
                }
                if (score.get() == 10) {
                    System.out.println("Reached ten");
                    long endTime = System.currentTimeMillis();
                    long totalTime = (endTime - startTime[0]);
                    one.setScore((int)(totalTime/1000));
                    scoreList.add((int)(totalTime/1000));
                    System.out.println(one.getScore());
                    score.set(0);
                    stage.setScene(secondScene);
                    stage.show();
                }
            }
        });

        lbl.setText("Score: 0");
        text2.setText(wordlist.ranWord());
        txtField2.cTF().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (txtField2.getText().equals(text2.getText())) {
                    ding.playMedia();
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
                    scoreList.add((int)(totalTime/1000));
                    System.out.println(two.getScore());
                    winner.setText(one.returnWinner(one.getScore(), two.getScore()));
                    stage.setScene(resultScreen);
                    stage.show();
                }
            }
        });

        lbl.setText("Score: 0");
        text3.setText(wordlist.ranWord());
        txtField3.cTF().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (txtField3.getText().equals(text3.getText())) {
                    ding.playMedia();
                    score.getAndIncrement();
                    System.out.println(score.get());
                    lbl3.setText("Score: " + score);
                    text3.setText(wordlist.ranWord());
                    txtField3.clearText();
                }
                if (score.get() == 10) {
                    System.out.println("Reached ten");
                    long endTime = System.currentTimeMillis();
                    long totalTime = (endTime - startTime[1]);
                    single.setScore((int)(totalTime/1000));
                    scoreList.add((int)(totalTime/1000));
                    time.setText(single.getScore() + " seconds");
                    stage.setScene(timeSc);
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

        secOpt.setOnAction(actionEvent -> stage.setScene(startScene));

        firOpt.setOnAction(actionEvent ->  {
            startTime[1] = System.currentTimeMillis();
            stage.setScene(singlePlayer);
        });

        scorOpt.setOnAction(actionEvent -> {
            hSC.setText("" + highestScore() + " seconds");
            stage.setScene(hScene);
        });

        qOpt.setOnAction(actionEvent -> stage.setScene(ruleSc));

        retur.setOnAction(actionEvent -> {
            stage.setScene(menuSc);
            score.set(0);
        });

        retur1.setOnAction(actionEvent -> {
            stage.setScene(menuSc);
            score.set(0);
        });

        scorRet.setOnAction(actionEvent -> {
            stage.setScene(menuSc);
            score.set(0);
        });

        rret.setOnAction(actionEvent -> {
            stage.setScene(menuSc);
            score.set(0);
        });


        stage.setScene(menuSc);
        stage.show();
    }

    public int highestScore() {
        Collections.sort(scoreList);
        return scoreList.get(0);
    }


    public static void main(String[] args) {
        launch();
    }
}