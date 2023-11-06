import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartFrame extends JFrame{
    public static MusicPlay music;
    protected ImageIcon bg;
    protected ImageIcon titleImage;
    protected ImageIcon start;
    protected ImageIcon rule;

    protected StartFrame(){}
    public StartFrame(JFrame mainframe) {
        frameSetting(mainframe);

        MainDisplay runable = new MainDisplay();
        Thread th = new Thread(runable);
        th.start();
        mainframe.setLocation(300,300);

        ActiveFunction active = new ActiveFunction();
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

class ActiveFunction extends StartFrame{
    protected ActiveFunction(){}
    protected void loadComponent() {
        bg = new ImageIcon("./img/StartBackground.jpeg");
        titleImage = new ImageIcon("./img/title.png");
        start = new ImageIcon("./img/Start.png");
        rule = new ImageIcon("./img/Rule.png");
        //Load music
        music = new MusicPlay("./music/herrypotter.wav");
    }
    //Create Label
    protected JLabel createLabel(ImageIcon icon, int x, int y){
        JLabel la = new JLabel(icon);
        la.setLocation(x,y);
        la.setSize(icon.getIconWidth(),icon.getIconHeight());
        return la;
    }
    //add Listener
    protected void addEventListener(JLabel la, MouseAdapter listener){
        la.addMouseListener(listener);
    }
    //Create and add component
    protected void addComponent(){
        //Set Title
        Main.setFrame.add(createLabel(titleImage,350,80));
        //Set Background
        Main.setFrame.add(createLabel(bg, 0,0));
        //Set Start Button
        JLabel startLabel = createLabel(start, 60, 380);
        addEventListener(startLabel, new StartClickEvent());
        Main.setFrame.add(startLabel);
        //Set Rule Button
        JLabel ruleLabel = createLabel(rule, 60,500);
        addEventListener(ruleLabel,new RuleClickEvent());
        Main.setFrame.add(ruleLabel);
    }
    protected void UI(){
        Main.setFrame.setSize(1200, 750);
        Main.setFrame.setVisible(true);
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
