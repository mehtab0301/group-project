package app;

import interface_adapter.GenerateViewModel;
import view.GenerateView;
import view.ViewManager;
import interface_adapter.ViewManagerModel;
import view.FirstView;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Tempo");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);


        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        GenerateViewModel generateViewModel = new GenerateViewModel();

        GenerateView generateView = new GenerateView(generateViewModel);
        views.add(generateView);



        viewManagerModel.setActiveView(generateView.viewName);
        viewManagerModel.firePropertyChanged();


        application.pack();
        application.setVisible(true);
    }
}