package Examples;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwitchingCardsExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a panel with CardLayout
        JPanel cardPanel = new JPanel(new CardLayout());

        // Create the first card
        JPanel firstCard = new JPanel();
        firstCard.add(new JButton("Switch to Second Card"));

        // Create the second card
        JPanel secondCard = new JPanel();
        secondCard.add(new JButton("Switch to First Card"));

        // Add cards to the card panel
        cardPanel.add(firstCard, "first");
        cardPanel.add(secondCard, "second");

                // Add action listeners to the buttons for card switching
                JButton switchToSecondCardButton = new JButton("Switch to Second Card");
                switchToSecondCardButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                        cardLayout.show(cardPanel, "second");
                    }
                });

                JButton switchToFirstCardButton = new JButton("Switch to First Card");
                switchToFirstCardButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                        cardLayout.show(cardPanel, "first");
                    }
                });

                // Add buttons to the content pane
                frame.getContentPane().add(cardPanel);
                frame.getContentPane().add(switchToSecondCardButton, "South"); // Button below the cards

                frame.setVisible(true);
            }
        }


