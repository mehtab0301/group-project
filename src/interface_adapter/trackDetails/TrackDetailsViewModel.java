package interface_adapter.trackDetails;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrackDetailsViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Here's the song info: ";

    private TrackDetailsState state = new TrackDetailsState();

    public TrackDetailsViewModel() { super("trackDetails"); }

    public void setState(TrackDetailsState state) { this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TrackDetailsState getState() { return state; }
}
