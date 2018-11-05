/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZombiCharacters;

import Peas.Ball;
import Peas.Peas;
import PlantsCharacter.Plants;
import PlantsCharacter.SnowShooter;
import PlantsCharacter.SunFlower;
import finalgame.MyPanel;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class ThrowZ extends Zombies{
    
       private Vector<Ball> balls = new Vector<Ball>();
       int counter=20;
   
    public ThrowZ(int x, int y, int zombi_size,int speed){
           super(x,y,zombi_size,speed);
          zombiPic = new ImageIcon("MZombies.png");
          
          
        
        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    setBall();
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
    
    public void setBall(){
        Ball ball = new Ball(getX()+40,getY()+10);
        
        balls.add(ball);
        (new Thread(ball)).start();
        counter-=1;
    }
    
    public Vector<Ball> retBall(){
        return balls;
    }
      

    @Override
    public void run() {

        while (is_Alive) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
          if (counter<=0){
            this.setX(speed);
          }

     
        }

    }

}    
   
    

