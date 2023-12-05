package view;

import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsController;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsState;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;

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

public class GetSimilarPlaylistsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "getSimilarPlaylists";

    private final GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel;

    public final JTextField songNameField = new JTextField(15);

    public final JButton generate;

    private final GetSimilarPlaylistsController getSimilarPlaylistsController;

    public GetSimilarPlaylistsView(GetSimilarPlaylistsController getSimilarPlaylistsController,
                                   GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel) {this.getSimilarPlaylistsController = getSimilarPlaylistsController;
        this.getSimilarPlaylistsViewModel = getSimilarPlaylistsViewModel;
        this.
                getSimilarPlaylistsViewModel.addPropertyChangeListener(this);
        this.setBackground(new Color(22,23,46));

        JLabel title = new JLabel(GetSimilarPlaylistsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBackground(new Color(22,23,46));
        title.setForeground(new Color(169, 245,180));

        JLabel songLabel = new JLabel(GetSimilarPlaylistsViewModel.SONGNAME_LABEL);
        songLabel.setBackground(new Color(22,23,46));
        songLabel.setForeground(new Color(213, 249,121));
        songLabel.setFont(new Font("Poppins", Font.BOLD, 15));

        LabelTextPanel songName = new LabelTextPanel(songLabel,
                songNameField);
        songName.setBackground(new Color(22,23,46));
        songName.setForeground(new Color(213, 249,121));
        songName.setAlignmentX(Component.CENTER_ALIGNMENT);

        songNameField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        GetSimilarPlaylistsState currentState = getSimilarPlaylistsViewModel.getState();
                        String name = songNameField.getText() + e.getKeyChar();
                        currentState.setSongName(name);
                        getSimilarPlaylistsViewModel.setState(currentState);
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
        buttons.setBackground(new Color(22,23,46));
        generate = new JButton(GetSimilarPlaylistsViewModel.GENERATE_BUTTON_LABEL);
        generate.setBackground(new Color(22,23,46));
        buttons.add(generate);

        generate.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(generate)) {
                            GetSimilarPlaylistsState currentState = getSimilarPlaylistsViewModel.getState();

                            try {
                                getSimilarPlaylistsController.execute(currentState.getSongName());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(songName);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
