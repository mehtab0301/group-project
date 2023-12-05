package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Color;
import java.awt.Font;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "menu";

    private final GenerateViewModel generateViewModel;
    private final GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel;
    private final GetTrackDetailsViewModel getTrackDetailsViewModel;
    private final ViewManagerModel viewManagerModel;

    public final JButton generate;
    public final JButton getSimilar;
    public final JButton getTrackInfo;
    public MenuView(GenerateViewModel generateViewModel, GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel,
                    GetTrackDetailsViewModel getTrackDetailsViewModel, ViewManagerModel viewManagerModel) {
        this.generateViewModel = generateViewModel;
        this.getSimilarPlaylistsViewModel = getSimilarPlaylistsViewModel;
        this.getTrackDetailsViewModel = getTrackDetailsViewModel;
        this.viewManagerModel = viewManagerModel;

        JLabel title = new JLabel("Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(new Color(22,23,46));

        JPanel generateButton = new JPanel();
        generate = new JButton("Generate Playlist");
        generate.setBackground(new Color(22,23,46));
        generate.setForeground(new Color(22,23,46));
        generate.setFont(new Font("Poppins", Font.BOLD, 15));
        generateButton.setBackground(new Color(22,23,46));
        generateButton.setFont(new Font("Poppins", Font.BOLD, 17));
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
        getSimilar.setForeground(new Color(22,23,46));
        getSimilar.setBackground(new Color(22,23,46));
        getSimilar.setFont(new Font("Poppins", Font.BOLD, 15));
        getSimilarPlaylistsButton.setBackground(new Color(22,23,46));
        getSimilarPlaylistsButton.setFont(new Font("Poppins", Font.BOLD, 17));
        getSimilarPlaylistsButton.add(getSimilar);

        getSimilar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(getSimilar)) {
                            viewManagerModel.setActiveView(getSimilarPlaylistsViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        JPanel getTrackInfoButton = new JPanel();
        getTrackInfo = new JButton("Get details of the song");
        getTrackInfo.setBackground(new Color(22,23,46));
        getTrackInfo.setFont(new Font("Poppins", Font.BOLD, 15));
        getTrackInfoButton.setFont(new Font("Poppins", Font.BOLD, 17));
        getTrackInfoButton.setBackground(new Color(22,23,46));
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
