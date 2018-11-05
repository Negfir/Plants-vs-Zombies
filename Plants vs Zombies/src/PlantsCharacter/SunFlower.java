/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantsCharacter;

import Peas.Sun2;
import ZombiCharacters.Zombies;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class SunFlower extends Plants {

    Sun2 sun;
    private Vector<Sun2> suns;
    private int x2;
    private int y2;

    public SunFlower(int x, int y) {
        super(x, y);
        this.x2 = x;
        this.y2 = y;
        suns = new Vector<Sun2>();
        plantPic = new ImageIcon("sunFlower.png");

        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    setSun();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Zombies.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        thread.start();
        Thread thread2 = new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(8000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Zombies.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    removeSun();
                }
            }
        };
        thread2.start();
        
        

    }

    public void setSun() {
        sun = new Sun2(x2, y2);
        suns.add(sun);

    }

    public void removeSun() {
        sun.flag = false;
    }

    public Vector<Sun2> retSun() {
        return suns;
    }

}
