import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartFrame extends JFrame {
    ImageIcon bg;
    ImageIcon titleImage;
    ImageIcon start;
    ImageIcon rule;

    public StartFrame() {
        super("Hogwarts Escape");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        //Using Thread to Load Image Process.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                loadImages(); //Load Image
                addComponent();
                UI();
            }
        });
        thread.start();
    }

    //Load Image Location
    private void loadImages() {
        bg = new ImageIcon("./img/StartBackground.jpeg");
        titleImage = new ImageIcon("./img/title.png");
        start = new ImageIcon("./img/Start.png");
        rule = new ImageIcon("./img/Rule.png");
    }

    //Create Label
    private JLabel createLabel(ImageIcon icon, int x, int y){
        JLabel la = new JLabel(icon);
        la.setLocation(x,y);
        la.setSize(icon.getIconWidth(),icon.getIconHeight());
        return la;
    }

    //add Listener
    private void addEventListener(JLabel la, MouseAdapter listener){
        la.addMouseListener(listener);
    }

    //Create and add component
    private void addComponent(){
        JLabel startLabel = createLabel(start, 60, 380);
        addEventListener(startLabel, new StartClickEvent());
        add(startLabel);

        JLabel ruleLabel = createLabel(rule, 60,500);
        addEventListener(ruleLabel,new RuleClickEvent());
        add(ruleLabel);

        add(createLabel(titleImage,420,80));//title
        add(createLabel(bg, 0,0));//background
    }
    private void UI(){
        SwingUtilities.invokeLater(() ->{
            setSize(1200, 750);
            setVisible(true);
        });
    }
}
