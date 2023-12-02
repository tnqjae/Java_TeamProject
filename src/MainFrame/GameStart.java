package MainFrame;

import AboutFunction.ActiveFunction;
import AboutFunction.KeyboardEvent;
import MainFrame.Main;

import javax.swing.*;
import AboutFunction.MapSelection;

import java.util.Random;

public class GameStart extends ActiveFunction {
    public static JLabel  boldmote;
    //Contains the overall content of the game
    private ImageIcon character;
    private static ImageIcon hoc;
    public static JLabel hoclabel;
    public static int sumHoc = 0;

    public GameStart(){
        character = new ImageIcon("./img/character/herry_front.png");
        boldmote = createLabel(character, 200,200);

        addActiveListener();

        Main.setFrame.add(boldmote);
        addHocImg();
        new MapSelection();
    }
    public void addActiveListener(){
        KeyboardEvent keyboardEvent = new KeyboardEvent(); // MainFrame.GameStart 인스턴스 전달

        boldmote.addKeyListener(keyboardEvent);
        boldmote.setFocusable(true);
        boldmote.requestFocusInWindow(); // boldmote에 포커스 요청

        Main.setFrame.addKeyListener(keyboardEvent); // 프레임에도 KeyListener 추가
        Main.setFrame.setFocusable(true);
    }
    public static void removeHoclabel(){
        GameStart.hoclabel.setIcon(null);
        hoc = null;
        hoclabel = null;
        if (GameStart.hoclabel != null) {
            Main.setFrame.remove(GameStart.hoclabel);
            Main.setFrame.revalidate();
            Main.setFrame.repaint();
        }
    }

    public static void addHocImg(){
        String hoclist[] = {"img/hoc1.png","img/hoc2.png","img/hoc3.png"};
        hoc = new ImageIcon(hoclist[0]);
        Random random = new Random();
        hoclabel = createLabel(hoc, random.nextInt(700) + 145,400);
        Main.setFrame.add(hoclabel);
    }

}
