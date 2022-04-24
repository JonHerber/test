package actions;

import clocks.GameClock;
import game.Music;
import gui.Gui;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Gui g = new Gui();
        GameClock gc = new GameClock();
        Music m = new Music();
        g.create();
        try {
            m.setFile(new File(".").getCanonicalPath().toString() + "\\music.wav");
            m.play();
            gc.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
