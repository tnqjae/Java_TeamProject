package AboutFunction;

import MainFrame.GameStart;
import MainFrame.Main;
import MiniGame.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.GlyphMetrics;
import javax.swing.*;

public class KeyboardEvent extends KeyAdapter {

    private ActiveFunction active = new ActiveFunction();
    private Timer timer;
    private int imageIndex; // 이미지 인덱스

    public KeyboardEvent() {
        // 타이머 설정
        timer = new Timer(1000, new ActionListener() { // 이미지를 0.2초 간격으로 변경
            @Override
            public void actionPerformed(ActionEvent e) {
                // 타이머가 갱신될 때마다 이미지 변경 메서드 호출
                handleContinuousKeyPress();
            }
        });

        imageIndex = 0; // 초기 이미지 인덱스 설정
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // 왼쪽 또는 오른쪽 키가 눌렸을 때 타이머 시작
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
            timer.start();
        }

        // 이미지 변경 및 위치 조정
        handleKeyPress(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // 키가 떼졌을 때 타이머 중지
        timer.stop();
        // 이미지 인덱스 초기화
        imageIndex = 0;

        if (keyCode == KeyEvent.VK_LEFT) {
            active.changeImg(GameStart.boldmote, "./img/character/herry_left.png");
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            active.changeImg(GameStart.boldmote, "./img/character/herry_right.png");
        } else if(keyCode == KeyEvent.VK_UP){
            active.changeImg(GameStart.boldmote, "./img/character/herry_back.png");
        } else if(keyCode == KeyEvent.VK_DOWN){
            active.changeImg(GameStart.boldmote, "./img/character/herry_front.png");
        }


    }

    private void handleKeyPress(int keyCode) {
        int x = GameStart.boldmote.getX();
        int y = GameStart.boldmote.getY();

        // Save the position before moving.
        int oldX = x;
        int oldY = y;

        // Adjust the position based on the left or right arrow key.
        if (keyCode == KeyEvent.VK_LEFT) {
            x -= 10;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            x += 10;
        } else if(keyCode == KeyEvent.VK_UP){
            y -= 10;
        } else if(keyCode == KeyEvent.VK_DOWN){
            y += 10;
        }

        if (coversCoordinates(x, y, 1065, 400)) {
            // 이미지가 특정 좌표를 커버하는 동안 다이얼로그 표시
            JOptionPane.showMessageDialog(null, "문제를 푸시겠습니까?");
            new Question1();
        }

        // Modify the position if it goes out of the JFrame area.
        if (isWithinBounds(x, y, GameStart.boldmote.getWidth(), GameStart.boldmote.getHeight())) {
            GameStart.boldmote.setLocation(x, y);

            if (GameStart.hoclabel != null && isCollidingWithObstacle(x, y, GameStart.hoclabel.getBounds())) {
                GameStart.removeHoclabel();
                GameStart.sumHoc += 1;
            }

            // 이미지 변경 메서드 호출
            changeImages(keyCode);
        } else {
            // Restore to the previous position so that it doesn't move without adjusting its position.
            GameStart.boldmote.setLocation(oldX, oldY);
        }
    }

    private void handleContinuousKeyPress() {
        // 계속해서 눌린 키에 대한 처리를 여기에 추가
        // 예를 들어, 여러 이미지를 반복하여 변경할 수 있습니다.
        // 여기서는 이미지 변경 로직을 타이머에서 처리하므로 불필요
    }

    private void changeImages(int keyCode) {
        // 여러 이미지 경로를 순환하면서 변경
        String[] images;

        if (keyCode == KeyEvent.VK_LEFT) {
            images = new String[] {
                    "./img/character/herry_left_walkLeftleg.png",
                    "./img/character/herry_left_walkRightleg.png"
            };
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            images = new String[] {
                    "./img/character/herry_right_walkLeftleg.png",
                    "./img/character/herry_right_walkRightleg.png"
            };
        } else if (keyCode == KeyEvent.VK_UP) {
            images = new String[] {
                    "./img/character/herry_back.png",
            };
        }else if (keyCode == KeyEvent.VK_DOWN) {
            images = new String[] {
                    "./img/character/herry_front_walkLeftleg.png",
                    "./img/character/herry_front_walkRightleg.png"
            };
        } else {
            return; // 다른 키는 처리하지 않음
        }

        active.changeImg(GameStart.boldmote, images[imageIndex]);

        // 이미지 인덱스 갱신
        imageIndex = (imageIndex + 1) % images.length;
    }

    // JFrame 영역 내에 위치하는지 확인하는 메서드
    private boolean isWithinBounds(int x, int y, int width, int height) {
        boolean isOut = false;
        if(x >= 0&& y >= 0&& x + width <= 1200 && y + height <= 750) {
            isOut = true;
            if((x <= 145 && y <= 330 - GameStart.boldmote.getHeight() / 2)){
                return false;
            }
        }
        return isOut;
    }

    private boolean isCollision(int characterX, int characterY, int characterWidth, int characterHeight,
                                int obstacleX, int obstacleY, int obstacleWidth, int obstacleHeight) {
        return characterX < obstacleX + obstacleWidth &&
                characterX + characterWidth > obstacleX &&
                characterY < obstacleY + obstacleHeight &&
                characterY + characterHeight > obstacleY;
    }

    private boolean isCollidingWithObstacle(int characterX, int characterY, Rectangle obstacleBounds) {
        // 장애물의 위치와 크기를 가져옴
        if (GameStart.hoclabel == null) {
            return false;
        }

        // 캐릭터와 장애물의 충돌 여부 확인
        return isCollision(characterX, characterY, GameStart.boldmote.getWidth(), GameStart.boldmote.getHeight(),
                obstacleBounds.x, obstacleBounds.y, obstacleBounds.width, obstacleBounds.height);
    }

    private boolean coversCoordinates(int x, int y, int targetX, int targetY) {
        // 이미지의 좌표 범위를 나타내는 Rectangle 생성
        Rectangle imageBounds = new Rectangle(x, y, GameStart.boldmote.getWidth(), GameStart.boldmote.getHeight());

        // 목표 좌표가 이미지의 범위에 속하는지 확인
        return imageBounds.contains(targetX, targetY);
    }

}
