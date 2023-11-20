import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HarryPotterQ1 extends JFrame {
    private JLabel imageLabel; // 이미지를 표시할 레이블
    private JTextField answerField; // 사용자가 답을 입력할 텍스트 필드
    private JButton checkButton; // 정답 확인을 위한 버튼
    private JLabel questionLabel;

    public HarryPotterQ1() {
        setTitle("Question 1");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        setVisible(true);
    }

    private void setupUI() {
    	questionLabel = new JLabel("다음 그림이 상징하는 3가지 성물에 대해 작성하시오.");
    	
        // 이미지를 표시할 레이블 초기화
        imageLabel = new JLabel(new ImageIcon("/Users/kimtaehee/Desktop/김태희/2-2/객체지향/harrypotter.png"));

        // 답을 입력할 텍스트 필드 초기화
        answerField = new JTextField();
        answerField.setColumns(20);

        
        // 정답 확인을 위한 버튼 초기화
        checkButton = new JButton("정답 확인");

        // 레이아웃 설정
        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);

       JPanel topPanel = new JPanel();
       topPanel.add(questionLabel);
       add(topPanel, BorderLayout.NORTH);
       
        // 하단 패널에 구성 요소 추가
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(new JLabel("정답을 입력하시오 : "));
        bottomPanel.add(answerField);
        bottomPanel.add(checkButton);

        // 하단 패널을 프레임에 추가
        add(bottomPanel, BorderLayout.SOUTH);

        // 버튼 클릭 시 이벤트 처리
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
    }

    // 정답 확인 메서드
    private void checkAnswer() {
        String userAnswer = answerField.getText().trim().toLowerCase();
        String[] correctAnswers = {"투명망토", "딱총나무 지팡이", "부활의 돌"};
        
        
        // 사용자 입력이 정답들을 모두 포함하는지 확인
        boolean isCorrect = true;
        for (String correctAnswer : correctAnswers) {
            if (userAnswer.contains(correctAnswer.toLowerCase())) {
                isCorrect = false;
                break;
            }
        }

        // 정답 여부에 따라 메시지 표시
        if (isCorrect) {
            JOptionPane.showMessageDialog(this, "Correct!");
        } else {
            int option = JOptionPane.showConfirmDialog(this, "Wrong, Try Again", "Incorrect", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION)
                // 사용자가 다시 시도하려면 텍스트 필드를 초기화
                answerField.setText("");
            } 
    }

    public static void main(String[] args) {
        new HarryPotterQ1();
    }
}