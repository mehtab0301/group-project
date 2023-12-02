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

public class GetSimilarPlaylistsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "getSimilarPlaylists";

    private final GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel;

    private final JTextField songNameField = new JTextField(15);

    private final JButton generate;

    private final GetSimilarPlaylistsController getSimilarPlaylistsController;

    public GetSimilarPlaylistsView(GetSimilarPlaylistsController getSimilarPlaylistsController,
                                   GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel) {
        this.getSimilarPlaylistsController = getSimilarPlaylistsController;
        this.getSimilarPlaylistsViewModel = getSimilarPlaylistsViewModel;
        getSimilarPlaylistsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(GetSimilarPlaylistsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel songName = new LabelTextPanel(new JLabel(GetSimilarPlaylistsViewModel.SONGNAME_LABEL),
                songNameField);
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
        generate = new JButton(GetSimilarPlaylistsViewModel.GENERATE_BUTTON_LABEL);
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
