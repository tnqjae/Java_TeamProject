package MiniGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class minigame03 {
    private static long startTime;
    private static boolean sc;

    public minigame03(){
        JFrame frame = new JFrame("Time Attack");
        JButton startButton = new JButton("게임 시작");
        JLabel resultLabel = new JLabel();

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.add(Box.createVerticalGlue()); // 상단 여백
        frame.add(startButton);
        frame.add(Box.createVerticalGlue()); // 버튼 위 여백
        frame.add(resultLabel);
        frame.add(Box.createVerticalGlue()); // 결과 레이블 아래 여백

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // 화면 중앙에 표시
        frame.setVisible(true);
    }

    private static void startGame() {
        JFrame gameFrame = new JFrame("게임");
        JButton enterButton = new JButton("Enter");
        JLabel infoLabel = new JLabel("10초에 맞춰 <Enter> 버튼을 누르세요 (오차 범위: +-1초 허용)");

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkTime();
                gameFrame.dispose();
            }
        });

        gameFrame.setLayout(new BoxLayout(gameFrame.getContentPane(), BoxLayout.Y_AXIS));

        gameFrame.add(Box.createVerticalGlue()); // 상단 여백
        gameFrame.add(infoLabel);
        gameFrame.add(Box.createVerticalGlue()); // 레이블 위 여백
        gameFrame.add(enterButton);
        gameFrame.add(Box.createVerticalGlue()); // 버튼 아래 여백

        gameFrame.setSize(300, 200);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null); // 화면 중앙에 표시
        gameFrame.setVisible(true);

        startTime = System.currentTimeMillis();
    }

    private static void checkTime() {
        long endTime = System.currentTimeMillis();
        double elapsedTime = (double) ((endTime - startTime) * 0.001);

        if (elapsedTime >= 9 && elapsedTime <= 11) {
            JOptionPane.showMessageDialog(null, "성공!");
            sc = true;
        } else {
            JOptionPane.showMessageDialog(null, "실패!");
            sc = false;
        }
    }

    public static boolean getSc(){
        return sc;
    }
}
