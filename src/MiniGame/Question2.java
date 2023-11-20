import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question2 extends JFrame {
    private JLabel imageLabel;
    private JLabel questionLabel;
    private ButtonGroup optionGroup;
    private JRadioButton option1, option2, option3, option4;
    private JButton checkButton, hintButton;

    public Question2() {
        setTitle("Question 2");
        setSize(500, 500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        setVisible(true);
    }

    private void setupUI() {
        questionLabel = new JLabel(" 다음 그림을 보고 ?에 들어갈 숫자가 순서대로 들어간 번호를 골라라.");

        ImageIcon imageIcon = new ImageIcon("/Users/kimtaehee/Desktop/김태희/2-2/객체지향/Q2.png");
        Image image = imageIcon.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(image);

        imageLabel = new JLabel(imageIcon);

        option1 = new JRadioButton("6, 12, 7.5, 2");
        option2 = new JRadioButton("6, 12, 7.5, 3");
        option3 = new JRadioButton("12.5, 12, 7.5, 2");
        option4 = new JRadioButton("12.5, 12, 7.5, 3");

        optionGroup = new ButtonGroup();
        optionGroup.add(option1);
        optionGroup.add(option2);
        optionGroup.add(option3);
        optionGroup.add(option4);

        checkButton = new JButton("정답 확인");
        hintButton = new JButton("힌트");

        setLayout(new BorderLayout());

        JPanel imagePanel = new JPanel(new FlowLayout());
        imagePanel.add(questionLabel);
        imagePanel.add(imageLabel);
        add(imagePanel, BorderLayout.NORTH);

        JPanel radioPanel = new JPanel(new GridLayout(2, 2));
        radioPanel.add(option1);
        radioPanel.add(option2);
        radioPanel.add(option3);
        radioPanel.add(option4);
        add(radioPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(checkButton);
        bottomPanel.add(hintButton);
        add(bottomPanel, BorderLayout.SOUTH);

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHint();
            }
        });
    }

    private void checkAnswer() {
        if (option1.isSelected()) {
            JOptionPane.showMessageDialog(this, "Correct!");
        } else {
            JOptionPane.showMessageDialog(this, "Wrong, Try Again.");
        }
    }

    private void showHint() {
        JOptionPane.showMessageDialog(this, "힌트: 시계");
    }

    public static void main(String[] args) {
        new Question2();
    }
}
