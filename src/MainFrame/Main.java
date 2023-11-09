package MainFrame;

import MainFrame.StartFrame;

import javax.swing.*;
public class Main extends StartFrame{
    //Standardization of Frames
    public static JFrame setFrame = new JFrame();
    public static void main(String[] args) {
            new StartFrame(setFrame);
    }
}