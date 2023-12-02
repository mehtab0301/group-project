package interface_adapter.getSimilarPlaylists;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetSimilarPlaylistsViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Get Playlists View";
    public static final String SONGNAME_LABEL = "Enter the song name: ";

    public static final String GENERATE_BUTTON_LABEL = "Generate";

    private GetSimilarPlaylistsState state = new GetSimilarPlaylistsState();

    public GetSimilarPlaylistsViewModel() { super("getSimilarPlaylists"); }

    public void setState(GetSimilarPlaylistsState state) { this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public GetSimilarPlaylistsState getState() { return state; }
}
