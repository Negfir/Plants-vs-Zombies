/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantsCharacter;

import Peas.Peas;
import Peas.Sun2;
import ZombiCharacters.Zombies;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *

 */
public class PeaShooter extends Plants{
    
   private Vector<Peas> peasvect = new Vector<Peas>();
    public PeaShooter(int x,int y){
        super(x,y);
        plantPic = new ImageIcon("PeaShooter.gif");
        
        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    setPeas();
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Zombies.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        thread.start();
        
    }
    
    public void setPeas(){
        Peas pea = new Peas(getX()+40,getY()+10);
        
        peasvect.add(pea);
        (new Thread(pea)).start();
    }
    
    public Vector<Peas> retPeas(){
        return peasvect;
    }
    
}
