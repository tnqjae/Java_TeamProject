package MainFrame;

import AboutFunction.*;
import javax.swing.*;

public class StartFrame extends JFrame{
    public static MusicPlay music;
    protected ImageIcon startBackground;
    protected ImageIcon titleImage;
    protected ImageIcon start;
    protected ImageIcon rule;


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
        frame.setLocationRelativeTo(null);//Make the frame appear in the center of the screen
        frame.setResizable(false);//Fixed Frame
        frame.setLayout(null);
    }
    private void showFrame(JFrame frame){
        frame.setSize(1200, 750);
        frame.setVisible(true);
    }
}

class MainDisplay extends ActiveFunction implements Runnable {
    @Override
    public void run() {
        loadComponent(); //Load Image
        addComponent();
        UI();
        StartFrame.music.musicPlay();
    }

}
