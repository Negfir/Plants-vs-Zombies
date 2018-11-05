/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peas;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import finalgame.MyPanel;
import java.applet.Applet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author fatemeh saligheh
 */
public class Sun implements Runnable{
    private ImageIcon sunPic;
    private int y=0;
    private int x;
    Random rand = new Random();
    public boolean flag;
    private int n = rand.nextInt(400)+100;
    
    public Sun(){
        sunPic = new ImageIcon("sun.png");
        int num = rand.nextInt(9) + 1;
        if(num==1){
           x=260; 
        }else if(num==2){
           x=340; 
        }else if(num==3){
           x=420; 
        }else if(num==4){
           x=500; 
        }else if(num==5){
           x=580; 
        }else if(num==6){
           x=660; 
        }else if(num==7){
           x=740; 
        }else if(num==8){
           x=820;
        }else if(num==9){
           x=900; 
        }
        flag=true;
        
        
    }
 

/**
     *
     * @return image of sun
     */
    public ImageIcon getImageIcon(){
        return sunPic;
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
    
     /**
     * increase y of sun
     */
    public void setY(){
        y+=3;
    }
    
    /**
     * the run method
     */
    @Override
    public void run() {
       
        while(flag){
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sun.class.getName()).log(Level.SEVERE, null, ex);
            }
            setY();
        }
    }
    
    

   
    
}
