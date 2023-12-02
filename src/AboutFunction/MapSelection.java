package AboutFunction;

import MainFrame.Main;

import javax.swing.*;
import java.awt.font.ImageGraphicAttribute;
import java.util.Map;
import java.util.Vector;

public class MapSelection extends ActiveFunction{
    private String[] mapNames = new String[5];

    private Integer mapsetting[][] = {{0,0,0},
                                      {0,0,0},
                                      {0,0,0}};

    public Integer load[][][] =

    public int currentLocation = -1;

    //private Pair<Integer, Integer> hocLoation =  new Pair[2];
    private ImageIcon mapimg = new ImageIcon("img/map.jpg");

    public MapSelection(){
        Main.setFrame.add(createLabel(mapimg,0,0));

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