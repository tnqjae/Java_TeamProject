package MiniGame;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class minigame05 { ///넌센스 퀴즈
    private Map<String, String> questions;
    private int score;

    public minigame05() {
        questions = new HashMap<>();
        // 무작위 넌센스 질문과 정답을 추가합니다.
        questions.put("질문 : 한 가지 일에 지나치게 몰두하던 사람이 갑자기 극도의 신체적,정신 피로로 무기력증과 자기현상의 빠지는 이 현상은?", "정답 : 번아웃증후군");  ///질문과 정답 추가해야함.
        questions.put("질문 : 태양에서 방출 된 전기를 띤 입자가 지구로 들어오면서 지구대기 입자들과 충돌하여 빛을 내는 현상은?", "정답 : 오로라");
        questions.put("질문 : 신라의 제 30대으로 죽어서도 동해의 용이되어 외적을 물리치겠다. 라고 말하며 사후 유골을 동해 앞바다에 뿌려달라고 말했던 이 왕의 이름은?", "정답 : 문무왕");
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
        minigame04 game = new minigame04();
        game.startGame();
    }
}
