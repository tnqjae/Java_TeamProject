package AboutFunction;

import MainFrame.GameStart;

import java.awt.*;
import java.util.Map;

public class MapConflict {
    public MapConflict(){

    }
    public boolean isWithinBounds(int x, int y, int width, int height) {
        boolean isOut = false;
        if(x >= 0 && y >= 0 && x + width <= 1200 && y + height <= 750) {
            isOut = true;
            if((x <= 150 && y <= 330 - GameStart.boldmote.getHeight() / 2)|| x <= 140 && y >= 250 || x <= 530 && y > 350
            || x >= 600 && y > 350 || x >= 1000 && y >= 250 || x >= 1000 && y <= 330 - (GameStart.boldmote.getHeight() / 2)){
                return false;
            }
        }
        return isOut;
    }

    public boolean isCollision(int characterX, int characterY, int characterWidth, int characterHeight,
                                int obstacleX, int obstacleY, int obstacleWidth, int obstacleHeight) {
        return characterX < obstacleX + obstacleWidth &&
                characterX + characterWidth > obstacleX &&
                characterY < obstacleY + obstacleHeight &&
                characterY + characterHeight > obstacleY;
    }

    public boolean isCollidingWithObstacle(int characterX, int characterY, Rectangle obstacleBounds) {
        // 장애물의 위치와 크기를 가져옴
        if (GameStart.hoclabel == null) {
            return false;
        }

        // 캐릭터와 장애물의 충돌 여부 확인
        return isCollision(characterX, characterY, GameStart.boldmote.getWidth(), GameStart.boldmote.getHeight(),
                obstacleBounds.x, obstacleBounds.y, obstacleBounds.width, obstacleBounds.height);
    }

    public boolean coversCoordinates(int x, int y, int targetX, int targetY) {
        // 이미지의 좌표 범위를 나타내는 Rectangle 생성
        Rectangle imageBounds = new Rectangle(x, y, GameStart.boldmote.getWidth(), GameStart.boldmote.getHeight());

        // 목표 좌표가 이미지의 범위에 속하는지 확인
        return imageBounds.contains(targetX, targetY);
    }
}
