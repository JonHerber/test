package game;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.*;


public class Music {
    Clip clip;

    /* public Music() {
        setFile(System.getProperty("user.dir"));
     }
    */

    public void setFile(String soundFileName) {

        try {
            File file = new File(soundFileName);
            AudioInputStream music = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(music);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
        clip.close();
    }

}

