package app;
import interface_adapter.FirstViewModel;
import interface_adapter.GenerateViewModel;
import interface_adapter.ViewManagerModel;
import view.FirstView;
import view.SecondView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class switch_panel {
    public static void main(String[] args){
        JFrame application = new JFrame("Tempo");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ViewManager manager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

        //Creating instances of the views
        FirstViewModel firstview = new FirstViewModel();
        FirstView firstView = new FirstView(firstview, viewManagerModel);

        GenerateViewModel secondview = new GenerateViewModel();
        SecondView secondView = new SecondView(secondview);

        viewManagerModel.addPropertyChangeListener(firstView);
        viewManagerModel.addPropertyChangeListener(secondView);

        cardPanel.add(firstView);
        cardPanel.add(secondView);

        //viewManagerModel.setActiveView(firstView.viewName);
        //viewManagerModel.firePropertyChanged();

        application.getContentPane().add(cardPanel);


        application.pack();
        application.setVisible(true);



    }

}
