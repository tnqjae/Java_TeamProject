import javax.swing.*;
import java.awt.event.MouseAdapter;

class ActiveFunction extends StartFrame{
    public ActiveFunction(){}

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

        Main.setFrame.add(createLabel(titleImage,420,80));//title
        Main.setFrame.add(createLabel(bg, 0,0));//background
    }
}