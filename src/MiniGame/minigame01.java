package MiniGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class minigame01 extends JFrame {
    private int number;
    private JTextField guessField;
    private JTextArea resultArea;
    private int remainingAttempts; // 남은 시도 횟수

    public minigame01() {
        setTitle("숫자놀이 게임");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        number = (int) (Math.random() * 100);
        remainingAttempts = 5; // 초기 시도 횟수 설정

        setupUI();

        setVisible(true);
    }

    private void setupUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel instructionLabel = new JLabel("1~100 사이의 수를 입력하세요. 남은 시도 횟수: " + remainingAttempts);
        guessField = new JTextField();
        JButton submitButton = new JButton("제출");

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        panel.add(instructionLabel);
        panel.add(guessField);
        panel.add(submitButton);

        add(panel, BorderLayout.NORTH);
        add(resultArea, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
    }

    private void checkGuess() {
        if (remainingAttempts > 0) {
            String guessText = guessField.getText();
            int guess;

            try {
                guess = Integer.parseInt(guessText);

                if (guess < 1 || guess > 100) {
                    JOptionPane.showMessageDialog(this, "1에서 100 사이의 수를 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (number > guess) {
                    resultArea.append(guess + " (UP)\n");
                } else if (number < guess) {
                    resultArea.append(guess + " (DOWN)\n");
                } else {
                    resultArea.append("정답!\n");
                    guessField.setEnabled(false); // 정답을 맞추면 입력 필드 비활성화
                    JOptionPane.showMessageDialog(this, "축하합니다! 정답을 맞추셨습니다.");
                    SelectMiniGame.success = true;
                }

                remainingAttempts--; // 시도 횟수 감소
                updateInstructionLabel(); // 남은 시도 횟수 업데이트

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "올바른 숫자를 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            }
            guessField.setText(""); // 입력 필드 초기화
            guessField.requestFocus(); // 입력 필드에 포커스 설정
        } else {
            JOptionPane.showMessageDialog(this, "남은 시도 횟수가 없습니다. 게임이 종료되었습니다." +
                    "\n창을 닫습니다.");
            dispose();
            guessField.setEnabled(false);
            SelectMiniGame.success = false;
        }
    }

    private void updateInstructionLabel() {
        // 남은 시도 횟수를 포함하여 지시 메시지 업데이트
        JLabel instructionLabel = (JLabel) ((JPanel) getContentPane().getComponent(0)).getComponent(0);
        instructionLabel.setText("1~100 사이의 수를 입력하세요. 남은 시도 횟수: " + remainingAttempts);
    }
}
