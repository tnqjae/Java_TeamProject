package MiniGame;

import AboutFunction.AboutMapfunction;

import java.util.Random;

public class SelectMiniGame {
    public static boolean success;

    private static int locate = 0;

    public static void setLocate(int locate) {
        SelectMiniGame.locate = locate;
    }

    public static int getLocate(){
        return locate;
    }
    public SelectMiniGame() {
    }

    public static void setSuccess(boolean success) {
        AboutMapfunction.changeState(AboutMapfunction.getCurrentLocationX(), AboutMapfunction.getCurrentLocationY(), getLocate(), success);
    }

    public void selectRandomMiniGame() {
        success = false;
        // 미니게임들을 담을 배열 생성
        Random random = new Random(System.currentTimeMillis());
        int randomIndex = random.nextInt(9);
        switch (randomIndex) {
            case 0:
                new minigame01();
                break;
            case 1:
                new minigame03();
                break;
            case 2:
                new Question1();
                break;
            case 3:
                new Question2();
                break;
            case 4:
                new Question3();
                break;
            case 5:
                new Question4();
                break;
            case 6:
                new Question5();
                break;
            case 7:
                new HarryPotterQ1();
                break;
            case 8:
                new HarryPotterQ2();
                break;
            default:
                // 처리하지 않은 다른 경우에 대한 기본 동작 (선택사항)
                break;
        }
    }

    public void Boss(){

    }
}
