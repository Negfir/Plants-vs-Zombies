/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalgame;

import PlantsCharacter.Plants;
import ZombiCharacters.Zombies;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ConcurrentModificationException;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements Runnable {

    Dimension screen;
    MyPanel panel;
    FirstLevel first;
    SecondLevel second;
    ThirdLevel third;
    ForthLevel forth;
    boolean flag1;
    boolean flag2;
    boolean flag3;
    boolean flag4;
    boolean flag5;

    public MyFrame() {

        flag1 = true;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        flag5 = false;

        //init()
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(160, 80);
        setResizable(false);
        setTitle("Plants_vs_zombies");

        first = new FirstLevel(screen, this);
        (new Thread(first)).start();
        this.getContentPane().add(first);
        setVisible(true);
//                
//                second = new SecondLevel( screen , this);
//		(new Thread(second)).start();
//		this.getContentPane().add(second);
//		setVisible(true);
//                
//                third = new ThirdLevel( screen , this);
//		(new Thread(third)).start();
//		this.getContentPane().add(third);
//		setVisible(true);
//                
//                forth = new ForthLevel( screen , this);
//		(new Thread(forth)).start();
//		this.getContentPane().add(forth);
//		setVisible(true);
//
// panel = new MyPanel(screen, this);
//        (new Thread(panel)).start();
//        this.getContentPane().add(panel);
//        setVisible(true);

    }

    /** 
     * the run method
     */
     
    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

            //1
            if (this.isAncestorOf(first)) {
                //System.out.println("kkk");
                try {
                    for (Zombies i : first.zombies) {
                        System.out.println("+");

                        if (!(i.isIs_Alive())) {
                            first.finish += 1;
                            System.out.println("+");

                        }
                    }
                    if (first.finish >= 15 && flag1) {
                        System.out.println("yes");

                        this.remove(first);
                        int finish = JOptionPane.showConfirmDialog(null,
                                "شما برنده شدید آیا ادامه می دهید؟", "شما بردید",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                        if (finish == 1) {
                            System.exit(0);
                        }

                        if (finish == 0) {
                            first.eog = false;
                            second = new SecondLevel(screen, this);
                            (new Thread(second)).start();

                            flag1 = false;
                            this.getContentPane().add(second);
                            flag2 = true;
                            setVisible(true);
                            for (Zombies i : first.zombies) {
                                i = null;
                            }
                            for (Plants i : first.plants) {
                                i = null;
                            }

                        }
                    } else {
                        first.finish = 0;
                    }

                    for (Zombies j : first.zombies) {

                        if (j.isIs_Alive()) {
                            if (j.getX() < 110 && first.lose) {
                                first.lose = false;
                                int fin = JOptionPane.showConfirmDialog(null,
                                        "Do you want to play again?", "PLAY AGAIN",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                                if (fin == 1) {
                                    System.exit(0);
                                }

                                if (fin == 0) {
                                    first.eog = false;
                                    for (Zombies i : first.zombies) {
                                        i = null;
                                    }
                                    for (Plants i : first.plants) {
                                        i = null;
                                    }

                                    this.remove(first);
                                    setVisible(false);
                                    first = new FirstLevel(screen, this);
                                    (new Thread(first)).start();
                                    this.getContentPane().add(first);
                                    setVisible(true);

                                }
                            }
                        }
                    }

                } catch (NullPointerException | ConcurrentModificationException e) {
                    System.out.println("er1");

                }
            } //2
            else if (this.isAncestorOf(second)) {
                try {

                    for (Zombies i : second.zombies) {
                        if (!(i.isIs_Alive())) {
                            second.finish += 1;

                        }
                    }
                    if (second.finish >= 20 && flag2) {
                        this.remove(second);
                        int finish = JOptionPane.showConfirmDialog(null,
                                "شما برنده شدید آیا ادامه می دهید؟", "شما بردید",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                        if (finish == 1) {
                            System.exit(0);
                        }

                        if (finish == 0) {
                            second.eog = false;

                            third = new ThirdLevel(screen, this);
                            (new Thread(third)).start();

                            flag2 = false;
                            this.getContentPane().add(third);
                            flag3 = true;
                            setVisible(true);
                            for (Zombies i : second.zombies) {
                                i = null;
                            }
                            for (Plants i : second.plants) {
                                i = null;
                            }
                        }
                    } else {
                        second.finish = 0;
                    }

                    for (Zombies j : second.zombies) {

                        if (j.isIs_Alive()) {
                            if (j.getX() < 110 && second.lose) {
                                second.lose = false;
                                int fin = JOptionPane.showConfirmDialog(null,
                                        "Do you want to play again?", "PLAY AGAIN",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                                if (fin == 1) {
                                    System.exit(0);
                                }

                                if (fin == 0) {
                                    second.eog = false;
                                    for (Zombies i : second.zombies) {
                                        i = null;
                                    }
                                    for (Plants i : second.plants) {
                                        i = null;
                                    }

                                    this.remove(second);
                                    setVisible(false);
                                    second = new SecondLevel(screen, this);
                                    (new Thread(second)).start();
                                    this.getContentPane().add(second);
                                    setVisible(true);

                                }
                            }
                        }
                    }

                } catch (NullPointerException | ConcurrentModificationException e) {
                    System.out.println("er1");
                }
            } //3
            else if (this.isAncestorOf(third)) {
                try {

                    for (Zombies i : third.zombies) {
                        if (!(i.isIs_Alive())) {
                            third.finish += 1;

                        }
                    }
                    if (third.finish >= 20 && flag3) {
                        this.remove(third);
                        int finish = JOptionPane.showConfirmDialog(null,
                                "شما برنده شدید آیا ادامه می دهید؟", "شما بردید",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                        if (finish == 1) {
                            System.exit(0);
                        }

                        if (finish == 0) {
                            third.eog = false;

                            forth = new ForthLevel(screen, this);
                            (new Thread(forth)).start();

                            flag3 = false;
                            this.getContentPane().add(forth);
                            flag4 = true;
                            setVisible(true);
                            for (Zombies i : third.zombies) {
                                i = null;
                            }
                            for (Plants i : third.plants) {
                                i = null;
                            }

                        }
                    } else {
                        third.finish = 0;
                    }

                    for (Zombies j : third.zombies) {

                        if (j.isIs_Alive()) {
                            if (j.getX() < 110 && third.lose) {
                                third.lose = false;
                                int fin = JOptionPane.showConfirmDialog(null,
                                        "شما باختید آیا میخواهید دوباره بازی کنید؟", "شما باختید",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                                if (fin == 1) {
                                    System.exit(0);
                                }

                                if (fin == 0) {
                                    third.eog = false;
                                    for (Zombies i : third.zombies) {
                                        i = null;
                                    }
                                    for (Plants i : third.plants) {
                                        i = null;
                                    }

                                    this.remove(third);
                                    setVisible(false);
                                    third = new ThirdLevel(screen, this);
                                    (new Thread(third)).start();
                                    this.getContentPane().add(third);
                                    setVisible(true);

                                }
                            }
                        }
                    }

                } catch (NullPointerException | ConcurrentModificationException e) {
                    System.out.println("er2");
                }
            }
            if (this.isAncestorOf(forth)) {
                //4
                try {

                    for (Zombies i : forth.zombies) {
                        if (!(i.isIs_Alive())) {
                            forth.finish += 1;

                        }
                    }
                    if (forth.finish >= 20 && flag4) {
                        this.remove(forth);
                        int finish = JOptionPane.showConfirmDialog(null,
                                "شما برنده شدید آیا ادامه می دهید؟", "شما بردید",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                        if (finish == 1) {
                            System.exit(0);
                        }

                        if (finish == 0) {
                            forth.eog = false;

                            panel = new MyPanel(screen, this);
                            (new Thread(panel)).start();

                            flag4 = false;
                            this.getContentPane().add(panel);
                            flag5 = true;
                            setVisible(true);
                            for (Zombies i : forth.zombies) {
                                        i = null;
                                    }
                                    for (Plants i : forth.plants) {
                                        i = null;
                                    }
                        }
                    } else {
                        forth.finish = 0;
                    }

                    for (Zombies j : forth.zombies) {

                        if (j.isIs_Alive()) {
                            if (j.getX() < 110 && forth.lose) {
                                forth.lose = false;
                                int fin = JOptionPane.showConfirmDialog(null,
                                        "شما باختید آیا میخواهید دوباره بازی کنید؟", "شما باختید",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                                if (fin == 1) {
                                    System.exit(0);
                                }

                                if (fin == 0) {
                                    forth.eog = false;
                                    for (Zombies i : forth.zombies) {
                                        i = null;
                                    }
                                    for (Plants i : forth.plants) {
                                        i = null;
                                    }

                                    this.remove(forth);
                                    setVisible(false);
                                    forth = new ForthLevel(screen, this);
                                    (new Thread(forth)).start();
                                    this.getContentPane().add(forth);
                                    setVisible(true);

                                }
                            }
                        }
                    }

                } catch (NullPointerException | ConcurrentModificationException e) {
                    System.out.println("er4");
                }
            } else if (this.isAncestorOf(panel)) {
                try {
                    for (Zombies j : panel.zombies) {

                        if (j.isIs_Alive()) {
                            if (j.getX() < 110 && panel.lose) {
                                panel.lose = false;
                                int fin = JOptionPane.showConfirmDialog(null,
                                        "شما باختید آیا میخواهید دوباره بازی کنید؟", "شما باختید",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                                if (fin == 1) {
                                    System.exit(0);
                                }

                                if (fin == 0) {
                                    for (Zombies i : panel.zombies) {
                                        i = null;
                                    }
                                    for (Plants i : panel.plants) {
                                        i = null;
                                    }

                                    this.remove(panel);
                                    setVisible(false);
                                    panel = new MyPanel(screen, this);
                                    (new Thread(panel)).start();
                                    this.getContentPane().add(panel);
                                    setVisible(true);

                                }
                            }
                        }
                    }

                } catch (ConcurrentModificationException | NullPointerException e) {
                    System.out.println("er5");
                }

            }
//        
//        else{
//                break;
//                }

        }

    }
}
