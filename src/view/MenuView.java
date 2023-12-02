package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "menu";

    private final GenerateViewModel generateViewModel;

    private final GetTrackDetailsViewModel getTrackDetailsViewModel;
    private final ViewManagerModel viewManagerModel;

    private final JButton generate;
    private final JButton getSimilar;
    private final JButton getTrackInfo;
    public MenuView(GenerateViewModel generateViewModel, GetTrackDetailsViewModel getTrackDetailsViewModel,
                    ViewManagerModel viewManagerModel) {
        this.generateViewModel = generateViewModel;
        this.getTrackDetailsViewModel = getTrackDetailsViewModel;
        this.viewManagerModel = viewManagerModel;

        JLabel title = new JLabel("Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel generateButton = new JPanel();
        generate = new JButton("Generate Playlist");
        generateButton.add(generate);

        generate.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource().equals(generate)) {
                            viewManagerModel.setActiveView(generateViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        JPanel getSimilarPlaylistsButton = new JPanel();
        getSimilar = new JButton("Get Playlists contains the song");
        getSimilarPlaylistsButton.add(getSimilar);

        JPanel getTrackInfoButton = new JPanel();
        getTrackInfo = new JButton("Get details of the song");
        getTrackInfoButton.add(getTrackInfo);

        getTrackInfo.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(getTrackInfo)) {
                            viewManagerModel.setActiveView(getTrackDetailsViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(generateButton);
        this.add(getSimilarPlaylistsButton);
        this.add(getTrackInfoButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
