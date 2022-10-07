package com.example.demo;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class Audio {

    public void playMedia() {
        String mp3 = "BVQNLMC-ding.mp3";
        URL resource = getClass().getResource(mp3);
        assert resource != null;
        Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
