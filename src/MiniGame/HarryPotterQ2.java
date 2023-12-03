package MiniGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HarryPotterQ2 extends JFrame {
    private JTextArea questionArea;
    private JTextField spell1Field;
    private JTextField spell2Field;
    private JTextField spell3Field;
    private JButton checkButton;

    private boolean success = false;

    public HarryPotterQ2() {
        setTitle("해리포터 마법 문제");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        setVisible(true);
    }

    private void setupUI() {
        // 레이아웃 설정
        setLayout(new BorderLayout());

        // 문제 지문 추가
        questionArea = new JTextArea("해리포터 속 용서 받을 수 없는 3대 마법을 알아맞혀보세요.");
        questionArea.setEditable(false);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);

        // 텍스트 필드 초기화
        spell1Field = new JTextField();
        spell1Field.setColumns(7); // 컬럼 수 조절

        spell2Field = new JTextField();
        spell2Field.setColumns(7); // 컬럼 수 조절

        spell3Field = new JTextField();
        spell3Field.setColumns(7); // 컬럼 수 조절

        // 정답 확인을 위한 버튼 초기화
        checkButton = new JButton("정답 확인");

        // 버튼 클릭 시 이벤트 처리
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        // 패널 초기화
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 문제 지문 추가
        mainPanel.add(questionArea, BorderLayout.NORTH);

        // 입력 필드 및 버튼 추가
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("1번:"));
        inputPanel.add(spell1Field);
        inputPanel.add(new JLabel("2번:"));
        inputPanel.add(spell2Field);
        inputPanel.add(new JLabel("3번:"));
        inputPanel.add(spell3Field);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(checkButton, BorderLayout.SOUTH);

        // 프레임에 패널 추가
        add(mainPanel, BorderLayout.CENTER);
    }

    // 정답 확인 메서드
    private void checkAnswer() {
        String spell1 = spell1Field.getText().trim();
        String spell2 = spell2Field.getText().trim();
        String spell3 = spell3Field.getText().trim();

        // 정답 여부 확인
        if (spell1.equalsIgnoreCase("아브라케타브라") &&
                spell2.equalsIgnoreCase("크루시오") &&
                spell3.equalsIgnoreCase("임페리오")) {
            JOptionPane.showMessageDialog(this, "Correct!");
            SelectMiniGame.success = true;
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Wrong, Try Again.");
            SelectMiniGame.success = false;
            dispose();
        }
    }

    public static void main(String[] args) {
        new HarryPotterQ2();
    }
}
