import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ImageIcon bg;
    ImageIcon titleImage;

    public MainFrame() {
        super("Hogwarts Escape");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 이미지 로딩 스레드 시작
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                loadImages(); // 이미지 로드

                // 이미지 로드 후 UI 업데이트
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        addBackground(); // 배경 추가
                        addTitle(); // 타이틀 추가
                        setSize(1200, 750);
                        setVisible(true);
                    }
                });
            }
        });
        thread.start();
    }

    private void loadImages() {
        // 이미지 로딩을 수행하는 부분
        // 이전 코드와 동일하게 이미지 로드하는 부분 추가
        bg = new ImageIcon("./img/StartBackground.jpeg");
        titleImage = new ImageIcon("./img/title.png");
    }

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

}
