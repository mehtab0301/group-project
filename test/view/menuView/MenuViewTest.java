package view.menuView;

import interface_adapter.ViewManagerModel;
import interface_adapter.generate.GenerateViewModel;
import interface_adapter.getSimilarPlaylists.GetSimilarPlaylistsViewModel;
import interface_adapter.getTrackDetails.GetTrackDetailsViewModel;
import org.junit.Before;
import org.junit.Test;
import view.MenuView;

import static org.junit.Assert.assertEquals;

public class MenuViewTest {

    private GenerateViewModel generateViewModel;
    private GetSimilarPlaylistsViewModel getSimilarPlaylistsViewModel;
    private GetTrackDetailsViewModel getTrackDetailsViewModel;
    private ViewManagerModel viewManagerModel;
    private MenuView menuView;

    @Before
    public void setUp() {
        generateViewModel = new GenerateViewModel();
        getSimilarPlaylistsViewModel = new GetSimilarPlaylistsViewModel();
        getTrackDetailsViewModel = new GetTrackDetailsViewModel();
        viewManagerModel = new ViewManagerModel();

        menuView = new MenuView(generateViewModel, getSimilarPlaylistsViewModel, getTrackDetailsViewModel, viewManagerModel);
    }

    @Test
    public void testGenerateButtonActionPerformed() {
        menuView.generate.doClick();
        assertEquals("generate", viewManagerModel.getActiveView());
    }

    @Test
    public void testGetSimilarButtonActionPerformed() {
        menuView.getSimilar.doClick();
        assertEquals("getSimilarPlaylists", viewManagerModel.getActiveView());
    }

    @Test
    public void testGetTrackInfoButtonActionPerformed() {
        menuView.getTrackInfo.doClick();
        assertEquals("getTrackDetails", viewManagerModel.getActiveView());
    }

    @Test
    public void testViewName() {
        assertEquals("menu", menuView.viewName);
    }
}


