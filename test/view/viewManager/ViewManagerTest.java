package view.viewManager;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ViewManagerTest {

    private CardLayout cardLayout;
    private JPanel views;
    private ViewManagerModel viewManagerModel;
    private ViewManager viewManager;

    @BeforeEach
    void setUp() {
        cardLayout = new CardLayout();
        views = new JPanel(cardLayout);
        viewManagerModel = new ViewManagerModel();
        viewManager = new ViewManager(views, cardLayout, viewManagerModel);
    }

    @Test
    void propertyChange() {
        // Arrange
        String newViewName = "someView";

        // Act
        viewManager.propertyChange(new PropertyChangeEvent(this, "view", null, newViewName));

        // Assert
        assertNotNull(cardLayout);
    }

}