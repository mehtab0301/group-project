package interface_adapter;
import interface_adapter.generate.GenerateState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FirstViewModel extends ViewModel {


    public static final String TITLE_LABEL = "Main Menu";

    public static final String CREATE_BUTTON_LABEL = "Create playlist";

    public static final String MERGE_BUTTON_LABEL = "Merge Playlist";

    public static final String Info_BUTTON_LABEL = "Information about playlist";


    private GenerateState state = new GenerateState();

    public FirstViewModel() { super("generate"); }

    public void setState(GenerateState state) { this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public GenerateState getState() {
        return state;
    }

}
