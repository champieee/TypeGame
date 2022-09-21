package com.example.demo;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class TxtField {

    TextField textField = new TextField();

    public Node cTF() {
        return textField;
    }

    public String getText() {
        return textField.getText();
    }

    public void clearText() {
        textField.clear();
    }
}
