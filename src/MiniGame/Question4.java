package MiniGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question4 extends JFrame {
    private JLabel[] questionLabels;
    private JLabel answerLabel;
    private JTextField answerField;
    private JLabel instructionLabel;

    private JButton calculateButton;
    private JButton retryButton;

    public Question4() {
        setTitle("Question 4");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        setVisible(true);
    }

    private void setupUI() {
        questionLabels = new JLabel[4];
        questionLabels[0] = new JLabel("示   不    小  →   ?");
        questionLabels[1] = new JLabel("日   不    口  →   ?");
        questionLabels[2] = new JLabel("分   不    刀  →   ?");
        questionLabels[3] = new JLabel("罪   不    非  →   ?");

        instructionLabel = new JLabel(" ? 에 들어갈 숫자를 모두 곱한 값을 구해라");
        answerLabel = new JLabel("정답 : ");

        answerField = new JTextField();

        calculateButton = new JButton("계산하기");


        setLayout(new GridLayout(9, 2));

        add(instructionLabel);
        add(new JLabel(""));
        
        for (int i = 0; i < questionLabels.length; i++) {
            add(questionLabels[i]);
            add(new JLabel(""));
        }

        add(answerLabel);
        add(answerField);
        add(new JLabel(""));
        add(new JLabel(""));
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateProduct();
            }
        });

    }

    private void calculateProduct() {
        // 입력값이 비어있는지 확인
        if (answerField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "값을 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int userAnswer = Integer.parseInt(answerField.getText());
        checkAnswer(userAnswer);
    }

    private void checkAnswer(int userAnswer) {
        int correctAnswer = 2 * 1 * 8 * 4;

        if (userAnswer == correctAnswer) {
            JOptionPane.showMessageDialog(this, "Correct!", "정답", JOptionPane.INFORMATION_MESSAGE);
            answerLabel.setText("정답 : " + userAnswer);
            calculateButton.setEnabled(false);
            SelectMiniGame.success = true;
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Wrong, Try Again", "오답", JOptionPane.ERROR_MESSAGE);
            resetFields();
            SelectMiniGame.success = false;
            dispose();
        }
    }

    private void resetFields() {
        answerField.setText("");
        answerLabel.setText("정답 : ");
        calculateButton.setEnabled(true);
        retryButton.setEnabled(false);
    }

    public static void main(String[] args) {
        new Question4();
    }
}
