package MiniGame;
import java.util.Random;
import java.util.Scanner;

public class minigame06 { /// 벽돌쌓기 게임 방해요소가 있긴하나 금방해결됨 난이도가 없음.
    private static final int MAX_HEIGHT = 10;
    private int currentHeight;
    private boolean obstacleEncountered;

    public minigame06() {
        currentHeight = 0;
        obstacleEncountered = false;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== 방해요소가 포함된 벽돌 쌓기 게임 시작 ===");

        while (currentHeight < MAX_HEIGHT) {
            System.out.println("현재 높이: " + currentHeight);

            // 20%의 확률로 방해요소 발생
            if (random.nextInt(100) < 20) {
                obstacleEncountered = true;
                System.out.println("방해요소가 발생했습니다!");
            }

            if (!obstacleEncountered) {
                System.out.print("벽돌을 한 층 올리려면 Enter 키를 누르세요...");
                scanner.nextLine();

                // 벽돌을 한 층 쌓음
                currentHeight++;
            } else {
                System.out.print("방해요소를 해결하려면 Enter 키를 누르세요...");
                scanner.nextLine();

                // 방해요소를 해결하고 높이 증가
                obstacleEncountered = false;
                currentHeight++;
            }

            // 높이가 최대 높이에 도달하면 게임 종료
            if (currentHeight == MAX_HEIGHT) {
                System.out.println("축하합니다! 최대 높이에 도달했습니다.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        minigame06 game = new minigame06();
        game.playGame();
    }
}
