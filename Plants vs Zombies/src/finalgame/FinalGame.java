/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalgame;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class FinalGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        // TODO code application logic here
//        MyFrame frame = new MyFrame();
//       (new Thread(frame)).start();

        MenuFrame f = new MenuFrame();

        final Clip clip = AudioSystem.getClip();
        final AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("grasswalk.wav"));
        clip.open(inputStream);
        while (true) {
            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);
        }

    }

}
