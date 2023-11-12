package AboutFunction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import MainFrame.GameStart;

//Define All key Event
public class KeyboardEvent extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode(); // 눌린 키의 코드를 가져옵니다.

        if (keyCode == KeyEvent.VK_UP) {
            GameStart.boldmote.setLocation(GameStart.boldmote.getX(), GameStart.boldmote.getY() - 10);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            GameStart.boldmote.setLocation(GameStart.boldmote.getX(), GameStart.boldmote.getY() + 10);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            GameStart.boldmote.setLocation(GameStart.boldmote.getX() - 10, GameStart.boldmote.getY());
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            GameStart.boldmote.setLocation(GameStart.boldmote.getX() + 10, GameStart.boldmote.getY());
        }
    }
}

