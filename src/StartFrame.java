import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartFrame extends JFrame{
    protected ImageIcon bg;
    protected ImageIcon titleImage;
    protected ImageIcon start;
    protected ImageIcon rule;

    protected StartFrame(){}

    public StartFrame(JFrame mainframe) {
        super("Hogwarts Escape");
        mainframe.getContentPane();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setLayout(null);

        ActiveFunction active = new ActiveFunction();

        //Using Thread to Load Image Process.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                active.loadImages(); //Load Image
                active.addComponent();
                active.UI();
            }
        });
        thread.start();
    }
<<<<<<< HEAD
=======

}

class ActiveFunction extends StartFrame{
    protected ActiveFunction(){}

    protected void loadImages() {
        bg = new ImageIcon("./img/StartBackground.jpeg");
        titleImage = new ImageIcon("./img/title.png");
        start = new ImageIcon("./img/Start.png");
        rule = new ImageIcon("./img/Rule.png");
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
        JLabel startLabel = createLabel(start, 60, 380);
        addEventListener(startLabel, new StartClickEvent());
        Main.setFrame.add(startLabel);

        JLabel ruleLabel = createLabel(rule, 60,500);
        addEventListener(ruleLabel,new RuleClickEvent());
        Main.setFrame.add(ruleLabel);

        Main.setFrame.add(createLabel(titleImage,350
                ,80));//title
        Main.setFrame.add(createLabel(bg, 0,0));//background
    }
    protected void UI(){
        Main.setFrame.setSize(1200, 750);
        Main.setFrame.setVisible(true);
    }
>>>>>>> origin
}