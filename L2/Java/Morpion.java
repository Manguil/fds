import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Morpion extends JFrame implements ActionListener {

    private JButton[][] buttons;
    private JButton reset;
    private JLabel label;
    private int turn;
    private int[][] grid;

    public Morpion() {
        super("Morpion");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);
                panel.add(buttons[i][j]);
            }
        }
        add(panel, BorderLayout.CENTER);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        add(reset, BorderLayout.SOUTH);

        label = new JLabel("Player 1's turn");
        add(label, BorderLayout.NORTH);

        turn = 1;
        grid = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = 0;
            }
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText("");
                    grid[i][j] = 0;
                }
            }
            turn = 1;
            label.setText("Player 1's turn");
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (e.getSource() == buttons[i][j]) {
                        if (turn == 1) {
                            buttons[i][j].setText("X");
                            grid[i][j] = 1;
                            turn = 2;
                            label.setText("Player 2's turn");
                        } else {
                            buttons[i][j].setText("O");
                            grid[i][j] = 2;
                            turn = 1;
                            label.setText("Player 1's turn");
                        }
                    }
                }
            }
        }
        if (checkWin()) {
            if (turn == 1) {
                label.setText("Player 2 wins!");
            } else {
                label.setText("Player 1 wins!");
            }
        }
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != 0) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != 0) {
                return true;
            }
        }
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != 0) {
            return true;
        }
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Morpion();
    }
}