package minigamefile;
import java.util.Scanner;
import java.util.Random;
    public class minigame02 {  ////행맨게임
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] words = { "java" + "count", "school", "book", "student", "programmer" };
            int num = 0;
            int index = (new Random()).nextInt(words.length);
            boolean b = true;
            int count = 1;

            String solution = words[index];
            StringBuffer answer = new StringBuffer(solution.length());
            StringBuffer display = new StringBuffer(solution.length());

            for (int i = 0; i < solution.length(); i++) {
                display.append("_");

            }
            System.out.println("답은: " + solution);
            System.out.println("행맨 게임에 오신 것을 환영합니다");
            System.out.println("현재 상태: " + display);

            System.out.println("글자를 추측하세요: ");
            char c = sc.next().charAt(0);
            while (b) {
                if (c == solution.charAt(num)) {

                    answer.insert(num, c);
                    display.deleteCharAt(num);
                    display.insert(num, c);
                    num++;

                    System.out.println("계속 입력하세요: ");
                    c = sc.next().charAt(0);

                    if (c != solution.charAt(num)) {
                        System.out.println("잘못 입력하였습니다. 전에 글자부터 다시 입력하세요");
                        num--;
                        answer.deleteCharAt(num);
                        c = sc.next().charAt(0);
                        continue;
                    }

                    if (answer.toString().equals(solution)) {
                        System.out.println("축하합니다. 클리어입니다.");
                        b = false;
                    }

                } else if (c != solution.charAt(num)) {
                    System.out.println("처음부터 잘못 입력하였습니다. 다시 입력하세요");
                    c = sc.next().charAt(0);
                    continue;
                }
            }

        }
    }
