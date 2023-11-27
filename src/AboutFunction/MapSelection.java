package AboutFunction;

import javax.swing.*;
import java.util.Map;
import java.util.Vector;

public class MapSelection {
    private String[] mapNames = new String[5];
    private JLabel [][]map = new JLabel[4][4];

    private Pair<Integer, Integer> bossLocation;
    public MapSelection(){

    }
}

class Pair<A, B> {
    public final A first;
    public final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
}