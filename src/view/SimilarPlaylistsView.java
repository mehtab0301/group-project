package view;

import entity.SimilarPlaylists;
import interface_adapter.ViewManagerModel;
import interface_adapter.similarPlaylists.SimilarPlaylistsState;
import interface_adapter.similarPlaylists.SimilarPlaylistsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Color;
import java.awt.Font;

public class SimilarPlaylistsView extends JPanel implements ActionListener, PropertyChangeListener, HyperlinkListener {

    public final String viewName = "similarPlaylists";

    private final ViewManagerModel viewManagerModel;
    private final SimilarPlaylistsViewModel similarPlaylistsViewModel;

    private final MenuView menuView;

    public final JButton back;

    // Added JEditorPane for clickable links
    private final JEditorPane editorPane;

    public SimilarPlaylistsView(SimilarPlaylistsViewModel similarPlaylistsViewModel,
                                ViewManagerModel viewManagerModel,
                                MenuView menuView) {
        this.similarPlaylistsViewModel = similarPlaylistsViewModel;
        similarPlaylistsViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = viewManagerModel;
        this.menuView = menuView;

        back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            viewManagerModel.setActiveView(menuView.viewName);
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setEditable(false); // Make it read-only
        editorPane.addHyperlinkListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.removeAll();

        JLabel title = new JLabel(SimilarPlaylistsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        SimilarPlaylistsState state = (SimilarPlaylistsState) evt.getNewValue();
        SimilarPlaylists similarPlaylists = state.getSimilarPlaylists();

        // Build HTML content with clickable links
        StringBuilder htmlContent = new StringBuilder("<html>");
        for (int i = 0; i < similarPlaylists.getSimilarPlaylistsLength(); i++) {
            htmlContent.append("<a href='").append(similarPlaylists.getSimilarPlaylists().get(i)).append("'>")
                    .append(similarPlaylists.getSimilarPlaylists().get(i)).append("</a><br>");
        }

        // Set HTML content to the JEditorPane
        editorPane.setText(htmlContent.toString());

        // Add the editorPane to the panel
        this.add(editorPane);

        this.add(back);
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            // Handle the hyperlink activation here
            String url = e.getDescription();
            System.out.println("Link clicked: " + url);

            // Open the URL in the default web browser
            try {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(new URI(url));
                } else {
                    System.out.println("Desktop browsing not supported on this platform.");
                }
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }
}