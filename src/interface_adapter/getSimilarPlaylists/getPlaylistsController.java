package interface_adapter.getSimilarPlaylists;

import use_case.getSimilarPlaylists.SimInputData;
import use_case.getSimilarPlaylists.SimInputBoundary;

public class getPlaylistsController {

    final SimInputBoundary usecase;

    public getPlaylistsController(SimInputBoundary usecase) {
        this.usecase = usecase;
    }

    public void execute(String name){
        SimInputData inputdata = new SimInputData(name);
        this.usecase.execute(inputdata);
    }
}
