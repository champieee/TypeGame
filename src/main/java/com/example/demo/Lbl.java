package com.example.demo;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Lbl extends Node {

    Label lbl = new Label();

    public Node cL() {
        lbl.setFont(new Font("Abyssinia SIL", 30));
        return lbl;
    }

    public void setText(String input) {
        lbl.setText(input);
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
