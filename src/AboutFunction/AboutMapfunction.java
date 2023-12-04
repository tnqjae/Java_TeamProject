package AboutFunction;

import MainFrame.GameStart;
import MainFrame.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AboutMapfunction extends ActiveFunction{
    private static Integer mapsetting[][] = {{0,0,0},
                                             {0,0,0},
                                             {0,0,0}};

    //true가 벽(갈 수 없는 곳, 어차피 맵마다 이동 범위 제한할 거기에 별 다른 이벤트가 발생하지 않도록 true 처리)
    private static boolean[][][] saveWay = {{{true, false, false, true},{true, false, false, false},{true, true, false, false}},
                                            {{false, false, false, true},{false, false, false, false},{false, true, false, false}},
                                            {{false, false, true, true},{false, false, true, false},{false, true, true, false}}};

    private static boolean[][][] Move = {{{false, true, true, false},{false, true, true, true},{false, false, true, true}},
                                            {{true, true, true, false},{true, true, true, true},{true, false, true, true}},
                                            {{true, true, false, false},{true, true, false, true},{true, false, false, true}}};

    public static int currentLocationX = 0;
    public static int currentLocationY= 0;

    private static int []hocCordinate = new int[3];

    private ImageIcon mapimg = new ImageIcon("img/map.jpg");
    private static ImageIcon loadingImg = new ImageIcon("img/loading.jpg");

    private static void setHocCordinate(){
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int row = random.nextInt(3);    // 0, 1, 2 중에서 무작위 행 선택
            int col = random.nextInt(3);    // 0, 1, 2 중에서 무작위 열 선택

            // 이미 1 또는 2가 아닌 경우에만 1 또는 2 삽입
            if (mapsetting[row][col] != 1 && mapsetting[row][col] != 2) {
                mapsetting[row][col] = (i == 2) ? 2 : 1; // 마지막 반복에서는 2를 삽입, 그 외에는 1을 삽입
            } else {
                // 이미 1 또는 2가 있는 경우 다른 위치 선택
                i--; // 현재 반복을 다시 수행하기 위해 i를 감소
            }
        }
    }
    public static void setCurrentLocation(int x, int y){
        currentLocationX = x; currentLocationY = y;
    }
    public static int getCurrentLocationX(){
        return currentLocationX;
    }
    public static int getCurrentLocationY(){
        return currentLocationY;
    }
    public static void changeState(int x, int y, int locate, boolean state){
        saveWay[x][y][locate] = state;
        if (locate == 0){
            saveWay[x - 1][y][2] = true;
        } else if(locate == 1){
            saveWay[x][y + 1][3] = true;
        } else if(locate == 2){
            saveWay[x + 1][y][0] = true;
        } else if(locate == 3){
            saveWay[x][y - 1][1] = true;
        }
    }

    //public static void HocCurrentLocation(){
    //    if()
    //}

    public static boolean getWayState(int locate){
        return saveWay[currentLocationX][currentLocationY][locate];
    }

    public static boolean canMove(int x, int y, int loc){
        return Move[x][y][loc];
    }

    public static void loading(int x, int y){
        SwingUtilities.invokeLater(() -> {
            JLabel loading = new JLabel(loadingImg);
            loading.setLocation(0, 0);
            loading.setSize(loadingImg.getIconWidth(), loadingImg.getIconHeight());
            Main.setFrame.getLayeredPane().add(loading, JLayeredPane.PALETTE_LAYER);

            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        Main.setFrame.getLayeredPane().remove(loading);
                        Main.setFrame.revalidate(); // 레이아웃을 다시 유효화하여 변경된 구성 요소를 반영합니다.
                        Main.setFrame.repaint(); // 변경된 내용을 즉시 화면에 갱신합니다.
                    });
                }
            });
            timer.setRepeats(false); // 타이머를 한 번만 실행하도록 설정
            timer.start();
        });
        GameStart.boldmote.setLocation(x, y - GameStart.boldmote.getHeight() / 2);
    }

    public AboutMapfunction(){
        Main.setFrame.add(createLabel(mapimg,0,0));
    }

}
