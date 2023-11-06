import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Define All key Event
public class KeyboardEvent extends KeyAdapter {
    GameStart gs;
    public KeyboardEvent(GameStart gs) {
        this.gs = gs; // GameStart 객체를 받아서 할당합니다.
    }
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int keyCode = e.getKeyCode(); // 눌린 키의 코드를 가져옵니다.

        if (keyCode == KeyEvent.VK_UP) {
            gs.boldmote.setLocation(gs.boldmote.getX(),gs.boldmote.getY() - 10);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            gs.boldmote.setLocation(gs.boldmote.getX(),gs.boldmote.getY() + 10);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            gs.boldmote.setLocation(gs.boldmote.getX() - 10,gs.boldmote.getY());
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            gs.boldmote.setLocation(gs.boldmote.getX() + 10,gs.boldmote.getY());
        }
    }
}
