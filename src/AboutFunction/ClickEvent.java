package AboutFunction;

import MainFrame.StartFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import MainFrame.DisplayRule;
import MainFrame.GameStart;

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
        StartFrame.music.musicStop();
        new DisplayRule();
    };
}


