package com.example.demo;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Txt extends Node {

    Text t = new Text();

    public Node cT() {
        t.setFont(Font.font("Abyssinia SIL", FontWeight.BOLD, FontPosture.REGULAR,20));
        t.setFill(Color.ANTIQUEWHITE);
        t.setStroke(Color.ANTIQUEWHITE);
        t.setStrokeWidth(0);
        return t;
    }

    public void setText(String input) {
        t.setText(input);
    }

    public String getText() {
        return t.getText();
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
