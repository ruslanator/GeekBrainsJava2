package J2Homework1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private Background background;
    Sprite[] sprites = new Sprite[10];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                float x = getX();
                float y = getY();
                // добаление спрайтов по нажатию ПКМ
                if (e.getButton() == 3) {
                    Sprite[] shortArray = new Sprite[sprites.length - 1];
                    System.arraycopy(sprites, 0, shortArray, 0, sprites.length - 1);
                    sprites = shortArray;
                }
                // добаление спрайтов по нажатию ЛКМ
                if (e.getButton() == 1) {
                    Sprite[] longArray = new Sprite[sprites.length + 1];
                    System.arraycopy(sprites, 0, longArray, 0, sprites.length);
                    sprites = longArray;
                    sprites[sprites.length - 1] = new Ball();
                }
            }
        });
        initApplication();
        add(canvas);
        setResizable(false);
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
        background = new Background();
    }

    void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
        background.update(canvas, deltaTime);
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
        background.render(canvas, g);
    }

}
