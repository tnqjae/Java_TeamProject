import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ImageIcon bg;
    ImageIcon titleImage;
    ImageIcon startButton;
    ImageIcon ruleButton;
    public MainFrame() {
        super("Hogwarts Escape");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 이미지 로딩 스레드 시작
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                loadImages(); // 이미지 로드
                addTitle(); // 타이틀 추가
                addStartButton();//시작 버튼 추가
                addRuleButton();//룰 설명 버튼 추가
                // 이미지 로드 후 UI 업데이트
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        addBackground(); // 배경 추가
                        setSize(1200, 750);
                        setVisible(true);
                    }
                });
            }
        });

        thread.start();
    }
    //이미지 로드
    private void loadImages() {
        bg = new ImageIcon("./img/StartBackground.jpeg");
        titleImage = new ImageIcon("./img/title.png");
        startButton = new ImageIcon("./img/Start.png");
        ruleButton = new ImageIcon("./img/Rule.png");
    }
    //백그라운드 이미지와 타이틀 이미지를 패널에 추가하는 과정을 함수로 분리.
    private void addBackground() {
        JLabel background = new JLabel(bg);
        background.setSize(bg.getIconWidth(), bg.getIconHeight());
        background.setLocation(0, 0);
        add(background);
    }

    private void addTitle() {
        JLabel title = new JLabel(titleImage);
        title.setSize(titleImage.getIconWidth(), titleImage.getIconHeight());
        title.setLocation(420, 80);
        add(title);
    }

    private void addStartButton(){
        JLabel stbutton = new JLabel(startButton);
        int newWidth = 260; // 원하는 너비로 변경하세요
        int newHeight = 80; // 원하는 높이로 변경하세요

        stbutton.setIcon(new ImageIcon(startButton.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT)));

        stbutton.setSize(newWidth, newHeight);
        stbutton.setLocation(80, 350);
        add(stbutton);
    }

    private void addRuleButton(){
        JLabel rulebutton = new JLabel(ruleButton);
        int newWidth = 260; // 원하는 너비로 변경하세요
        int newHeight = 80; // 원하는 높이로 변경하세요

        rulebutton.setIcon(new ImageIcon(ruleButton.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT)));

        rulebutton.setSize(newWidth, newHeight);
        rulebutton.setLocation(80, 380);
        add(rulebutton);
    }
}
