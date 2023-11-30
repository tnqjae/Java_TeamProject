package AboutFunction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import MainFrame.GameStart;

import javax.swing.*;

// 모든 키 이벤트 정의
public class KeyboardEvent extends KeyAdapter {
    ActiveFunction active = new ActiveFunction();

    @Override
    public void keyPressed(KeyEvent e) {
        ImageIcon refresh;
        int keyCode = e.getKeyCode(); // 눌린 키의 코드를 가져옵니다.

        int x = GameStart.boldmote.getX();
        int y = GameStart.boldmote.getY();

        // 이동 전의 위치를 저장합니다.
        int oldX = x;
        int oldY = y;

        // 키 입력에 따라 위치를 조정합니다.
        if (keyCode == KeyEvent.VK_UP) {
            y -= 10;
            active.changeImg(GameStart.boldmote, "./img/character/herry_back.png");
        } else if (keyCode == KeyEvent.VK_DOWN) {
            y += 10;
            active.changeImg(GameStart.boldmote, "./img/character/herry_front.png");
        } else if (keyCode == KeyEvent.VK_LEFT) {
            x -= 10;
            active.changeImg(GameStart.boldmote, "./img/character/herry_left.png");
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            x += 10;
            active.changeImg(GameStart.boldmote, "./img/character/herry_right.png");
        }

        // JFrame 영역을 벗어나면 위치를 수정합니다.
        if (isWithinBounds(x, y, GameStart.boldmote.getWidth(), GameStart.boldmote.getHeight())) {
            GameStart.boldmote.setLocation(x, y);
        } else {
            // 위치를 조정하지 않고 이동하지 않도록 이전 위치로 복원합니다.
            GameStart.boldmote.setLocation(oldX, oldY);
        }
    }

    // 주어진 좌표가 JFrame 영역 내에 있는지 확인하는 메서드
    private boolean isWithinBounds(int x, int y, int width, int height) {
        return x >= 0 && y >= 0 && x + width <= 1200 && y + height <= 750;
    }
}