package MiniGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

public class minigame08 extends JFrame implements ActionListener, KeyListener {
    private static final int GRID_SIZE = 20;
    private static final int CELL_SIZE = 20;

    private LinkedList<Point> snake;
    private Point food;
    private int direction;

    public minigame08() {
        setTitle("Snake Game");
        setSize(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        snake = new LinkedList<>();
        snake.add(new Point(5, 5));
        direction = KeyEvent.VK_RIGHT;

        spawnFood();

        Timer timer = new Timer(200, this);
        timer.start();

        addKeyListener(this);
        setFocusable(true);
    }

    private void spawnFood() {
        Random random = new Random();
        int x, y;

        do {
            x = random.nextInt(GRID_SIZE);
            y = random.nextInt(GRID_SIZE);
        } while (snake.contains(new Point(x, y)));

        food = new Point(x, y);
    }

    private void move() {
        Point head = snake.getFirst();

        switch (direction) {
            case KeyEvent.VK_UP:
                head = new Point(head.x, (head.y - 1 + GRID_SIZE) % GRID_SIZE);
                break;
            case KeyEvent.VK_DOWN:
                head = new Point(head.x, (head.y + 1) % GRID_SIZE);
                break;
            case KeyEvent.VK_LEFT:
                head = new Point((head.x - 1 + GRID_SIZE) % GRID_SIZE, head.y);
                break;
            case KeyEvent.VK_RIGHT:
                head = new Point((head.x + 1) % GRID_SIZE, head.y);
                break;
        }

        if (head.equals(food)) {
            snake.addFirst(food);
            spawnFood();
        } else {
            snake.addFirst(head);
            snake.removeLast();
        }

        // Check for collisions with itself
        if (snake.size() > 1 && snake.subList(1, snake.size()).contains(head)) {
            gameOver();
        }
    }

    private void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw grid
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                g.drawRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        // Draw food
        g.setColor(Color.RED);
        g.fillRect(food.y * CELL_SIZE, food.x * CELL_SIZE, CELL_SIZE, CELL_SIZE);

        // Draw snake
        g.setColor(Color.GREEN);
        for (Point point : snake) {
            g.fillRect(point.y * CELL_SIZE, point.x * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) { /// 지렁이 게임을 만들었으나 움직이지 않는 오류가 있다.
        int newDirection = e.getKeyCode();

        // Avoid moving in opposite direction
        if ((newDirection == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) ||
                (newDirection == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP) ||
                (newDirection == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) ||
                (newDirection == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT)) {
            direction = newDirection;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            minigame08 game = new minigame08();
            game.setVisible(true);
        });
    }
}
