import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartFrame extends JFrame{
    protected ImageIcon bg;
    protected ImageIcon titleImage;
    protected ImageIcon start;
    protected ImageIcon rule;

    protected StartFrame(){}
    public StartFrame(JFrame startFrame) {
        frameSetting(startFrame);

        ActiveFunction active = new ActiveFunction();
        //Using Thread to Load Image Process.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                active.loadImages(); //Load Image
                active.addComponent();
                showFrame(startFrame);
            }
        });
        thread.start();
    }

    public void frameSetting(JFrame frame){
        frame.setTitle("Hogwarts Escape");
        frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }
    public void showFrame(JFrame frame){
        frame.setSize(1200, 750);
        frame.setVisible(true);
    }
}

