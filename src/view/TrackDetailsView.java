package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.trackDetails.TrackDetailsState;
import interface_adapter.trackDetails.TrackDetailsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class TrackDetailsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "trackDetails";

    private final ViewManagerModel viewManagerModel;
    private final TrackDetailsViewModel trackDetailsViewModel;

    public final MenuView menuView;

    private final JButton back;

    public TrackDetailsView(TrackDetailsViewModel trackDetailsViewModel,
                            ViewManagerModel viewManagerModel,
                            MenuView menuView) {
        this.trackDetailsViewModel = trackDetailsViewModel;
        trackDetailsViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = viewManagerModel;
        this.menuView = menuView;

        JLabel title = new JLabel(TrackDetailsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        this.add(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TrackDetailsState state = (TrackDetailsState) evt.getNewValue();
        List<Object> trackInfo = state.getTrackInfo();

        JPanel popularity = new JPanel();
        JLabel popularityInfo = new JLabel("The popularity of this song is: " + String.valueOf(trackInfo.get(0)));
        popularity.add(popularityInfo);

        JPanel releaseDate = new JPanel();
        JLabel releaseDateInfo = new JLabel("The release date of this song is: " +
                String.valueOf(trackInfo.get(1)));
        releaseDate.add(releaseDateInfo);

        this.add(popularity);
        this.add(releaseDate);
        this.add(back);
    }
}
