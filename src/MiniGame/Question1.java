package MiniGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question1 extends JFrame {
    private JLabel imageLabel; // 이미지를 표시할 레이블
    private JTextField passwordField; // 사용자가 비밀번호를 입력할 텍스트 필드
    private JButton checkButton; // 정답 확인을 위한 버튼
    private JButton hintButton; // 힌트 표시를 위한 버튼
    private JLabel questionLabel;
    private JFrame hintFrame; // 힌트를 표시할 프레임

    private boolean success = false;
    public Question1() {
        setTitle("Question 1");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        setupHintFrame();
        setVisible(true);
    }

    private void setupUI() {
        questionLabel = new JLabel(" 다음 그림을 보고 노트북의 비밀번호를 입력하시오.");

        // 이미지를 표시할 레이블 초기화
        ImageIcon imageIcon = new ImageIcon("./img/miniGameImg/Q1.png");
        Image image = imageIcon.getImage().getScaledInstance(500, 120, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel = new JLabel(imageIcon);

        // 비밀번호를 입력할 텍스트 필드 초기화
        passwordField = new JTextField();
        passwordField.setColumns(20);

        // 정답 확인을 위한 버튼 초기화
        checkButton = new JButton("정답 확인");

        // 힌트 표시를 위한 버튼 초기화
        hintButton = new JButton("힌트");

        // 레이아웃 설정
        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);

        // 상단 패널에 문제 지문과 힌트 버튼 추가
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(questionLabel, BorderLayout.WEST);
        topPanel.add(hintButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // 하단 패널에 구성 요소 추가
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(new JLabel("비밀번호를 입력하시오 : "));
        bottomPanel.add(passwordField);
        bottomPanel.add(checkButton);

        // 하단 패널을 프레임에 추가
        add(bottomPanel, BorderLayout.SOUTH);

        // 버튼 클릭 시 이벤트 처리
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPassword();
            }
        });

        // 힌트 버튼 클릭 시 이벤트 처리
        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHint();
            }
        });
    }

    private void setupHintFrame() {
        hintFrame = new JFrame("힌트");
        hintFrame.setSize(300, 100);
        hintFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        hintFrame.setLocationRelativeTo(null);

        // 힌트를 표시할 레이블 추가
        JLabel hintLabel = new JLabel("키보드 숫자키");
        hintFrame.add(hintLabel);
    }

    // 정답 확인 메서드
    private void checkPassword() {
        String userPassword = passwordField.getText().trim();

        // 정답 여부에 따라 메시지 표시
        if (userPassword.equals("5269")) {
            JOptionPane.showMessageDialog(this, "Correct!");
            dispose();
        } else {
            int option = JOptionPane.showConfirmDialog(this, "Wrong, Try Again", "Incorrect", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // 사용자가 다시 시도하려면 텍스트 필드를 초기화
                passwordField.setText("");
            }
        }
    }

    // 힌트 표시 메서드
    private void showHint() {
        hintFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Question1();
    }
}
