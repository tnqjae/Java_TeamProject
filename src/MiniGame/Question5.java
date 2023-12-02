import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question5 extends JFrame {
    private JTextArea questionTextArea;
    private JLabel instructionLabel;
    private JLabel answerLabel;
    private JTextField answerField;

    private JButton hintButton;
    private JButton checkButton;
    private JButton retryButton;

    public Question5() {
        setTitle("Question 5");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        setVisible(true);
    }

    private void setupUI() {
        questionTextArea = new JTextArea("305호 => 561\n303호 => 3101\n215호 => ?");
        instructionLabel = new JLabel("다음 방의 비밀번호를 맞추시오(방 호수와 관련 있음)");
        answerLabel = new JLabel("정답 : ");
        answerField = new JTextField(20);

        hintButton = new JButton("힌트");
        checkButton = new JButton("정답 확인");
        retryButton = new JButton("다시 풀기");
        retryButton.setEnabled(false);

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));
        topPanel.add(instructionLabel);
        topPanel.add(questionTextArea);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));
        centerPanel.add(new JLabel("")); // 빈 레이블
        centerPanel.add(new JLabel("")); // 빈 레이블
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 1));
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new FlowLayout());
        answerPanel.add(answerLabel);
        answerPanel.add(answerField);
        bottomPanel.add(answerPanel);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(hintButton);
        buttonPanel.add(checkButton);
        buttonPanel.add(retryButton);
        bottomPanel.add(buttonPanel);
        add(bottomPanel, BorderLayout.SOUTH);

        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHint();
            }
        });

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
    }

    private void checkAnswer() {
        // 입력값이 비어있는지 확인
        if (answerField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "값을 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String userAnswer = answerField.getText().trim();
        check(userAnswer);
    }

    private void check(String userAnswer) {
        String correctAnswer = "375";

        if (userAnswer.equals(correctAnswer)) {
            JOptionPane.showMessageDialog(this, "Correct!", "정답", JOptionPane.INFORMATION_MESSAGE);
            answerLabel.setText("정답 : " + userAnswer);
            checkButton.setEnabled(false);
            retryButton.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Wrong, Try Again", "오답", JOptionPane.ERROR_MESSAGE);
            resetFields();
        }
    }

    private void resetFields() {
        answerField.setText("");
        answerLabel.setText("정답 : ");
        checkButton.setEnabled(true);
        retryButton.setEnabled(false);
    }

    private void showHint() {
        JOptionPane.showMessageDialog(this, "힌트: 소인수분해", "힌트", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new Question5();
    }
}
