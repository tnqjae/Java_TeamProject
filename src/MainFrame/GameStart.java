package MainFrame;

import AboutFunction.ActiveFunction;
import AboutFunction.KeyboardEvent;

import javax.swing.*;
import AboutFunction.AboutMapfunction;

import java.util.Random;

public class GameStart extends ActiveFunction {
    public static JLabel  boldmote;
    //Contains the overall content of the game
    private ImageIcon character;
    private static ImageIcon hoc;
    private static ImageIcon hoc2;
    private static ImageIcon NeginiImg;
    public static JLabel hoclabel;
    public static JLabel hoclabel2;
    public static JLabel negini;
    private static int listNum = 0;
    private static boolean isGetNegini = false;
    public static int sumHoc = 0;

    public GameStart(){
        character = new ImageIcon("./img/character/herry_front.png");
        boldmote = createLabel(character, 200,200);

        addActiveListener();

        Main.setFrame.add(boldmote);
        addHocImg1();
        addHocImg2();
        addNeginiImg();
        new AboutMapfunction();
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

    public static void removeHoclabel2(){
        GameStart.hoclabel2.setIcon(null);
        hoc2 = null;
        hoclabel2 = null;
        if (GameStart.hoclabel2 != null) {
            Main.setFrame.remove(GameStart.hoclabel2);
            Main.setFrame.revalidate();
            Main.setFrame.repaint();
        }
    }
    public static void removeNeginilabel(){
        GameStart.negini.setIcon(null);
        NeginiImg = null;
        negini = null;
        if (GameStart.negini != null) {
            Main.setFrame.remove(GameStart.negini);
            Main.setFrame.revalidate();
            Main.setFrame.repaint();
        }
    }

    public static void addHocImg1(){
        hoc = new ImageIcon("img/hoc1.png");
        listNum += 1;
        Random random = new Random();
        hoclabel = createLabel(hoc, random.nextInt(700) + 145,random.nextInt(200) + 145);
        Main.setFrame.add(hoclabel);
    }

    public static void addHocImg2(){
        hoc2 = new ImageIcon("img/hoc2.png");
        listNum += 1;
        Random random = new Random();
        hoclabel2 = createLabel(hoc2, random.nextInt(700) + 145,random.nextInt(200) + 100);
        Main.setFrame.add(hoclabel2);
    }

    public static void addNeginiImg(){
        NeginiImg = new ImageIcon("img/negini.png");
        listNum += 1;
        Random random = new Random();
        negini = createLabel(NeginiImg, random.nextInt(700) + 145,random.nextInt(200) + 145);
        Main.setFrame.add(negini);
    }

    public static void setNeginiState(boolean state){
        isGetNegini = state;
    }
    public static boolean getNeginiState(){
        return isGetNegini;
    }

}
