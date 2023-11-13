package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GenerateViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Generate View";
    public static final String GENRE_LABEL = "Select a Genre for your playlist: ";
    public static final String NUM_TACKS_LABEL = "Enter how many tracks you want: ";

    public static final String GENERATE_BUTTON_LABEL = "Generate";

    private GenerateState state = new GenerateState();

    public GenerateViewModel() { super("generate"); }

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