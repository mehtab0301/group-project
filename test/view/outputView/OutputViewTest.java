package view.outputView;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import interface_adapter.output.OutputViewModel;
import org.junit.Assert;
import org.junit.Test;
import view.GetSimilarPlaylistsView;
import view.MenuView;
import view.OutputView;

import javax.swing.*;

import static org.junit.Assert.*;

public class OutputViewTest {

    @Test
    public void testOutputView() {

        OutputViewModel outputViewModel = new OutputViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        GenerateViewModel generateViewModel = new GenerateViewModel();
        GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        GetTrackDetailsViewModel getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        MenuView menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel, getTrackDetailsViewModel,
                viewManagerModel);

        JPanel outputView = new OutputView(outputViewModel, viewManagerModel, generateViewModel, menuView);

        JFrame jf = new JFrame();
        jf.setContentPane(outputView);
        jf.pack();
        jf.setVisible(true);

        Assert.assertNotNull(outputView);
    }
}