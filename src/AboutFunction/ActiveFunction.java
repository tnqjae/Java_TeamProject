package AboutFunction;

import MainFrame.Main;
import MainFrame.MusicPlay;
import MainFrame.StartFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;

public class ActiveFunction extends StartFrame {
    protected ActiveFunction(){}
    protected void loadComponent() {
        startBackground = new ImageIcon("./img/StartBackground.jpeg");
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
        //Set Start Button
        JLabel startLabel = createLabel(start, 60, 380);
        addEventListener(startLabel, new StartClickEvent());
        Main.setFrame.add(startLabel);
        //Set Rule Button
        JLabel ruleLabel = createLabel(rule, 60,500);
        addEventListener(ruleLabel,new RuleClickEvent());
        Main.setFrame.add(ruleLabel);

        //Set Title
        Main.setFrame.add(createLabel(titleImage,350,80));
        //Set Background
        Main.setFrame.add(createLabel(startBackground, 0,0));
    }
    protected void UI(){
        Main.setFrame.setSize(1200, 750);
        Main.setFrame.setVisible(true);
    }
}
