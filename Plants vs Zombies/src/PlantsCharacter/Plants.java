/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantsCharacter;

import javax.swing.ImageIcon;

public class Plants {

    ImageIcon plantPic;

    protected int x;
    protected int y;
    public boolean is_Alive = true;
    private int life = 4;

    /**
     *
     * @param x
     * @param y
     */
    public Plants(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * decrease the life
     */
    public void setLife() {
        life -= 1;
    }

    /**
     *
     * @return life
     */
    public int getLife() {
        return life;
    }

    /**
     *
     * @return status of plant
     */
    public boolean isIs_Alive() {
        return is_Alive;
    }

    /**
     *
     * @param gets status of plant
     */
    public void setAlive(boolean x) {
        is_Alive = x;
    }

    /**
     *
     * @return image of plant
     */
    public ImageIcon getImageIcon() {
        return plantPic;

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

}
