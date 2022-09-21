package com.example.demo;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rect extends Node {

    public int x, y;

    public Node cR() {
        Rectangle rect = new Rectangle (100, 40, 100, 100);
        rect.setArcHeight(50);
        rect.setArcWidth(50);
        rect.setFill(Color.CORNFLOWERBLUE);
        return rect;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
