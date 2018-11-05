/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalgame;

import Peas.Ball;
import Peas.Peas;
import Peas.SnowPeas;
import Peas.Sun;
import Peas.Sun2;
import PlantsCharacter.CherryBomb;
import PlantsCharacter.Mower;
import PlantsCharacter.PeaShooter;
import PlantsCharacter.Plants;
import PlantsCharacter.SnowShooter;
import PlantsCharacter.SunFlower;
import PlantsCharacter.WallNut;
import ZombiCharacters.AthleteZ;
import ZombiCharacters.HatZ;
import ZombiCharacters.ThrowZ;
import ZombiCharacters.TypicalZ;
import ZombiCharacters.Zombies;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import javax.swing.Timer;

/**
 * second level of the game
 *
 * @author negin
 */
public class SecondLevel extends JPanel implements Runnable {

    public Vector<Zombies> zombies;
    public Vector<Plants> plants;
    private Vector<Peas> peas;
    private Vector<Sun> suns;
    private Vector<Mower> mowers;
    private int sunScore = 0;
    private int grow = 0;
    public int finish;
    public boolean lose = true;

    private Dimension screen;
    private ImageIcon backGround;

    private MyFrame frame;
    boolean flag = true;
    JLabel label = new JLabel();
    Icon icon1 = new ImageIcon("b1.png");
    JButton sunButton = new JButton();
    Icon icon2 = new ImageIcon("b2.png");
    JButton peaShooterButton = new JButton();
    Icon icon5 = new ImageIcon("b5.png");
    JButton snowPeaButton = new JButton();
    Icon icon4 = new ImageIcon("b4.png");
    JButton wallNuttButton = new JButton();
    Icon icon3 = new ImageIcon("b3.png");
    JButton cherryButton = new JButton();
    Icon shovelIcon = new ImageIcon("download.png");
    JButton shovelButton = new JButton();
    Icon score = new ImageIcon("score.PNG");
    JLabel scoreLabel = new JLabel(score);
    Random rand = new Random();
    Sun sun;
    private int plantType = 0;

    private Rectangle[][] rectangles = new Rectangle[9][5];
    public boolean eog = true;
    private int i;
    private int j;
    ExecutorService service;

    public SecondLevel(Dimension screen, MyFrame frame) {
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        this.frame = frame;
        this.screen = screen;
        backGround = new ImageIcon("background.png");
        label.setIcon(backGround);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                Rectangle r = new Rectangle(80 * (i + 1) + 180, 100 * (j) + 50, 80, 100);
                rectangles[i][j] = r;
            }
        }
        finish = 0;

        zombies = new Vector<Zombies>();
        plants = new Vector<Plants>();
        mowers = new Vector<Mower>();
        peaShooterButton.setIcon(icon2);
        sunButton.setIcon(icon1);
        cherryButton.setIcon(icon3);
        wallNuttButton.setIcon(icon4);
        snowPeaButton.setIcon(icon5);
        shovelButton.setIcon(shovelIcon);
        setLayout(null);
        setLocation((int) screen.getWidth() / 2, (int) screen.getHeight() / 2);
        label.setBounds(0, 0, 1000, 600);
        peaShooterButton.setBounds(0, 140, 65, 88);
        sunButton.setBounds(0, 50, 65, 88);
        wallNuttButton.setBounds(0, 230, 65, 88);
        snowPeaButton.setBounds(0, 410, 65, 88);
        scoreLabel.setBounds(0, 0, 150, 50);
        shovelButton.setBounds(150, 0, 60, 60);
        add(shovelButton);
        add(peaShooterButton);
        add(sunButton);
        add(wallNuttButton);
        add(scoreLabel);
        add(label);
        Mower mower1 = new Mower(140, 50);
        Mower mower2 = new Mower(140, 150);
        Mower mower3 = new Mower(140, 250);
        Mower mower4 = new Mower(140, 350);
        Mower mower5 = new Mower(140, 450);
        mowers.add(mower1);
        mowers.add(mower2);
        mowers.add(mower3);
        mowers.add(mower4);
        mowers.add(mower5);
        Thread thread3 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Zombies.class.getName()).log(Level.SEVERE, null, ex);
                }
                Thread thread1 = new Thread() {
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            setzombies2();
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Zombies.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                        Thread thread4 = new Thread() {
                            public void run() {
                                while (true) {
                                    setZombies();
                                    try {
                                        Thread.sleep(8000);
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Zombies.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        };
                        thread4.start();
                    }
                };
                thread1.start();
            }

        };
        thread3.start();

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    setSun();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Zombies.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        thread2.start();
        this.addMouseListener(new SunClickhandler());
        this.addMouseListener(new GrowHandler());

        ButtonHandler handler = new ButtonHandler();
        sunButton.addActionListener(handler);
        peaShooterButton.addActionListener(handler);
        wallNuttButton.addActionListener(handler);
        shovelButton.addActionListener(handler);
    }

    /**
     * sun score
     *
     * @return
     */
    public int getScore() {
        return sunScore;
    }

    /**
     * 
     * @param a is score
     */
    public void setScore(int a) {
        sunScore = a;
    }

     /**
     * sets zombies
     */
    public void setZombies() {
        int row = rand.nextInt(5) + 1;
        int num = rand.nextInt(2) + 1;

        switch (row) {
            case 1:
                switch (num) {
                    case 1:

                        zombies.add(new HatZ(900, 50, 100, 2));
                        break;

                    default:
                        zombies.add(new TypicalZ(900, 50, 100, 2));
                        break;

                }
                break;
            case 2:
                switch (num) {
                    case 1:
                        zombies.add(new HatZ(900, 150, 100, 2));
                        break;

                    default:
                        zombies.add(new TypicalZ(900, 150, 100, 2));
                        break;

                }
                break;
            case 3:
                switch (num) {
                    case 1:
                        zombies.add(new HatZ(900, 250, 100, 2));
                        break;

                    default:
                        zombies.add(new TypicalZ(900, 250, 100, 2));
                        break;

                }
                break;
            case 4:
                switch (num) {
                    case 1:
                        zombies.add(new HatZ(900, 350, 100, 2));
                        break;

                    default:
                        zombies.add(new TypicalZ(900, 350, 100, 2));
                        break;

                }
                break;
            case 5:
                switch (num) {
                    case 1:
                        zombies.add(new HatZ(900, 450, 100, 2));

                    default:
                        zombies.add(new TypicalZ(900, 450, 100, 2));
                        break;

                }
                break;
            default:
                break;
        }

        for (Zombies i : zombies) {
            (new Thread(i)).start();
        }

    }

     /**
     * sets zombies
     */
    public void setzombies2() {
        int row = rand.nextInt(5) + 1;
        TypicalZ typicalz;
        typicalz = new TypicalZ(900, 50, 100, 2);

        switch (row) {
            case 1:

                typicalz = new TypicalZ(900, 50, 100, 2);
                break;
            case 2:
                typicalz = new TypicalZ(900, 150, 100, 2);
                break;
            case 3:
                typicalz = new TypicalZ(900, 250, 100, 2);
                break;
            case 4:
                typicalz = new TypicalZ(900, 350, 100, 2);
                break;
            default:
                typicalz = new TypicalZ(900, 450, 100, 2);
                break;

        }

        service = Executors.newFixedThreadPool(1);
        service.execute(typicalz);
        zombies.add(typicalz);

        (new Thread(typicalz)).start();
        service.shutdown();
    }

    /**
     * sets sun
     */
    public void setSun() {

        sun = new Sun();
        (new Thread(sun)).start();
    }

    /**
     * 
     * @param x
     * @param y 
     */
    public void addSunflower(int x, int y) {
        plants.add(new SunFlower(x, y));

    }

    /**
     * 
     * @param x
     * @param y 
     */
    public void addPeaShooter(int x, int y) {
        plants.add(new PeaShooter(x, y));
    }

    /**
     * 
     * @param x
     * @param y 
     */
    public void addSnowShooter(int x, int y) {
        plants.add(new SnowShooter(x, y));
    }

    /**
     * 
     * @param x
     * @param y 
     */
    public void addWallNut(int x, int y) {
        plants.add(new WallNut(x, y));
    }

    /**
     * 
     * @param x
     * @param y 
     */
    public void addCherryBomb(int x, int y) {
        plants.add(new CherryBomb(x, y));
    }

    /**
     * paint method
     * @param g 
     */
    @Override
    public void paint(Graphics g) {

        super.paint(g);

        synchronized (zombies) {
            for (Zombies i : zombies) {
                if (i.isIs_Alive()) {
                    g.drawImage(i.getImageIcon().getImage(), i.getX(), i.getY(), 80, 100, null);
                }
            }
        }

        synchronized (sun) {
            if (sun.flag == true) {
                g.drawImage(sun.getImageIcon().getImage(), sun.getX(), sun.getY(), 100, 100, null);
            }
        }

        synchronized (plants) {
            for (Plants i : plants) {
                if (i.is_Alive) {
                    g.drawImage(i.getImageIcon().getImage(), i.getX(), i.getY(), 80, 100, null);
                }
            }
        }
        synchronized (plants) {
            for (Plants i : plants) {
                if (i instanceof SunFlower) {
                    synchronized (((SunFlower) i).retSun()) {
                        for (Sun2 j : ((SunFlower) i).retSun()) {
                            if (j.flag == true && ((SunFlower) i).is_Alive == true) {
                                g.drawImage(j.getImageIcon().getImage(), i.getX(), i.getY(), 50, 50, null);
                            }

                        }
                    }
                }
            }
        }

        synchronized (plants) {
            for (Plants i : plants) {
                if (i instanceof PeaShooter) {
                    synchronized (((PeaShooter) i).retPeas()) {
                        for (Peas j : ((PeaShooter) i).retPeas()) {
                            if (j.alive == true && ((PeaShooter) i).is_Alive) {
                                g.drawImage(j.getImageIcon().getImage(), j.getX(), j.getY(), 40, 40, null);
                            }

                        }
                    }
                }
            }
        }

        synchronized (plants) {
            for (Plants i : plants) {
                if (i instanceof SnowShooter) {
                    synchronized (((SnowShooter) i).retPeas()) {
                        for (SnowPeas j : ((SnowShooter) i).retPeas()) {
                            if (j.alive == true && ((SnowShooter) i).is_Alive) {
                                g.drawImage(j.getImageIcon().getImage(), j.getX(), j.getY(), 40, 40, null);
                            }

                        }
                    }
                }
            }
        }

        synchronized (plants) {
            for (int i = 0; i < zombies.size(); i++) {
                if (zombies.get(i) instanceof ThrowZ) {
                    for (int j = 0; j < ((ThrowZ) zombies.get(i)).retBall().size(); j++) {
                        if (((ThrowZ) zombies.get(i)).retBall().get(j).alive == true && zombies.get(i).isIs_Alive() == true) {
                            g.drawImage(((ThrowZ) zombies.get(i)).retBall().get(j).getImageIcon().getImage(), ((ThrowZ) zombies.get(i)).retBall().get(j).getX(), ((ThrowZ) zombies.get(i)).retBall().get(j).getY(), 40, 40, null);
                        }
                    }
                }
            }
        }

        synchronized (mowers) {
            for (Mower i : mowers) {
                if (i.is_Alive) {
                    g.drawImage(i.getImageIcon().getImage(), i.getX() + 35, i.getY() + 18, 80, 80, null);
                }
            }
        }

        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        g.drawString(Integer.toString(getScore()), 90, 30);
        g.setColor(Color.BLACK);

//        Graphics2D g2 = (Graphics2D) g;
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 5; j++) {
//                Graphics2D g2d;
//
//                g2.setColor(Color.GREEN);
//                g2.draw(rectangles[i][j]);
//
//            }
//        }
    }

    /**
     * the run method
     */
    @Override
    public void run() {
        while (eog) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }
            try {
                for (Zombies i : zombies) {
                    if (i instanceof ThrowZ) {

                        for (Ball j : ((ThrowZ) i).retBall()) {
                            if (!(i.isIs_Alive())) {
                                j.alive = false;
                            }
                            if (j.alive == true) {
                                for (Plants k : plants) {
                                    if (k.is_Alive && k.getX() - 50 < j.getX() && j.getX() < k.getX() + 50 && k.getY() - 50 < j.getY() && j.getY() < k.getY() + 50) {

                                        k.setLife();
                                        j.alive = false;
                                        if (k.getLife() <= 0) {
                                            k.is_Alive = false;
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("error1!");
            }

            try {
                for (Plants i : plants) {
                    if (i instanceof PeaShooter) {

                        for (Peas j : ((PeaShooter) i).retPeas()) {
                            if (!(((PeaShooter) i).is_Alive)) {
                                j.alive = false;
                            }
                            if (j.alive == true) {
                                for (Zombies k : zombies) {
                                    if (k.isIs_Alive() && k.getX() - 20 < j.getX() && j.getX() < k.getX() + 50 && k.getY() - 20 < j.getY() && j.getY() < k.getY() + 50) {

                                        k.setLife();
                                        j.alive = false;
                                        if (k.getLife() <= 0) {
                                            k.setAlive(false);
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("error2!");
            }

            try {
                for (Plants i : plants) {
                    if (i instanceof SnowShooter) {

                        for (SnowPeas j : ((SnowShooter) i).retPeas()) {
                            if (!(((SnowShooter) i).is_Alive)) {
                                j.alive = false;
                            }
                            if (j.alive == true) {
                                for (Zombies k : zombies) {
                                    if (k.isIs_Alive() && k.getX() - 20 < j.getX() && j.getX() < k.getX() + 50 && k.getY() - 20 < j.getY() && j.getY() < k.getY() + 50) {

                                        k.setLife();
                                        j.alive = false;
                                        k.setSpeed(1);
                                        if (k.getLife() <= 0) {
                                            k.setAlive(false);
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("error3!");
            }

            try {

                for (Plants i : plants) {
                    for (Zombies j : zombies) {

                        if (j.isIs_Alive() && i.is_Alive) {
                            if (i.getX() - 20 < j.getX() && j.getX() < i.getX() + 50 && i.getY() - 20 < j.getY() && j.getY() < i.getY() + 50) {
                                Thread t = new Thread() {
                                    public void run() {

                                        j.setSpeed(0);
                                        try {
                                            if (i instanceof WallNut) {
                                                Thread.sleep(8000);
                                            } else if (!(i instanceof CherryBomb)) {
                                                Thread.sleep(2000);
                                            }
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(Zombies.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        i.is_Alive = false;
                                        j.setSpeed(2);
                                    }
                                };
                                t.start();

                            }
                        }
                    }

                }
            } catch (ConcurrentModificationException e) {
                System.out.println("error4!");
            }

            try {

                for (Plants i : plants) {

                    if (i instanceof CherryBomb && i.is_Alive) {
                        for (Zombies j : zombies) {
                            if ((j.getX() <= i.getX() + 200) && (j.getX() >= i.getX() - 200) && (j.getY() < i.getY() + 200) && (j.getY() > i.getY() - 200)) {

                                Thread t = new Thread() {
                                    public void run() {

                                        try {

                                            Thread.sleep(1000);

                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(Zombies.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        i.is_Alive = false;
                                        j.setAlive(false);
                                    }
                                };
                                t.start();
                            }
                        }
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("error5!");
            }

            try {

                for (Mower i : mowers) {
                    if (i.is_Alive) {
                        for (Zombies j : zombies) {

                            if (j.isIs_Alive()) {
                                if (i.getX() - 25 < j.getX() && j.getX() < i.getX() + 85 && i.getY() - 30 < j.getY() && j.getY() < i.getY() + 70) {
                                    if (i.b) {
                                        i.start();
                                        i.b = false;
                                    }

                                    j.setAlive(false);
                                    if (i.getX() >= 1000) {
                                        i.setAlive(false);
                                    }
                                }
                            }
                        }

                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("error!");
            }

            try {

                for (Mower i : mowers) {
                    if (i.is_Alive) {
                        for (Zombies j : zombies) {

                            if (j.isIs_Alive()) {
                                if (i.getX() - 50 < j.getX() && j.getX() < i.getX() + 50 && i.getY() - 50 < j.getY() && j.getY() < i.getY() + 50) {
                                    if (i.b) {
                                        i.start();
                                        i.b = false;
                                    }

                                    j.setAlive(false);
                                    if (i.getX() >= 1000) {
                                        i.setAlive(false);
                                    }
                                }
                            }
                        }

                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("error!");
            }

            try {

                for (Plants i : plants) {
                    for (Zombies j : zombies) {
                        if (j instanceof AthleteZ && ((AthleteZ) j).b) {
                            if (i.getX() - 50 < j.getX() && j.getX() < i.getX() + 50 && i.getY() - 50 < j.getY() && j.getY() < i.getY() + 50) {
                                j.setX(150);
                                ((AthleteZ) j).b = false;
                            }
                        } else if (j.isIs_Alive() && i.is_Alive) {
                            if (i.getX() - 20 < j.getX() && j.getX() < i.getX() + 50 && i.getY() - 20 < j.getY() && j.getY() < i.getY() + 50) {
                                Thread t = new Thread() {
                                    public void run() {

                                        j.setSpeed(0);
                                        try {
                                            if (i instanceof WallNut) {
                                                Thread.sleep(8000);
                                            } else if (!(i instanceof CherryBomb)) {
                                                Thread.sleep(2000);
                                            }
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(Zombies.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        i.is_Alive = false;
                                        j.setSpeed(2);
                                    }
                                };
                                t.start();

                            }
                        }
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("error4!");
            }

//        try{
//        for (Zombies j : zombies) {
//
//                        if (j.isIs_Alive()) {
//                            if (j.getX()<110) {
//                                System.exit(0);
//                        }
//                    }
//                    }
//              
//            } catch (ConcurrentModificationException e) {
//                System.out.println("error!");
//            }
            try {
                Thread t;
                if (plantType == 1 && grow == 1) {

                    t = new Thread() {
                        @Override
                        public void run() {
                            sunButton.setEnabled(false);
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            sunButton.setEnabled(true);
                        }

                    };
                    t.start();
                } else if (plantType == 2 && grow == 1) {
                    t = new Thread() {
                        @Override
                        public void run() {
                            peaShooterButton.setEnabled(false);
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            peaShooterButton.setEnabled(true);
                        }

                    };
                    t.start();
                } else if (plantType == 3 && grow == 1) {
                    t = new Thread() {
                        @Override
                        public void run() {
                            snowPeaButton.setEnabled(false);
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            snowPeaButton.setEnabled(true);
                        }

                    };
                    t.start();
                } else if (plantType == 4 && grow == 1) {
                    t = new Thread() {
                        @Override
                        public void run() {
                            wallNuttButton.setEnabled(false);
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            wallNuttButton.setEnabled(true);
                        }

                    };
                    t.start();
                } else if (plantType == 5 && grow == 1) {
                    t = new Thread() {
                        @Override
                        public void run() {
                            cherryButton.setEnabled(false);
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            cherryButton.setEnabled(true);
                        }

                    };
                    t.start();
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("error!");
            }

            repaint();
        }
    }

    public class SunClickhandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if ((e.getX() <= sun.getX() + 80) && (e.getX() >= sun.getX()) && (e.getY() < sun.getY() + 80) && (e.getY() > sun.getY())) {
                {
                    if (sun.flag == true) {
                        sun.flag = false;
                        setScore(getScore() + 25);
                    }
                }
            }

            for (Plants i : plants) {
                if (i instanceof SunFlower) {
                    // if(((SunFlower) i).flag)
                    {
                        if ((e.getX() <= i.getX() + 80) && (e.getX() >= i.getX() - 80) && (e.getY() < i.getY() + 80) && (e.getY() > i.getY() - 80)) {
                            for (Sun2 j : ((SunFlower) i).retSun()) {
                                if (j.flag == true) {
                                    j.flag = false;
                                    setScore(getScore() + 25);
                                }
                            }
                        }
                    }
                }
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

    public class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(sunButton)) {
                if (getScore() >= 50) {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Image cursorImage = toolkit.getImage("Sunflower.png");
                    Point cursorHotSpot = new Point(0, 0);
                    Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
                    setCursor(customCursor);

                    plantType = 1;

                    setScore(getScore() - 50);
                }
            } else if (e.getSource().equals(peaShooterButton)) {
                if (getScore() >= 100) {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Image cursorImage = toolkit.getImage("PeaShooter.png");
                    Point cursorHotSpot = new Point(0, 0);
                    Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
                    setCursor(customCursor);

                    plantType = 2;
                    setScore(getScore() - 100);
                }

            } else if (e.getSource().equals(snowPeaButton)) {
                if (getScore() >= 175) {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Image cursorImage = toolkit.getImage("SnowPea.png");
                    Point cursorHotSpot = new Point(0, 0);
                    Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
                    setCursor(customCursor);

                    plantType = 3;
                    setScore(getScore() - 175);
                }

            } else if (e.getSource().equals(wallNuttButton)) {
                if (getScore() >= 50) {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Image cursorImage = toolkit.getImage("WallNut.png");
                    Point cursorHotSpot = new Point(0, 0);
                    Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
                    setCursor(customCursor);

                    plantType = 4;
                    setScore(getScore() - 50);
                }

            } else if (e.getSource().equals(cherryButton)) {
                if (getScore() >= 150) {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Image cursorImage = toolkit.getImage("CherrBomb.png");
                    Point cursorHotSpot = new Point(0, 0);
                    Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
                    setCursor(customCursor);

                    plantType = 5;
                    setScore(getScore() - 150);
                }

            } else if (e.getSource().equals(shovelButton)) {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Image cursorImage = toolkit.getImage("shavel.png");
                Point cursorHotSpot = new Point(0, 0);
                Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
                setCursor(customCursor);

                plantType = 6;

            }

        }

    }

    public class GrowHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (plantType == 6) {
                try {
                    for (Plants i : plants) {
                        if (e.getX() - 50 < i.getX() && i.getX() < e.getX() && e.getY() - 50 < i.getY() && i.getY() < e.getY() + 50) {
                            plants.remove(i);
                            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                        }
                    }
                } catch (ConcurrentModificationException e3) {

                }

            } else {
                if (e.getY() >= 0 && e.getY() <= 100) {
                    if (e.getX() >= 210 && e.getX() <= 290) {
                        if (plantType == 1) {
                            addSunflower(260, 50);
                        } else if (plantType == 2) {
                            addPeaShooter(260, 50);
                            plantType = 0;
                        } else if (plantType == 3) {

                            addSnowShooter(260, 50);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(260, 50);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(260, 50);

                            plantType = 0;
                        }

                    } else if (e.getX() >= 290 && e.getX() <= 370) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(340, 50);

                        } else if (plantType == 2) {
                            addPeaShooter(340, 50);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(340, 50);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(340, 50);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(340, 50);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 370 && e.getX() <= 450) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(420, 50);

                        } else if (plantType == 2) {
                            addPeaShooter(420, 50);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(420, 50);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(420, 50);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(420, 50);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 450 && e.getX() <= 530) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(500, 50);

                        } else if (plantType == 2) {
                            addPeaShooter(500, 50);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(500, 50);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(500, 50);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(500, 50);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 530 && e.getX() <= 610) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(580, 50);

                        } else if (plantType == 2) {
                            addPeaShooter(580, 50);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(580, 50);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(580, 50);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(580, 50);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 610 && e.getX() <= 690) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(660, 50);

                        } else if (plantType == 2) {
                            addPeaShooter(660, 50);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(660, 50);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(660, 50);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(660, 50);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 690 && e.getX() <= 770) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(740, 50);

                        } else if (plantType == 2) {
                            addPeaShooter(740, 50);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(740, 50);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(740, 50);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(740, 50);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 770 && e.getX() <= 850) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(820, 50);

                        } else if (plantType == 2) {
                            addPeaShooter(820, 50);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(820, 50);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(820, 50);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(820, 50);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 850 && e.getX() <= 930) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(900, 50);

                        } else if (plantType == 2) {
                            addPeaShooter(900, 50);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(900, 50);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(900, 50);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(900, 50);
                            plantType = 0;
                        }

                    }
                } else if (e.getY() >= 100 && e.getY() <= 200) {
                    if (e.getX() >= 210 && e.getX() <= 290) {
                        if (plantType == 1) {
                            addSunflower(260, 150);
                        } else if (plantType == 2) {
                            addPeaShooter(260, 150);
                            plantType = 0;
                        } else if (plantType == 3) {
                            System.out.println("l");

                            addSnowShooter(260, 150);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(260, 150);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(260, 150);
                            System.out.println("l");

                            plantType = 0;
                        }

                    } else if (e.getX() >= 290 && e.getX() <= 370) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(340, 150);

                        } else if (plantType == 2) {
                            addPeaShooter(340, 150);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(340, 150);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(340, 150);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(340, 150);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 370 && e.getX() <= 450) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(420, 150);

                        } else if (plantType == 2) {
                            addPeaShooter(420, 150);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(420, 150);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(420, 150);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(420, 150);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 450 && e.getX() <= 530) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(500, 150);

                        } else if (plantType == 2) {
                            addPeaShooter(500, 150);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(500, 150);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(500, 150);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(500, 150);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 530 && e.getX() <= 610) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(580, 150);

                        } else if (plantType == 2) {
                            addPeaShooter(580, 150);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(580, 150);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(580, 150);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(580, 150);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 610 && e.getX() <= 690) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(660, 150);

                        } else if (plantType == 2) {
                            addPeaShooter(660, 150);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(660, 150);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(660, 150);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(660, 150);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 690 && e.getX() <= 770) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(740, 150);

                        } else if (plantType == 2) {
                            addPeaShooter(740, 150);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(740, 150);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(740, 150);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(740, 150);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 770 && e.getX() <= 850) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(820, 150);

                        } else if (plantType == 2) {
                            addPeaShooter(820, 150);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(820, 150);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(820, 150);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(820, 150);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 850 && e.getX() <= 930) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(900, 150);

                        } else if (plantType == 2) {
                            addPeaShooter(900, 150);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(900, 150);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(900, 150);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(900, 150);
                            plantType = 0;
                        }

                    }
                } else if (e.getY() >= 200 && e.getY() <= 300) {
                    if (e.getX() >= 210 && e.getX() <= 290) {
                        if (plantType == 1) {
                            addSunflower(260, 250);
                        } else if (plantType == 2) {
                            addPeaShooter(260, 250);
                            plantType = 0;
                        } else if (plantType == 3) {

                            addSnowShooter(260, 250);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(260, 250);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(260, 250);

                            plantType = 0;
                        }

                    } else if (e.getX() >= 290 && e.getX() <= 370) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(340, 250);
                            plantType = 0;

                        } else if (plantType == 2) {
                            addPeaShooter(340, 250);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(340, 250);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(340, 250);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(340, 250);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 370 && e.getX() <= 450) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(420, 250);
                            plantType = 0;

                        } else if (plantType == 2) {
                            addPeaShooter(420, 250);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(420, 250);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(420, 250);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(420, 250);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 450 && e.getX() <= 530) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(500, 250);
                            plantType = 0;

                        } else if (plantType == 2) {
                            addPeaShooter(500, 250);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(500, 250);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(500, 250);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(500, 250);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 530 && e.getX() <= 610) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(580, 250);
                            plantType = 0;

                        } else if (plantType == 2) {
                            addPeaShooter(580, 250);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(580, 250);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(580, 250);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(580, 250);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 610 && e.getX() <= 690) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(660, 250);
                            plantType = 0;

                        } else if (plantType == 2) {
                            addPeaShooter(660, 250);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(660, 250);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(660, 250);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(660, 250);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 690 && e.getX() <= 770) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(740, 250);
                            plantType = 0;

                        } else if (plantType == 2) {
                            addPeaShooter(740, 250);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(740, 250);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(740, 250);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(740, 250);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 770 && e.getX() <= 850) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(820, 250);
                            plantType = 0;

                        } else if (plantType == 2) {
                            addPeaShooter(820, 250);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(820, 250);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(820, 250);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(820, 250);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 850 && e.getX() <= 930) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(900, 250);
                            plantType = 0;

                        } else if (plantType == 2) {
                            addPeaShooter(900, 250);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(900, 2250);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(900, 250);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(900, 250);
                            plantType = 0;
                        }

                    }
                } else if (e.getY() >= 300 && e.getY() <= 400) {
                    if (e.getX() >= 210 && e.getX() <= 290) {
                        if (plantType == 1) {
                            addSunflower(260, 350);
                        } else if (plantType == 2) {
                            addPeaShooter(260, 350);
                            plantType = 0;
                        } else if (plantType == 3) {

                            addSnowShooter(260, 350);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(260, 350);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(260, 350);

                            plantType = 0;
                        }

                    } else if (e.getX() >= 290 && e.getX() <= 370) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(340, 350);

                        } else if (plantType == 2) {
                            addPeaShooter(340, 350);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(340, 350);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(340, 350);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(340, 350);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 370 && e.getX() <= 450) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(420, 350);

                        } else if (plantType == 2) {
                            addPeaShooter(420, 350);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(420, 350);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(420, 350);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(420, 350);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 450 && e.getX() <= 530) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(500, 350);

                        } else if (plantType == 2) {
                            addPeaShooter(500, 350);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(500, 350);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(500, 350);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(500, 350);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 530 && e.getX() <= 610) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(580, 350);

                        } else if (plantType == 2) {
                            addPeaShooter(580, 350);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(580, 350);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(580, 350);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(580, 350);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 610 && e.getX() <= 690) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(660, 350);

                        } else if (plantType == 2) {
                            addPeaShooter(660, 350);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(660, 350);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(660, 350);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(660, 350);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 690 && e.getX() <= 770) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(740, 50);

                        } else if (plantType == 2) {
                            addPeaShooter(740, 350);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(740, 350);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(740, 350);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(740, 350);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 770 && e.getX() <= 850) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(820, 350);

                        } else if (plantType == 2) {
                            addPeaShooter(820, 350);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(820, 350);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(820, 350);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(820, 350);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 850 && e.getX() <= 930) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(900, 350);

                        } else if (plantType == 2) {
                            addPeaShooter(900, 350);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(900, 350);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(900, 350);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(900, 350);
                            plantType = 0;
                        }

                    }

                } else if (e.getY() >= 400 && e.getY() <= 500) {
                    if (e.getX() >= 210 && e.getX() <= 290) {
                        if (plantType == 1) {
                            addSunflower(260, 450);
                        } else if (plantType == 2) {
                            addPeaShooter(260, 450);
                            plantType = 0;
                        } else if (plantType == 3) {

                            addSnowShooter(260, 450);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(260, 450);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(260, 450);

                            plantType = 0;
                        }

                    } else if (e.getX() >= 290 && e.getX() <= 370) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(340, 450);

                        } else if (plantType == 2) {
                            addPeaShooter(340, 450);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(340, 450);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(340, 450);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(340, 450);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 370 && e.getX() <= 450) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(420, 450);

                        } else if (plantType == 2) {
                            addPeaShooter(420, 450);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(420, 450);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(420, 450);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(420, 450);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 450 && e.getX() <= 530) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(500, 450);

                        } else if (plantType == 2) {
                            addPeaShooter(500, 450);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(500, 450);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(500, 450);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(500, 450);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 530 && e.getX() <= 610) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(580, 450);

                        } else if (plantType == 2) {
                            addPeaShooter(580, 450);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(580, 450);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(580, 450);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(580, 450);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 610 && e.getX() <= 690) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(660, 450);

                        } else if (plantType == 2) {
                            addPeaShooter(660, 450);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(660, 450);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(660, 450);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(660, 450);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 690 && e.getX() <= 770) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(740, 450);

                        } else if (plantType == 2) {
                            addPeaShooter(740, 450);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(740, 450);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(740, 450);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(740, 450);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 770 && e.getX() <= 850) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(820, 450);

                        } else if (plantType == 2) {
                            addPeaShooter(820, 450);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(820, 450);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(820, 450);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(820, 450);
                            plantType = 0;
                        }

                    } else if (e.getX() >= 850 && e.getX() <= 930) {
                        if (plantType == 1) {
                            System.out.println("l");
                            addSunflower(900, 450);

                        } else if (plantType == 2) {
                            addPeaShooter(900, 450);
                            plantType = 0;
                        } else if (plantType == 3) {
                            addSnowShooter(900, 450);
                            plantType = 0;
                        } else if (plantType == 4) {
                            addWallNut(900, 450);
                            plantType = 0;
                        } else if (plantType == 5) {
                            addCherryBomb(900, 450);
                            plantType = 0;
                        }

                    }

                }

                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                plantType = 0;
                grow = 1;

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
