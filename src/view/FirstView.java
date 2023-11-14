package view;

import interface_adapter.FinalViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import view.ViewManager;
import interface_adapter.FirstViewModel;
import interface_adapter.ViewManagerModel;

import static interface_adapter.ViewManagerModel.*;

public class FirstView extends JPanel implements PropertyChangeListener, ActionListener {

    public static final String viewName = "Main Menu";

    private final FirstViewModel firstviewmodel;

    private final ViewManagerModel viewManagerModel;
    //private final ViewManager viewManager;

    public FirstView(FirstViewModel firstview, ViewManagerModel manager){
        this.firstviewmodel = firstview;
        this.viewManagerModel = manager;

        //firstview.addPropertyChangeListener(this);


        firstview.addPropertyChangeListener(this);
        manager.addPropertyChangeListener(this); //if we are implementing view manager model then this could work



        // Adding the title to the view
        JLabel title = new JLabel(FirstViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Adding the button to the view
        JPanel buttons = new JPanel();
        JButton create = new JButton(FirstViewModel.CREATE_BUTTON_LABEL);
        buttons.add(create);

        create.addActionListener(this);

        // Adding the button to the view
        JButton merge = new JButton(FirstViewModel.MERGE_BUTTON_LABEL);
        buttons.add(merge);

        merge.addActionListener(this);

        // Choosing the layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        this.add(title);
        this.add(create);
        this.add(merge);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
       // System.out.println("Property Change Event in FirstView");
        if (evt.getPropertyName().equals(viewManagerModel.getActiveView())) {
            // Handle the property change event
            switchToActiveView();
        }

    }

    private void switchToActiveView() {
        // Assuming you have access to the ViewManager instance
        // If not, you might need to pass it to the FirstView constructor
        ViewManager.switchToActiveView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button Clicked");
        if (e.getSource() instanceof JButton) {
            JButton source = (JButton) e.getSource();
            if (source.getText().equals(FirstViewModel.CREATE_BUTTON_LABEL)) {
                System.out.println("Create Button Clicked");
                viewManagerModel.setActiveView(SecondView.viewName);
                System.out.println("Active View after Click: " + viewManagerModel.getActiveView());
                viewManagerModel.firePropertyChanged();
                System.out.println("Active View after Click property changed: " + viewManagerModel.getActiveView());
            }
        }

    }
}
