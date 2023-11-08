import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartFrame extends JFrame{
    public static MusicPlay music;
    protected ImageIcon startBackground;
    protected ImageIcon titleImage;
    protected ImageIcon start;
    protected ImageIcon rule;


    protected StartFrame(){}
    public StartFrame(JFrame frame) {
        frameSetting(frame);

        MainDisplay runable = new MainDisplay();
        Thread th = new Thread(runable);
        th.start();
    }

    public void frameSetting(JFrame frame){
        frame.setTitle("Hogwarts Escape");
        frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);//Make the frame appear in the center of the screen
        frame.setResizable(false);//Fixed Frame
        frame.setLayout(null);
    }
    public void showFrame(JFrame frame){
        frame.setSize(1200, 750);
        frame.setVisible(true);
    }
}

class MainDisplay extends ActiveFunction implements Runnable {
    ActiveFunction active = new ActiveFunction();
    @Override
    public void run() {
        active.loadComponent(); //Load Image
        active.addComponent();
        active.UI();
        music.musicPlay();
    }

}
