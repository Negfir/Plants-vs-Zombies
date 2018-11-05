/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZombiCharacters;

import PlantsCharacter.Plants;
import PlantsCharacter.SnowShooter;
import PlantsCharacter.SunFlower;
import finalgame.MyPanel;
import java.util.Vector;
import javax.swing.ImageIcon;


public class HatZ extends Zombies{
   
    public HatZ(int x, int y, int zombi_size,int speed){
         super(x,y,zombi_size,speed);
          zombiPic = new ImageIcon("BucketHeadZombie.png");
          life=6;
    }
    
}
