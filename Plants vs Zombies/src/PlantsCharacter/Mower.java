/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantsCharacter;


import javax.swing.ImageIcon;

public class Mower extends Thread{

    protected ImageIcon MowerPic;
    private int x;
    private int y;
    public boolean is_Alive=false;
    public boolean b=true;

    public Mower(int x, int y) {

        this.x = x;
        this.y = y;
        is_Alive = true;
        MowerPic = new ImageIcon("Lawn_Mower.png");
       
    }
   
    
/**
 * 
 * @return image of mower
 */
    public ImageIcon getImageIcon() {
        return MowerPic;

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
     * @param x increse x 
     */
    
    public void setX(int x) {
        this.x += x;
    }
    
  
    
    
    
  /**
   * 
   * @param x is status of mower
   */

    public void setAlive(boolean x) {
        is_Alive = x;
    }
/**
 * 
 * @return status of mower
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
               
                Thread.sleep(100);
                 
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            this.setX(4);
            }
           

        }

    }
