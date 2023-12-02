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

        for (int i = 0; i < state.getNumOfInfo(); i++) {
            JPanel eachInfo = new JPanel();
            JLabel info = new JLabel(String.valueOf(trackInfo.get(i)));
            eachInfo.add(info);

            this.add(eachInfo);
        }

        this.add(back);
    }
}
