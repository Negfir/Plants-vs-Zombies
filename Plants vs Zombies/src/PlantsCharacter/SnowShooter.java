/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantsCharacter;

import Peas.Peas;
import Peas.SnowPeas;
import Peas.Sun2;
import ZombiCharacters.Zombies;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
this class for snow peas
*/


public class SnowShooter extends Plants{
    
   private Vector<SnowPeas> peasvect = new Vector<SnowPeas>();
    public SnowShooter(int x,int y){
        super(x,y);
        plantPic = new ImageIcon("SnowPea.gif");
        
        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    setPeas();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Zombies.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        thread.start();
        
    }
    
    public void setPeas(){
        SnowPeas pea = new SnowPeas(getX()+40,getY());
        
        peasvect.add(pea);
        (new Thread(pea)).start();
    }
    
    public Vector<SnowPeas> retPeas(){
        return peasvect;
    }
    
}

