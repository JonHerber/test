package clocks;

import actions.Collision;
import game.Snake;

public class GameClock extends Thread {
    public static boolean running = true;

    public void run() {
        while (running) {
            try {
                sleep(200);
                Snake.move();
                Snake.waitToMove = false;
                Collision.collidePickUp();
                if (Collision.collideSelf()) {
                    Snake.tail.clear();
                    Snake.score = 0;
                }
                if (Collision.collideWall()) {
                    Snake.tail.clear();
                    Snake.head.setY(7);
                    Snake.head.setX(7);
                    Snake.score = 0;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
