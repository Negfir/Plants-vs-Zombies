/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZombiCharacters;

import PlantsCharacter.Plants;
import finalgame.MyPanel;
import java.awt.Rectangle;
import java.util.Vector;
import javax.swing.ImageIcon;


public class Zombies implements Runnable {

    protected ImageIcon zombiPic;
    private int x;
    private int y;
    public boolean is_Alive;
    private Rectangle zombi_Rect;
    public int zombi_size;
    protected int speed;
    protected int life=4;
    MyPanel parent;
    Vector<Plants> plants;
    
    
    public Zombies(int x, int y, int zombi_size, int speed) {

        this.parent = parent;
        this.x = x;
        this.y = y;
        is_Alive = true;
        this.zombi_size = zombi_size;
        this.speed = speed;
        zombi_Rect = new Rectangle(x, y, zombi_size, zombi_size);

    }

    
    /**
     * 
     * @return rectangle
     */
    public Rectangle getRectangle() {
        return zombi_Rect;

    }

    /**
     * 
     * @return image of zombies
     */
    public ImageIcon getImageIcon() {
        return zombiPic;

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
     * 
     * @param x increase x
     */
    public void setX(int x) {
        this.x -= x;
    }
    
    /**
     * 
     * @param x determine the speed
     */
     public void setSpeed(int x) {
        speed = x;
    }
    
     /**
      * decreases life
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
        * @param x is statuse of zombie
        */
    public void setAlive(boolean x) {
        is_Alive = x;
    }

    /**
     * 
     * @return statuse of zombie
     */
    public boolean isIs_Alive() {
        return is_Alive;
    }

    /**
     * the run method
     */
    @Override
    public void run() {

        while (is_Alive) {
            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            this.setX(speed);
            zombi_Rect.x = this.x;

//            for (Plants i : plants) {
//                if (i instanceof PeaShooter) {
//                    for (Peas j : ((PeaShooter) i).retPeas()) {
//                        if (j.alive == true) {
////                                if (j.getRectangle().intersects(zombi_Rect)) 
//                            if (this.x - 50 < j.getX() && j.getX() < this.x + 50 && this.y - 50 < j.getY() && j.getY() < this.y + 50) {
//
//                                setAlive(false);
//
//                            }
//                        }
//
//                    }
//
//                }
//            }
           // parent.repaint();
        }

    }

}
