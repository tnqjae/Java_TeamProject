package MiniGame;

import java.util.Scanner;
public class minigame01 { ////숫자놀이
    public static void main(String[] args) {
        int number;
        int guess;
        number = (int) (Math.random()* 100);

        do{
            System.out.println("1~100사이의 수를 입력하세요.");
            Scanner sc = new Scanner(System.in);
            guess = sc.nextInt();

            if(number>guess){
                System.out.println("UP");
            }
            if(number<guess){
                System.out.println("DOWN");
            }
        } while(number!=guess);
        System.out.println("정답!");
    }
}