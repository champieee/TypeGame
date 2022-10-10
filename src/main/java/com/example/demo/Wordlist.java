package com.example.demo;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class Wordlist {
    String[] longerWordArray = new String[100];
    File file = new File("C:\\Users\\ayush\\eclipse-workspace\\TypeGame\\out\\artifacts\\TypeGame_jar\\sgb-words.txt");
    Scanner sc;


    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void copyArray() {
        for (int i = 0; i < 100; i++) {
            longerWordArray[i] = sc.nextLine();
        }
    }

    public int randomNum() {
        Random generator = new Random();
        return generator.nextInt(100);
    }

    public String ranWord() {
        String ranWord = longerWordArray[randomNum()];
        return ranWord;
    }


}
