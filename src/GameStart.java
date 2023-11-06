import javax.swing.*;

public class GameStart extends ActiveFunction{
    public static JLabel  boldmote;
    //Contains the overall content of the game
    public ImageIcon character;
    public GameStart(){
        ActiveFunction active = new ActiveFunction();

        character = new ImageIcon("./img/test.png");
        boldmote = active.createLabel(character, 200,200);

        addActiveListener();

        Main.setFrame.add(boldmote);
    }
    public void addActiveListener(){
        KeyboardEvent keyboardEvent = new KeyboardEvent(this); // GameStart 인스턴스 전달

        boldmote.addKeyListener(keyboardEvent);
        boldmote.setFocusable(true);
        boldmote.requestFocusInWindow(); // boldmote에 포커스 요청

        Main.setFrame.addKeyListener(keyboardEvent); // 프레임에도 KeyListener 추가
        Main.setFrame.setFocusable(true);
    }
}
