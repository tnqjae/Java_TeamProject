import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Shoot extends JFrame {
    public int n=60;
    class TimerThread implements Runnable {


        private JLabel timerLabel;// 타이머 값이 출력되는 레이블

        public TimerThread(JLabel timerLabel) {
            this.timerLabel = timerLabel; // 타이머 카운트를 출력할 레이블
        }

        // 스레드 코드. run()이 종료하면 스레드 종료
        @Override
        public void run() {

            while(n>=0) { // 무한 루프
                timerLabel.setText(Integer.toString(n)); // 레이블에 카운트 값 출력
                n--; // 카운트 증가
                try {
                    Thread.sleep(1000); // 1초동안 잠을 잔다.
                }
                catch(InterruptedException e) {
                    return; // 예외가 발생하면 스레드 종료
                }
                timerLabel.setText("종료");
            }
        }
    }
    class Tg implements Runnable{
        private JLabel tg;
        public Tg(JLabel tg){
            this.tg=tg;
        }
        public void run(){
            Random r = new Random();
            aa.addMouseListener(new MMA());
            while(true) {
                aa.setIcon(img);
                int x=(int)(Math.random()*1000)+100;
                int y=(int)(Math.random()*470)+100;

//                if((int)(Math.random()*100)<=14) aa.setIcon(img2);
//                else aa.setIcon(img);
                aa.setLocation(x, y); // 프레임의 위치 이동
                try {
                    Thread.sleep(1300-(10*point)); // 20ms 잠자기
                }
                catch(InterruptedException e){
                    return; // 리턴하면 스레드 종료
                }

                if(aa.getIcon()==img & form==0) {
                    if(point==0);
                    else point--;
                }
                score.setText("Score : "+point);
                form=0;
                if(n==-1) {

                    return;
                }
            }
        }
    }
    public int point=0;
    public int form=1;
    JLabel score = new JLabel();
    ImageIcon img = new ImageIcon("images/asd.png");
    ImageIcon img2 = new ImageIcon("images/bomb.png");
    JLabel aa = new JLabel(img);

    public Shoot(){
        super("사격왕");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic", Font.ITALIC, 50));


        score.setSize(100,50);
        score.setBackground(Color.LIGHT_GRAY);
        score.setOpaque(true);
        score.setText("Score : 0");
        timerLabel.setLocation(600,-20);

        aa.setSize(100,100);
        timerLabel.setSize(150,120);
        setLocation(200,200);
        aa.setOpaque(true);


        c.add(aa);
        c.add(score);
        c.add(timerLabel);// 레이블을 컨텐트팬에 부착
        TimerThread runnable = new TimerThread(timerLabel);
        Thread th2 = new Thread(runnable);
        Tg tg = new Tg(aa);
        Thread th = new Thread(tg);

        setSize(1250,720);
        setVisible(true);
        th2.start();
        th.start();

    }
    class MMA extends MouseAdapter{

        public void mousePressed  (MouseEvent e){
            form =1;
            aa.setLocation(-100,-100);
            if(aa.getIcon()==img2)
                if(point<=5) point=0;
                else point-=5;
            else point++;
            score.setText("표적 : "+point);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            if((int)(Math.random()*100)<=14) aa.setIcon(img2);
            else aa.setIcon(img);
            form=2;
        }
    }
    public static void main(String[] args) {
        new Shoot();
    }
}

