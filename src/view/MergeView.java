package view;

import data_access.PlaylistHistoryAccess;
import entity.Playlist;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.merge.MergeController;
import interface_adapter.output.OutputViewModel;
import interface_adapter.output.OutputViewState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class MergeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "merge";

    private final OutputViewModel outputViewModel;
    private final ViewManagerModel viewManagerModel;
    private final GenerateViewModel generateViewModel;

    private final MergeController mergeController;

    private final MenuView menuView;

    public final JButton back;
    public final JButton merge;
    public final JButton generateAgain;

    public MergeView(OutputViewModel outputViewModel, ViewManagerModel viewManagerModel,
                     GenerateViewModel generateViewModel, MergeController mergeController,
                     MenuView menuView) {
        this.outputViewModel = outputViewModel;
        outputViewModel.addPropertyChangeListener(this);

        this.viewManagerModel = viewManagerModel;
        this.generateViewModel = generateViewModel;
        generateViewModel.addPropertyChangeListener(this);

        this.menuView = menuView;

        this.mergeController = mergeController;

        back = new JButton("Back");
        back.setAlignmentX(Component.LEFT_ALIGNMENT);
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

        merge = new JButton("Merge with previous playlist(s)");
        merge.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(merge)) {
                            try {
                                mergeController.execute(PlaylistHistoryAccess.getPlaylists());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );

        generateAgain = new JButton(OutputViewModel.GENERATE_ANOTHER_BUTTON_LABEL);
        generateAgain.setAlignmentX(Component.CENTER_ALIGNMENT);
        generateAgain.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(generateAgain)) {
                            viewManagerModel.setActiveView(generateViewModel.getViewName());
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

        JLabel title = new JLabel(OutputViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        OutputViewState state = (OutputViewState) evt.getNewValue();
        Playlist generatedPlaylist = state.getGeneratedPlaylist();
        for (int i = 0; i < state.getNumOfTracks(); i++) {
            JLabel songName = new JLabel(generatedPlaylist.getSongs().get(i).getName() + ", ");

            String artistNames = "";
            for (String artist: generatedPlaylist.getSongs().get(i).getArtist()) {
                artistNames += artist + ", ";
            }

            JLabel songArtist = new JLabel(artistNames);
            JLabel songLink = new JLabel(generatedPlaylist.getSongs().get(i).getLink());

            JPanel song = new JPanel();
            song.add(songName);
            song.add(songArtist);
            song.add(songLink);

            this.add(song);
        }
        JPanel buttons = new JPanel();
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.add(back);
        buttons.add(merge);
        buttons.add(generateAgain);

        this.add(buttons);
    }
}
