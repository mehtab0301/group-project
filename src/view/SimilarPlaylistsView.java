package view;

import entity.SimilarPlaylists;
import interface_adapter.ViewManagerModel;
import interface_adapter.similarPlaylists.SimilarPlaylistsState;
import interface_adapter.similarPlaylists.SimilarPlaylistsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SimilarPlaylistsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "similarPlaylists";

    private final ViewManagerModel viewManagerModel;
    private final SimilarPlaylistsViewModel similarPlaylistsViewModel;

    private final MenuView menuView;

    public final JButton back;

    public SimilarPlaylistsView(SimilarPlaylistsViewModel similarPlaylistsViewModel,
                                ViewManagerModel viewManagerModel,
                                MenuView menuView) {
        this.similarPlaylistsViewModel = similarPlaylistsViewModel;
        similarPlaylistsViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = viewManagerModel;
        this.menuView = menuView;

        back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            viewManagerModel.setActiveView(menuView.viewName);
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.removeAll();

        JLabel title = new JLabel(SimilarPlaylistsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        SimilarPlaylistsState state = (SimilarPlaylistsState) evt.getNewValue();
        SimilarPlaylists similarPlaylists = state.getSimilarPlaylists();

        for (int i = 0; i < similarPlaylists.getSimilarPlaylistsLength(); i++) {
            JPanel similarPlaylist = new JPanel();
            JLabel playlistLink = new JLabel(similarPlaylists.getSimilarPlaylists().get(i));
            similarPlaylist.add(playlistLink);

            this.add(similarPlaylist);
        }

        this.add(back);
    }
}
