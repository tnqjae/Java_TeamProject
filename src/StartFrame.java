import javax.swing.*;

public class StartFrame extends JFrame {
    ImageIcon bg;
    ImageIcon titleImage;
    ImageIcon startButton;
    ImageIcon ruleButton;
    public StartFrame() {
        super("Hogwarts Escape");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        //Using Thread to Load Image Process.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                loadImages(); //Load Image
                addTitle(); //Add Title
                addStartButton();//Add Start Button
                addRuleButton();//Add Rule Button
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
    //Load Image Location
    private void loadImages() {
        bg = new ImageIcon("./img/StartBackground.jpeg");
        titleImage = new ImageIcon("./img/title.png");
        startButton = new ImageIcon("./img/Start.png");
        ruleButton = new ImageIcon("./img/Rule.png");
    }

    //All add component process -> make Method
    private void addBackground() {
        JLabel background = new JLabel(bg);
        background.setSize(bg.getIconWidth(), bg.getIconHeight());
        background.setLocation(0, 0);
        add(background);
    }

    //Add Title image
    private void addTitle() {
        JLabel title = new JLabel(titleImage);
        title.setSize(titleImage.getIconWidth(), titleImage.getIconHeight());
        title.setLocation(420, 80);
        add(title);
    }

    //Add Start Button
    private void addStartButton(){
        JLabel stbutton = new JLabel(startButton);
        stbutton.setSize(startButton.getIconWidth(), startButton.getIconHeight());
        stbutton.setLocation(60, 380);
        add(stbutton);
    }

    //Add Rule Button
    private void addRuleButton(){
        JLabel rulebutton = new JLabel(ruleButton);
        rulebutton.setSize(ruleButton.getIconWidth(), ruleButton.getIconHeight());
        rulebutton.setLocation(60, 500);
        add(rulebutton);
    }
}
