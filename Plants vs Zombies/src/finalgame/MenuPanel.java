/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalgame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MenuPanel extends JPanel{
    private ImageIcon backGround ;
    private JLabel label= new JLabel();
    JButton  startButton = new JButton();
    ImageIcon start = new ImageIcon("start.jpg");
    ImageIcon volume = new ImageIcon("volume.jpg");
    JButton volumeButton = new JButton();
    public MenuPanel(Dimension screen, MenuFrame frame){
         backGround = new ImageIcon("0.jpg");
        label.setIcon(backGround);
         setLayout(null);
        setLocation((int) screen.getWidth() / 2, (int) screen.getHeight() / 2);
        label.setBounds(0, 0, 800, 599);
        startButton.setIcon(start);
        volumeButton.setIcon(volume);
//        startButton.setBounds(0,400,200,200);
//        volumeButton.setBounds(790,400,200,200);
//        add(volumeButton);
//        add(startButton);
       add(label);
//        
//        buttonHandler handler = new buttonHandler();
//        startButton.addActionListener(handler);
//        volumeButton.addActionListener(handler);
        this.addMouseListener(new StartHandler());
    }
    
    public class buttonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==startButton){
                MyFrame f = new MyFrame();
                (new Thread(f)).start();
            }else if(e.getSource()==volumeButton){
                
            }
            

        }
        
    }
    
     public class StartHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            //System.out.println(e.getX()+","+e.getY());  

            if (248<e.getX()&& e.getX()<548 && 528<e.getY()&& e.getY()<575){
                MyFrame f = new MyFrame();
                (new Thread(f)).start(); 
ImageIcon img = new ImageIcon("p1.png");
f.setIconImage(img.getImage());

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
         
     }
   
    
}