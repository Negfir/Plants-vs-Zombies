/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peas;

import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Peas implements Runnable {

    private ImageIcon peaIcon;
    private int x;
    private int y;
    public boolean alive;
    private Rectangle peaRect;

    public Peas(int x, int y) {
        alive = true;
        peaIcon = new ImageIcon("ball.png");
        this.x = x;
        this.y = y;
        peaRect = new Rectangle(x, y, 40, 40);
    }

    /**
     *
     * @return retangle
     */
    public Rectangle getRectangle() {
        return peaRect;

    }

    /**
     *
     * @return image of pea
     */
    public ImageIcon getImageIcon() {
        return peaIcon;
    }

    /**
     *
     * @return x
     */
    public int getX() {
        return x;

    }

    /**
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * increase x of pea
     */
    public void setX() {
        x += 3;
    }

    /**
     * the run method
     */
    @Override
    public void run() {
        while (alive) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sun.class.getName()).log(Level.SEVERE, null, ex);
            }
            setX();
        }
    }
}
