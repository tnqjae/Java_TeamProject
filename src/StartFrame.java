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
}