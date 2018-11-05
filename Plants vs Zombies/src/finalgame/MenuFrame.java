/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalgame;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MenuFrame extends JFrame{
     Dimension screen;
    public MenuFrame(){
        screen = Toolkit.getDefaultToolkit().getScreenSize();
         setSize(800, 610);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(160, 80);
        setResizable(false);
        setTitle("Plants_vs_zombies");
         MenuPanel menu = new MenuPanel(screen,this);
         this.getContentPane().add(menu);
        setVisible(true);
        


try{
Image image = new ImageIcon("plantsVsZombies.png").getImage();
this.setIconImage(image);
}catch(Exception e){
System.out.println("Appilcation icon not found");
}

    }  
}