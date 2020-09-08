package com.pract4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame {
    private enum Team {
        AC_MILAN,
        REAL_MADRID
    }

    private final TeamButton buttonMilan;
    private final TeamButton buttonMadrid;
    private final JLabel result;
    private final JLabel lastScorer;
    private final Label winner;

    Main() {
        super("Application");
        setLayout(null);
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonMilan = new TeamButton("AC Milan", Team.AC_MILAN);
        buttonMadrid = new TeamButton("Real Madrid", Team.REAL_MADRID);
        result = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
        lastScorer = new JLabel("Last scorer: N/A", SwingConstants.CENTER);
        winner = new Label("Winner: DRAW", Label.CENTER);

        buttonMilan.setBounds(50, 300, 150, 50);
        buttonMadrid.setBounds(300, 300, 150, 50);
        result.setBounds(0, 50, 500, 50);
        lastScorer.setBounds(0, 100, 500, 50);
        winner.setBounds(0, 150, 500, 50);

        add(buttonMilan);
        add(buttonMadrid);
        add(result);
        add(lastScorer);
        add(winner);
    }

    private class TeamButton extends JButton {
        private int score;
        private final Team team;

        TeamButton(String text, Team team) {
            super(text);
            this.team = team;
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) { }

                @Override
                public void mousePressed(MouseEvent e) { }

                @Override
                public void mouseReleased(MouseEvent e) {
                    ++score;
                    result.setText("Result: " + buttonMilan.score + " X " + buttonMadrid.score);
                    lastScorer.setText("Last scorer: " + getText());
                    if (buttonMilan.score < buttonMadrid.score) {
                        winner.setText("Winner: " + buttonMadrid.getText());
                    } else if (buttonMilan.score > buttonMadrid.score) {
                        winner.setText("Winner: " + buttonMilan.getText());
                    } else {
                        winner.setText("Winner: DRAW");
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) { }

                @Override
                public void mouseExited(MouseEvent e) { }
            });
        }

        @Override
        public String toString() {
            return "TeamButton{score = " + score + ", team = " + team + "}";
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
