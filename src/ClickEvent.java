import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class StartClickEvent extends MouseAdapter{
    public void mouseClicked(MouseEvent e) {
        System.out.println("test");
    }
}
class RuleClickEvent extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
        System.out.println("Rule");
    }
}
