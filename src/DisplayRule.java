import javax.swing.*;

public class DisplayRule extends ActiveFunction{
    private ImageIcon ruleBackground;
    public DisplayRule(){
        ruleBackground = new ImageIcon("./img/ruleBackground.jpeg");
        JLabel rulebg = createLabel(ruleBackground, 0,0);

        Main.setFrame.add(rulebg);
    }
}
