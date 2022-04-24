package game;

import gui.Gui;

import java.awt.*;
import java.util.ArrayList;

public class Snake {

    public static int score = 0, highscore = 0;
    public static boolean waitToMove = false;

    public static Head head = new Head(7, 7);
    public static ArrayList<Tail> tail = new ArrayList<>();

    public static PickUp pickUp = new PickUp();

    public static void addTail() {
        if (tail.size() < 1)
            tail.add(new Tail(head.getX(), head.getY()));
        else
            tail.add(new Tail(tail.get(tail.size() - 1).getX(), tail.get(tail.size() - 1).getY()));

    }

    public static void move() {
        //Move tails
        if (tail.size() >= 2) {
            for (int i = tail.size() - 1; i >= 1; i--) {
                if (tail.get(i).isWait()) {
                    tail.get(i).setWait(false);
                } else {
                    tail.get(i).setX(tail.get(i - 1).getX());
                    tail.get(i).setY(tail.get(i - 1).getY());
                }
            }
        }

        //Move first Tail to Head
        if (tail.size() >= 1) {
            if (tail.get(0).isWait()) {
                tail.get(0).setWait(false);
            } else {
                tail.get(0).setX(head.getX());
                tail.get(0).setY(head.getY());
            }
        }

        //Move head
        switch (head.getDir()) {
            case RIGHT -> head.setX(head.getX() + 1);
            case LEFT -> head.setX(head.getX() - 1);
            case UP -> head.setY(head.getY() - 1);
            case DOWN -> head.setY(head.getY() + 1);
        }
    }

    //Position to coordinates
    public static Point ptc(int x, int y) {
        Point p = new Point(0, 0);
        p.x = x * 32 + Gui.xoff;
        p.y = y * 32 + Gui.yoff;

        return p;
    }
}
