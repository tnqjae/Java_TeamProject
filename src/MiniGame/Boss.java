package MiniGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Boss extends JFrame {
    private JLabel rectangleLabel;
    private JLabel scoreLabel;
    private JLabel timerLabel;
    private JLabel smallLabel; // 작은 라벨 추가
    private JPanel rangePanel;
    private JPanel hrangePanel;
    private JLabel northLabelPanel;
    private JLabel southLabelPanel;
    private JTextField inputTextField; // 추가된 부분
    private int score;
    private int timeLeft; // 제한 시간 (초)

    private String[] quiz = {"a", "b", "c", "d"}; // 퀴즈 배열 추가

    public Boss() {
        setTitle("Enter to Score");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        rectangleLabel = new JLabel();
        rectangleLabel.setBounds(500, 300, 50, 30);
        rectangleLabel.setBackground(Color.BLACK);
        rectangleLabel.setOpaque(true);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(10, 10, 100, 30);

        rangePanel = new JPanel();
        rangePanel.setBounds(500, 250, 50, 60);
        rangePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rangePanel.setBackground(Color.RED);

        hrangePanel = new JPanel();
        hrangePanel.setBounds(500, 20, 50, 520);
        hrangePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        smallLabel = new JLabel();
        smallLabel.setBounds(300, 100, 10, 10);
        smallLabel.setBackground(Color.BLACK);

        mainPanel.add(smallLabel);

        northLabelPanel = new JLabel();
        northLabelPanel.setBounds(275, 30, 50, 50);
        northLabelPanel.setBackground(Color.BLACK);
        northLabelPanel.setOpaque(true);

        southLabelPanel = new JLabel();
        southLabelPanel.setBounds(275, 450, 50, 50);
        southLabelPanel.setBackground(Color.BLACK);
        southLabelPanel.setOpaque(true);
        timerLabel = new JLabel("익스펙토 페트로늄까지 : 90 초");
        timerLabel.setBounds(10, 30, 190, 20);

        inputTextField = new JTextField();
        inputTextField.setBounds(200, 520, 200, 40);
        inputTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkQuiz(); // 엔터 키를 누를 때마다 퀴즈를 체크하는 메소드 호출
            }
        });

        rectangleLabel.setFocusable(true);

        mainPanel.add(rectangleLabel);
        mainPanel.add(scoreLabel);
        mainPanel.add(rangePanel);
        mainPanel.add(hrangePanel);
        mainPanel.add(northLabelPanel);
        mainPanel.add(southLabelPanel);
        mainPanel.add(timerLabel);
        mainPanel.add(inputTextField);

        Timer timer = new Timer(10, new ActionListener() {
            int direction = 1; // 1: 위로, -1: 아래로
            int speed = 9; // 속도 수정

            @Override
            public void actionPerformed(ActionEvent e) {
                int newY = rectangleLabel.getY() + direction * speed;
                rectangleLabel.setLocation(rectangleLabel.getX(), newY);

                if (newY <= 24 || newY + rectangleLabel.getHeight() >= 535) {
                    direction *= -1;
                }
            }
        });
        timer.start();
        Timer countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("익스펙토 페트로늄까지 : " + timeLeft + " 초");
                if (timeLeft < 88){
                    smallLabel.setOpaque(true);
                    SizeThread st = new SizeThread(smallLabel);
                    st.start();
                }
                if (timeLeft == 1){

                }
                if (timeLeft < 0) {
                    ((Timer) e.getSource()).stop();
                    showFinalMessage();
                }
            }
        });
        timeLeft = 90;
        countdownTimer.start();

        add(mainPanel);
        setVisible(true);

    }
    class SizeThread extends Thread{
        private JLabel sl;
        public SizeThread(JLabel sl){
            this.sl = sl;
        }

        @Override
        public void run() {
            int count=2;
            while(smallLabel.getWidth()<150){
                int size = smallLabel.getWidth() + count;
                smallLabel.setSize(size, size);
                smallLabel.setLocation(smallLabel.getX()-1,smallLabel.getY());
//                if (smallLabel.getWidth()>145){
//                    while (smallLabel.getY() < southLabelPanel.getY()){
//                        smallLabel.setLocation(northLabelPanel.getX(), northLabelPanel.getY()+1);
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
    private void checkQuiz() {
        String userAnswer = inputTextField.getText();
        for (String q : quiz) {
            if (q.equalsIgnoreCase(userAnswer)) {
                if (rectangleLabel.getY() >= 250 && rectangleLabel.getY() <= 280) {
                    score += 100;
                } else {
                    score = Math.max(0, score - 100);
                }
                scoreLabel.setText("Score: " + score);
                inputTextField.setText("");
            }
        }
    }
    private void showFinalMessage() {
        JOptionPane.showMessageDialog(Boss.this, "Game Over! Your final score: " + score);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Boss());
    }
}