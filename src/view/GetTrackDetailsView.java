package view;

import interface_adapter.getTrackDetails.GetTrackDetailsController;
import interface_adapter.getTrackDetails.GetTrackDetailsState;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

public class GetTrackDetailsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "getTrackDetails";

    private final GetTrackDetailsViewModel getTrackDetailsViewModel;
    public final JTextField songLinkField = new JTextField(15);

    public final JButton generate;

    private final GetTrackDetailsController getTrackDetailsController;

    public  GetTrackDetailsView(GetTrackDetailsController getTrackDetailsController,
                                GetTrackDetailsViewModel getTrackDetailsViewModel) {
        this.getTrackDetailsController = getTrackDetailsController;
        this.getTrackDetailsViewModel = getTrackDetailsViewModel;
        getTrackDetailsViewModel.addPropertyChangeListener(this);
        this.setBackground(new Color(22,23,46));

        JLabel title = new JLabel(GetTrackDetailsViewModel.TITLE_LABEL);
        title.setBackground(new Color(22,23,46));
        title.setForeground(new Color(169, 245,180));
        title.setFont(new Font("Poppins", Font.BOLD, 15));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel songLabel = new JLabel(GetTrackDetailsViewModel.SONGLINK_LABEL);
        songLabel.setBackground(new Color(22,23,46));
        songLabel.setForeground(new Color(169, 245,180));
        songLabel.setFont(new Font("Poppins", Font.BOLD, 15));

        LabelTextPanel songLink = new LabelTextPanel(songLabel,
                songLinkField);
        songLink.setForeground(new Color(22,23,46));
        songLink.setBackground(new Color(22,23,46));
        songLink.setFont(new Font("Poppins", Font.BOLD, 15));
        songLink.setAlignmentX(Component.CENTER_ALIGNMENT);

        songLinkField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        GetTrackDetailsState currentState = getTrackDetailsViewModel.getState();
                        String link = songLinkField.getText() + e.getKeyChar();
                        currentState.setSongLink(link.substring(0, link.length() - 1));
                        getTrackDetailsViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        JPanel buttons = new JPanel();
        generate = new JButton(GetTrackDetailsViewModel.GENERATE_BUTTON_LABEL);

        buttons.setBackground(new Color(22,23,46));
        buttons.setForeground(new Color(169, 245,180));
        buttons.add(generate);

        generate.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(generate)) {
                            GetTrackDetailsState currentState = getTrackDetailsViewModel.getState();

                            try {
                                getTrackDetailsController.execute(currentState.getSongLink());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(songLink);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
