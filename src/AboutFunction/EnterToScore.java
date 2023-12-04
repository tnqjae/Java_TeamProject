package AboutFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class EnterToScore extends JFrame {
    private ImageIcon henryIcon;
    private ImageIcon boltnutIcon;
    private ImageIcon boltnutIcon2;
    private ImageIcon expecto;
    private ImageIcon backgroundImg;
    private ImageIcon qqq;
    private ImageIcon point;
    private JLabel rectangleLabel;
    private JLabel scoreLabel;
    private JLabel timerLabel;
    private JLabel smallLabel;
    private JLabel background;
    private JPanel rangePanel;
    private JLabel hrangePanel;
    private JLabel henry;
    private JLabel boltnut;
    private JTextField inputTextField;
    private int score;
    private int timeLeft;
    private JLabel quizLabel;


    private static final String[] QUIZ = {"봄바르다 맥시마", "콘프링고", "에바테 스타툼", "엑스 펄소","실렌시오","스투페파이","섹튬셈프라","옵스큐로","퍼넌큘러스"};
    private static final int TIMER_INTERVAL = 10;
    static int hok = 1;
    private static final int SPEED = 12-hok*2;


    public EnterToScore() {
        henryIcon = new ImageIcon("boss/henry.png");
        boltnutIcon = new ImageIcon("boss/boltnut.png");
        expecto = new ImageIcon("boss/expecto.png");
        boltnutIcon2 = new ImageIcon("boss/boltnut2.png");
        backgroundImg = new ImageIcon("boss/background.jpg");
        qqq = new ImageIcon("boss/qqq.png");
        point = new ImageIcon("boss/point.png");
        qqq.setImage(qqq.getImage().getScaledInstance(50, 520, Image.SCALE_DEFAULT));
        point.setImage(point.getImage().getScaledInstance(50,30,Image.SCALE_DEFAULT));
        backgroundImg.setImage(backgroundImg.getImage().getScaledInstance(750, 1000, Image.SCALE_DEFAULT));
        henryIcon.setImage(henryIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        boltnutIcon.setImage(boltnutIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        boltnutIcon2.setImage(boltnutIcon2.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        expecto.setImage(expecto.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
        setTitle("Enter to Score");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 1000);

        initComponents();  // 컴포넌트 초기화 메소드 호출
        setupTimers();      // 타이머 설정 메소드 호출
        setupUI();          // UI 설정 메소드 호출

        setVisible(true);
    }
    private void setRandomQuiz() {
        Random random = new Random();
        int randomIndex = random.nextInt(QUIZ.length);
        quizLabel.setText("Hint: " + QUIZ[randomIndex]);
    }
    private void initComponents() {



        quizLabel = new JLabel();
        quizLabel.setBounds(getWidth() - 200, 10, 190, 20);
        setRandomQuiz();
        quizLabel.setForeground(Color.WHITE);

        background = new JLabel(backgroundImg);
        background.setBounds(0,0,backgroundImg.getIconWidth(),backgroundImg.getIconHeight());

        rectangleLabel = new JLabel(point);
        rectangleLabel.setBounds(getWidth()-100, getHeight()/2, 50, 30);


        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(10, 10, 100, 30);
        scoreLabel.setForeground(Color.WHITE);

        rangePanel = new JPanel();
        rangePanel.setBounds(getWidth()-100, getHeight()/2-50, 50, 60);
        rangePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rangePanel.setBackground(Color.RED);

        hrangePanel = new JLabel(qqq);
        hrangePanel.setBounds(getWidth()-100, getHeight()/2-280, 50, 520);




        henry = new JLabel(henryIcon);
        henry.setBounds(getWidth()/2-100, 30, henryIcon.getIconWidth(), henryIcon.getIconHeight());


        boltnut = new JLabel(boltnutIcon);
        boltnut.setBounds(getWidth()/2-100, getHeight()-300, boltnutIcon.getIconWidth(), boltnutIcon.getIconHeight());

        smallLabel = new JLabel(expecto);
        smallLabel.setBounds(henry.getX(), henry.getY()+250, 150, 150);
        smallLabel.setVisible(false);

        timerLabel = new JLabel("익스펙토 페트로늄까지 : 90 초");
        timerLabel.setBounds(10, 30, 190, 20);
        timerLabel.setForeground(Color.WHITE);

        inputTextField = new JTextField();
        inputTextField.setBounds(getWidth()/2-100, getHeight()-100, 200, 40);
        inputTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkQuiz(); // 엔터 키를 누를 때마다 퀴즈를 체크하는 메소드 호출
                setRandomQuiz();
            }
        });
    }

    private void setupTimers() {
        Timer timer = new Timer(TIMER_INTERVAL, new ActionListener() {
            int direction = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                int newY = rectangleLabel.getY() + direction * SPEED;
                rectangleLabel.setLocation(rectangleLabel.getX(), newY);

                if (newY <= getHeight()/2-280 || newY + rectangleLabel.getHeight() >= getHeight()/2+230) {
                    direction *= -1;
                    score = Math.max(0, score - 10);
                    scoreLabel.setText("Score: " + score);
                }
                if (score >= 1000) {
                    ((Timer) e.getSource()).stop();
                    returnGameResult();  // 1은 게임 종료를 나타냄
                }
            }
        });
        timer.start();

        Timer countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("익스펙토 페트로늄까지 : " + timeLeft + " 초");

                if (timeLeft < 6) {
                    smallLabel.setVisible(true);
//                    SizeThread st = new SizeThread(smallLabel);
//                    st.start();
                }

                if (timeLeft == 0) {
                    ((Timer) e.getSource()).stop();
                    Attack at = new Attack();
                    at.start();

                }

            }
        });
        timeLeft = 60;
        countdownTimer.start();
    }
    private void returnGameResult() {
        JOptionPane.showMessageDialog(EnterToScore.this, getResultMessage());
        System.exit(0);
    }
    private String getResultMessage() {
        if (score < 1000) {
            return "Game Over! Your final score: " + score;
        } else {
            return "Game Over! Your final score exceeded 400. Congratulations!";
        }
    }

    private void setupUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        mainPanel.add(rectangleLabel);
        mainPanel.add(scoreLabel);
        mainPanel.add(rangePanel);
        mainPanel.add(henry);
        mainPanel.add(boltnut);
        mainPanel.add(timerLabel);
        mainPanel.add(inputTextField);
        mainPanel.add(hrangePanel);
        mainPanel.add(smallLabel);
        mainPanel.add(quizLabel);
        mainPanel.add(background);
        add(mainPanel);
    }

    class SizeThread extends Thread {
        private JLabel sl;

        public SizeThread(JLabel sl) {
            this.sl = sl;
        }

        @Override
        public void run() {

            sl.setVisible(true);
            int count = 2;
            while (expecto.getIconWidth() < 150) {
                int size = expecto.getIconWidth() + count;
                Image img = expecto.getImage();
                Image changeImg = img.getScaledInstance(expecto.getIconWidth()+2,expecto.getIconHeight()+2,Image.SCALE_SMOOTH);
                ImageIcon changeIcon = new ImageIcon(changeImg);
                smallLabel.setIcon(changeIcon);
                smallLabel.repaint();
                sl.setBounds(smallLabel.getX()-1,smallLabel.getY(),150,150);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class Attack extends Thread {
        public Attack() {
        }

        @Override
        public void run() {
            while (smallLabel.getY() < boltnut.getY()-100) {
                smallLabel.setLocation(smallLabel.getX(), smallLabel.getY() + 5);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            boltnut.setIcon(boltnutIcon2);
            boltnut.setBounds(getWidth()/2, getHeight()-250, boltnutIcon.getIconWidth(), boltnutIcon.getIconHeight());
            showFinalMessage();
        }
    }

    private void checkQuiz() {
        String userAnswer = inputTextField.getText();

        for (String q : QUIZ) {
            if (q.equalsIgnoreCase(userAnswer)) {
                if (rectangleLabel.getY() >= getHeight()/2-65 && rectangleLabel.getY() <= getHeight()/2-5) {
                    score += 100;
                } else {
                    score = Math.max(0, score - 100);
                }
                scoreLabel.setText("Score: " + score);
                inputTextField.setText("");
            }
        }
        inputTextField.setText("");
    }

    private void showFinalMessage() {
        JOptionPane.showMessageDialog(EnterToScore.this, "Game Over! Your final score: " + score);
        System.exit(0);
    }

    public void setHok(int hok){
        this.hok = hok;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EnterToScore::new);
    }
}
