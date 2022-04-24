package gui;

import game.Snake;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    Point p;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, Gui.width, Gui.height);

        //Draw snake tail
        g.setColor(new Color(10, 102, 42));
        for (int i = 0; i < Snake.tail.size(); i++) {
            p = Snake.ptc(Snake.tail.get(i).getX(), Snake.tail.get(i).getY());
            g.fillRect(p.x, p.y, 32, 32);
        }

        //Draw snake head
        g.setColor(new Color(194, 2, 36));
        p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
        g.fillRect(p.x, p.y, 32, 32);

        //Draw pickup
        g.setColor(Color.ORANGE);
        p = Snake.ptc(Snake.pickUp.getX(), Snake.pickUp.getY());
        g.fillRect(p.x, p.y, 32, 32);

        //Draw Grid
        g.setColor(Color.GRAY);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                g.drawRect(i * 32 + Gui.xoff, j * 32 + Gui.yoff, 32, 32);
            }

        }

        //Draw border
        g.setColor(Color.BLACK);
        g.drawRect(Gui.xoff, Gui.yoff, 512, 512);

        //Draw score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + Snake.score, 5, 25);
        g.drawString("Highscore: " + Snake.highscore, 655, 25);

        repaint();
    }
}
