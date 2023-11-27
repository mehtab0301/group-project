package interface_adapter.getSimilarPlaylists;

import use_case.getSimilarPlaylists.SimInputData;
import use_case.getSimilarPlaylists.SimInputBoundary;

import java.io.IOException;

public class getPlaylistsController {

    final SimInputBoundary usecase;

    public getPlaylistsController(SimInputBoundary usecase) {
        this.usecase = usecase;
    }

    public void execute(String name) throws IOException {
        SimInputData inputdata = new SimInputData(name);
        this.usecase.execute(inputdata);
    }
}
