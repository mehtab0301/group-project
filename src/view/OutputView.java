package view;

import entity.Playlist;
import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.output.OutputViewModel;
import interface_adapter.output.OutputViewState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OutputView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "output";

    public final JButton back;
    public final JButton generateAgain;

    private final OutputViewModel outputViewModel;
    private final ViewManagerModel viewManagerModel;
    private final GenerateViewModel generateViewModel;
    private final MenuView menuView;

    public OutputView(OutputViewModel outputViewModel, ViewManagerModel viewManagerModel,
                      GenerateViewModel generateViewModel, MenuView menuView) {
        this.outputViewModel = outputViewModel;
        outputViewModel.addPropertyChangeListener(this);

        this.viewManagerModel = viewManagerModel;
        this.generateViewModel = generateViewModel;

        this.menuView = menuView;

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
        buttons.add(back);
        buttons.add(generateAgain);

        this.add(buttons);
    }
}
