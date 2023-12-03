package AboutFunction;

import MainFrame.GameStart;
import MainFrame.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;
import java.util.Map;
import java.util.Vector;

import static javax.swing.JLayeredPane.PALETTE_LAYER;

public class MapSelection extends ActiveFunction{
    private String[] mapNames = new String[5];

    public Integer mapsetting[][] = {{1,2,3},
                                     {4,5,6},
                                     {7,8,9}};

    //true가 벽(갈 수 없는 곳, 어차피 맵마다 이동 범위 제한할 거기에 별 다른 이벤트가 발생하지 않도록 true 처리)
    private static boolean[][][] saveWay = {{{true, false, false, true},{true, false, false, false},{true, true, false, false}},
                                            {{false, false, false, true},{false, false, false, false},{false, true, false, false}},
                                            {{false, false, true, true},{true, false, false, true},{true, false, false, true}}};

    private static boolean[][][] Move = {{{false, true, true, false},{false, true, true, true},{false, false, true, true}},
                                            {{true, true, true, false},{true, true, true, true},{true, false, true, true}},
                                            {{true, true, false, false},{true, true, false, true},{true, false, false, true}}};

    public static int currentLocationX = 0;
    public static int currentLocationY= 0;

    private ImageIcon mapimg = new ImageIcon("img/map.jpg");
    private static ImageIcon loadingImg = new ImageIcon("img/loading.jpg");

    public static void setCurrentLocation(int x, int y){
        currentLocationX = x; currentLocationY = y;
    }
    public static void changeState(int x, int y, int locate, boolean state){
        saveWay[x][y][locate] = state;
    }

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

    public MapSelection(){
        Main.setFrame.add(createLabel(mapimg,0,0));
    }

}
