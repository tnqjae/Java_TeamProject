package AboutFunction;

import MainFrame.Main;
import MainFrame.MusicPlay;
import MainFrame.StartFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;

public class ActiveFunction extends StartFrame {
    protected ActiveFunction(){}
    public static void loadComponent() {
        startBackground = new ImageIcon("./img/mainFrameImg/StartBackground.jpeg");
        titleImage = new ImageIcon("./img/mainFrameImg/title.png");
        startButton = new ImageIcon("./img/mainFrameImg/Start.png");
        ruleButton = new ImageIcon("./img/mainFrameImg/Rule.png");
        //Load music
        music = new MusicPlay("./music/herrypotter.wav");
    }
    //Create Label
    public static JLabel createLabel(ImageIcon icon, int x, int y) {
        JLabel la = new JLabel(icon);
        la.setLocation(x,y);
        la.setSize(icon.getIconWidth(),icon.getIconHeight());
        return la;
    }
    //add Listener
    public static void addEventListener(JLabel la, MouseAdapter listener){
        la.addMouseListener(listener);
    }
    //Create and add component
    public static void addComponent(){
        //Set Start Button
        JLabel startLabel = createLabel(startButton, 60, 380);
        addEventListener(startLabel, new StartClickEvent());
        Main.setFrame.add(startLabel);
        //Set Rule Button
        JLabel ruleLabel = createLabel(ruleButton, 60,500);
        addEventListener(ruleLabel,new RuleClickEvent());
        Main.setFrame.add(ruleLabel);

        //Set Title
        Main.setFrame.add(createLabel(titleImage,350,80));
        //Set Background
        Main.setFrame.add(createLabel(startBackground, 0,0));
    }
    public void UI(){
        Main.setFrame.setSize(1200, 750);
        Main.setFrame.setVisible(true);
    }

    public JLabel changeImg(JLabel label, String path){
        ImageIcon icon = new ImageIcon(path);
        label.setIcon(icon);

        return label;
    }

}
