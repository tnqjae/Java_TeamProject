import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
class Init { //Init JFrame class
    public Init(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() { //Using Threads for Real-Time Processing
                //JFrame Init
                Main.setFrame.getContentPane().removeAll();
                Main.setFrame.revalidate();
                Main.setFrame.repaint();
            }
        });
        thread.start();
    }

}
class StartClickEvent extends MouseAdapter {

    public StartClickEvent() {
        //Dumy constructor
    }
    public void mouseClicked(MouseEvent e) {
        new Init();
    }

}

class RuleClickEvent extends MouseAdapter {
    public RuleClickEvent() {
        //Dumy constructor
    }
    public void mouseClicked(MouseEvent e) {
        new Init();
    };
}


