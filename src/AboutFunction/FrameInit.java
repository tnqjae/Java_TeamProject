package AboutFunction;

import MainFrame.Main;

class FrameInit { //Init JFrame class
    public FrameInit(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() { //Using Threads for Real-Time Processing
                //JFrame Init
                Main.setFrame.getContentPane().removeAll();
                Main.setFrame.revalidate();
                Main.setFrame.repaint();
            }
        });
        thread.start();
    }
}
