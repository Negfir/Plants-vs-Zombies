/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author applenegin
 */
public class Sun2 implements Runnable {
     private int y;
    private int x;
        private ImageIcon sunPic;
        public boolean flag=true;

    
    public Sun2(int x, int y){
        this.x=x;
        this.y=y;
         sunPic = new ImageIcon("sun.png");

        
    }

    
      /**
     *
     * @return x
     */
    
       public int getX(){
        return x;
    }
       
    /**
     *
     * @return y
     */
    public int getY(){
        return y;
    }
    
    public ImageIcon getImageIcon(){
        return sunPic;
    }
    
    /**
     * the run method
     */
    
     @Override
      public void run() {
       
       
            try {
                
                Thread.sleep(5000);
                flag=!(flag);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sun.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }
    
    
    
}
    

