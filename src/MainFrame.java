import javax.swing.*;
import java.awt.*;
public class MainFrame extends JFrame {

    public JLabel backGround(){
        ImageIcon bg = new ImageIcon("./img/background.png");
        JLabel background = new JLabel(bg);
        background.setSize(1200,750);
        background.setLocation(0,0);

        return background;
    }

    public JLabel TitleBar() {
        ImageIcon titleImage = new ImageIcon("./img/img.png");
        JLabel title = new JLabel(titleImage);
        title.setSize(titleImage.getIconWidth(), titleImage.getIconHeight());
        title.setLocation(420, 80);
        return title;
    }

    public MainFrame(){
        super("Hoguwarts Escape");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane();
        setLayout(null);

        add(TitleBar());
        add(backGround());
        setSize(1200,750);
        setVisible(true);
    }
}
