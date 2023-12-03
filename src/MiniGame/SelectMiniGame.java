package MiniGame;

import javax.swing.*;
import java.util.Random;

public class SelectMiniGame {
    public static boolean success;

    public SelectMiniGame() {
    }


    public void selectRandomMiniGame() {
        success = false;
        // 미니게임들을 담을 배열 생성
        Random random = new Random(System.currentTimeMillis());
        int randomIndex = random.nextInt(12);
        switch (randomIndex) {
            case 0:
                new minigame01();
                break;
            case 1:
                new minigame02();
                break;
            case 2:
                new minigame03();
                break;
            case 3:
                new minigame04();
                break;
            case 4:
                new minigame05();
                break;
            case 5:
                new Question1();
                break;
            case 6:
                new Question2();
                break;
            case 7:
                new Question3();
                break;
            case 8:
                new Question4();
                break;
            case 9:
                new Question5();
                break;
            case 10:
                new HarryPotterQ1();
                break;
            case 11:
                new HarryPotterQ2();
                break;
            default:
                // 처리하지 않은 다른 경우에 대한 기본 동작 (선택사항)
                break;
        }
    }
}
