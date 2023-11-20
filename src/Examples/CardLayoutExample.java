package Examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel cardPanel = new JPanel(new CardLayout());

        // Create and add cards to the panel
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Card 1 Content"));
        cardPanel.add(card1, "Card 1");

        JPanel card2 = new JPanel();
        card2.add(new JLabel("Card 2 Content"));
        cardPanel.add(card2, "Card 2");

        // Create buttons to switch between cards
        JButton card1Button = new JButton("Show Card 1");
        JButton card2Button = new JButton("Show Card 2");

        card1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "Card 1");
            }
        });

        card2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.show(cardPanel, "Card 2");
            }
        });

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(card1Button);
        buttonPanel.add(card2Button);

        // Create the main content pane
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(cardPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}