package minigamefile;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class minigame05 { ///넌센스 퀴즈
    private Map<String, String> questions;
    private int score;

    public minigame05() {
        questions = new HashMap<>();
        // 무작위 넌센스 질문과 정답을 추가합니다.
        questions.put("질문 1", "정답 1");  ///질문과 정답 추가해야함.
        questions.put("질문 2", "정답 2");
        questions.put("질문 3", "정답 3");

        score = 0;
    }

    public void startGame() {
        System.out.println("=== 넌센스 퀴즈 게임 시작 ===");

        for (Map.Entry<String, String> entry : questions.entrySet()) {
            String question = entry.getKey();
            String correctAnswer = entry.getValue();

            System.out.println("\n" + question);
            System.out.print("정답을 입력하세요: ");

            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.nextLine();

            if (checkAnswer(userAnswer, correctAnswer)) {
                System.out.println("정답입니다! +1점 획득\n");
                score++;
            } else {
                System.out.println("틀렸습니다. 정답은 " + correctAnswer + "입니다.\n");
            }
        }

        System.out.println("=== 게임 종료 ===");
        System.out.println("최종 점수: " + score + "점");
    }

    private boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer.trim().equalsIgnoreCase(correctAnswer.trim());
    }

    public static void main(String[] args) {
        minigame05 game = new minigame05();
        game.startGame();
    }
}
