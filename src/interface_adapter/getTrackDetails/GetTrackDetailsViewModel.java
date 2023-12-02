package interface_adapter.getTrackDetails;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetTrackDetailsViewModel extends ViewModel {

    public static final String TITLE_LABEL = "GetTrackDetails View";
    public static final String SONGLINK_LABEL = "Enter the song link: ";

    public static final String GENERATE_BUTTON_LABEL = "Generate";

    private GetTrackDetailsState state = new GetTrackDetailsState();

    public GetTrackDetailsViewModel() { super("getTrackDetails"); }

    public void setState(GetTrackDetailsState state) { this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public GetTrackDetailsState getState() { return state; }
}
