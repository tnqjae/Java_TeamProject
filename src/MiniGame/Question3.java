import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question3 extends JFrame {
    private JButton checkButton;
    private JCheckBox[] answerCheckBoxes;
    private JLabel questionLabel;

    public Question3() {
        setTitle("동물 수 세기");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        setVisible(true);
    }

    private void setupUI() {
    	questionLabel = new JLabel("다음 표에서 알파벳을 조합하여 동물이 몇마리인지 찾아라.");
        char[][] table = {
                {'C', 'D', 'Z', 'E', 'B', 'R', 'A'},
                {'L', 'H', 'P', 'A', 'F', 'S', 'N'},
                {'E', 'B', 'I', 'R', 'D', 'N', 'T'},
                {'Q', 'E', 'G', 'C', 'O', 'A', 'L'},
                {'C', 'A', 'T', 'D', 'K', 'K', 'O'},
                {'H', 'R', 'M', 'P', 'O', 'E', 'T'},
                {'P', 'A', 'N', 'D', 'A', 'G', 'N'}
        };

        // 13마리, 12마리, 9마리, 10마리 동물 수에 대한 정답
        final int[] correctAnswers = {13, 12, 9, 10};

        // 레이아웃 설정
        setLayout(new BorderLayout());
        
        //상단 패널 설정
        JPanel topPanel = new JPanel();
        topPanel.add(questionLabel);
        add(topPanel, BorderLayout.NORTH);

        // 표를 그릴 패널 생성
        JPanel tablePanel = new JPanel(new GridLayout(7, 7));

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                JLabel label = new JLabel(String.valueOf(table[i][j]), SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // 표의 셀을 선으로 나누기
                tablePanel.add(label);
            }
        }

        // 표의 크기를 250x250으로 설정
        tablePanel.setPreferredSize(new Dimension(250, 250));

        // 체크박스 초기화
        answerCheckBoxes = new JCheckBox[4];
        for (int i = 0; i < 4; i++) {
            answerCheckBoxes[i] = new JCheckBox((i + 1) + ". " + correctAnswers[i] + "마리");
            answerCheckBoxes[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 체크된 체크박스가 있으면 나머지 체크박스들의 선택 해제
                    for (int j = 0; j < 4; j++) {
                        if (answerCheckBoxes[j] != e.getSource()) {
                            answerCheckBoxes[j].setSelected(false);
                        }
                    }
                }
            });
        }

        // 정답 확인을 위한 버튼 초기화
        checkButton = new JButton("정답 확인");

        // 버튼 클릭 시 이벤트 처리
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(correctAnswers);
            }
        });

        // 하단 패널에 정답 확인 버튼과 정답 체크박스 추가
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(checkButton);
        for (int i = 0; i < 4; i++) {
            bottomPanel.add(answerCheckBoxes[i]);
        }

        // 프레임에 패널들 추가
        add(tablePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // 정답 확인 메서드 수정
    private void checkAnswer(int[] correctAnswers) {
        int userAnswer = -1;
        for (int i = 0; i < 4; i++) {
            if (answerCheckBoxes[i].isSelected()) {
                userAnswer = i;
                break;
            }
        }

        // 정답 여부에 따라 메시지 표시
        if (userAnswer != -1 && correctAnswers[userAnswer] == 10) {
            JOptionPane.showMessageDialog(this, "Correct!");
        } else {
            JOptionPane.showMessageDialog(this, "Wrong, Try Again.");
        }
    }

    public static void main(String[] args) {
        new Question3();
    }
}
