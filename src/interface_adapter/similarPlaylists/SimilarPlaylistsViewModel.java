package interface_adapter.similarPlaylists;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SimilarPlaylistsViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Here's some playlists contains the song:";

    private SimilarPlaylistsState state = new SimilarPlaylistsState();

    public SimilarPlaylistsViewModel() { super("similarPlaylists"); }

    public void setState(SimilarPlaylistsState state) { this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SimilarPlaylistsState getState() { return state; }
}
