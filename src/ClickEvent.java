import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.sound.sampled.Clip;

class StartClickEvent extends MouseAdapter {

    public StartClickEvent() {
        //Dumy constructor
    }
    public void mouseClicked(MouseEvent e) {
        StartFrame.music.musicStop();
        new FrameInit();
        GameStart start = new GameStart();
    }

}

class RuleClickEvent extends MouseAdapter {
    public RuleClickEvent() {
        //Dumy constructor
    }
    public void mouseClicked(MouseEvent e) {
        new FrameInit();
        new DisplayRule();
    };
}


