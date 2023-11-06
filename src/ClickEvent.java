import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class StartClickEvent extends MouseAdapter {

    public StartClickEvent() {
        //Dumy constructor
    }
    public void mouseClicked(MouseEvent e) {
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


