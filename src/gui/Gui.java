package gui;

import actions.KeyHandler;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;

public class Gui {
    JFrame jf;
    Draw d;

    static int width = 800;
    static int height = 600;
    public static int xoff = 130, yoff = 20;

    public void create() {
        jf = new JFrame("Snake");
        jf.setSize(width, height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.addKeyListener(new KeyHandler());

        d = new Draw();
        d.setBounds(0, 0, width, height);
        d.setVisible(true);
        jf.add(d);

        jf.requestFocus();
        jf.setVisible(true);
    }

}
