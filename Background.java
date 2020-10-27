package J2Homework1;

import java.awt.*;


public class Background extends Sprite {
    private int R;
    private int G;
    private int B;
    private float changeR;
    private float changeG;
    private float changeB;

    Background() {
        // R - red; G - green; B - blue
        R = 255;
        G = 100;
        B = 255;
        // скорость смены цвета
        changeR = 1;
        changeB = 1;
        changeG = 1;
    }

    void update(GameCanvas canvas, float deltaTime) {

        //измнение цвета со временем
        R += changeR;
        G += changeG;
        B += changeB;
        if (R < 0) {
            R = 0;
            changeR = -changeR;
        }
        if (R > 255) {
            R = 255;
            changeR = -changeR;
        }
        if (G < 0) {
            G = 0;
            changeG = -changeG;
        }
        if (G > 255) {
            G = 255;
            changeG = -changeG;
        }
        if (B < 0) {
            B = 0;
            changeB = -changeB;
        }
        if (B > 255) {
            B = 255;
            changeB = -changeB;
        }
    }

    void render(GameCanvas canvas, Graphics g) {
        canvas.setBackground(new Color(R, G, B));
    }
}
