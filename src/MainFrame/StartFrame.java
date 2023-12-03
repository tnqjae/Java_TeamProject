package MainFrame;

import AboutFunction.*;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class StartFrame extends JFrame{
    private Dimension res;
    public static MusicPlay music;
    protected static ImageIcon startBackground;
    protected static ImageIcon titleImage;
    protected static ImageIcon startButton;
    protected static ImageIcon ruleButton;

    protected StartFrame(){}
    protected StartFrame(JFrame frame) {
        frameSetting(frame);

        MainDisplay runable = new MainDisplay();
        Thread th = new Thread(runable);
        th.start();
    }

    private void frameSetting(JFrame frame){
        frame.setTitle("Hogwarts Escape");
        frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        res = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(res.height / 4, res.width / 8);//Make the frame appear in the center of the screen
        frame.setResizable(false);//Fixed Frame
        frame.setLayout(null);
    }
    private void showFrame(JFrame frame){
        frame.setSize(1200, 750);
        frame.setVisible(true);
    }
}

//Use Thread to display component.
class MainDisplay extends ActiveFunction implements Runnable {
    @Override
    public void run() {
        loadComponent(); //Load Image
        addComponent();
        UI();
        StartFrame.music.musicPlay();
    }

}
