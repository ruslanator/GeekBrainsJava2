package J2Homework1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel{

    long lastFrameTime;
    MainCircles gameController;

    GameCanvas(MainCircles gameController) {
        lastFrameTime = System.nanoTime();
        this.gameController = gameController;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        gameController.onDrawFrame(this, g, deltaTime);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }
}
