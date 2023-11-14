package interface_adapter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FirstViewModel extends ViewModel{


    public static final String TITLE_LABEL = "Main Menu";

    public static final String CREATE_BUTTON_LABEL = "Create playlist";


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
