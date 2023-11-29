package AboutFunction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import MainFrame.GameStart;

import javax.swing.*;

//Define All key Event
public class KeyboardEvent extends KeyAdapter {
    ActiveFunction active = new ActiveFunction();
    @Override
    public void keyPressed(KeyEvent e) {
        ImageIcon refresh;
        int keyCode = e.getKeyCode(); // 눌린 키의 코드를 가져옵니다.

        if (keyCode == KeyEvent.VK_UP) {
            GameStart.boldmote.setLocation(GameStart.boldmote.getX(), GameStart.boldmote.getY() - 10);
            active.changeImg(GameStart.boldmote, "./img/character/herry_back.png");
        }
        else if (keyCode == KeyEvent.VK_DOWN) {
            GameStart.boldmote.setLocation(GameStart.boldmote.getX(), GameStart.boldmote.getY() + 10);
            active.changeImg(GameStart.boldmote, "./img/character/herry_front.png");
        }
        else if (keyCode == KeyEvent.VK_LEFT) {
            GameStart.boldmote.setLocation(GameStart.boldmote.getX() - 10, GameStart.boldmote.getY());
            active.changeImg(GameStart.boldmote, "./img/character/herry_left.png");
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            GameStart.boldmote.setLocation(GameStart.boldmote.getX() + 10, GameStart.boldmote.getY());
            active.changeImg(GameStart.boldmote, "./img/character/herry_right.png");
        }
    }

}

