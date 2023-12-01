package interface_adapter.output;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OutputViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Here's your generated playlist:";

    public static final String GENERATE_ANOTHER_BUTTON_LABEL = "Generate another playlist";

    private OutputViewState state = new OutputViewState();

    public OutputViewModel() { super("output");}

    public void setState(OutputViewState state) { this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public OutputViewState getState() { return state; }
}
