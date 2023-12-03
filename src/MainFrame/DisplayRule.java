package MainFrame;

import AboutFunction.ActiveFunction;

import AboutFunction.FrameInit;
import MainFrame.Main;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DisplayRule extends ActiveFunction {
    private ImageIcon ruleBackground;
    private ImageIcon backbutton;
    public DisplayRule(){
        ruleBackground = new ImageIcon("./img/ruleBackground.jpeg");
        backbutton = new ImageIcon("img/back_button.png");
        JLabel rulebg = createLabel(ruleBackground, 0,0);

        JLabel backbtn = createLabel(backbutton,200,400);
        addEventListener(backbtn, new BackButton());

        Main.setFrame.add(backbtn);
        Main.setFrame.add(rulebg);
    }
}
class BackButton extends MouseAdapter {
    public BackButton(){}
    public void mouseClicked(MouseEvent e) {
        new FrameInit();
        ActiveFunction.addComponent();
        ActiveFunction.loadComponent();
        StartFrame.music.musicPlay();
    };

}
