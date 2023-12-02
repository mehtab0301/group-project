package use_case.getSimilarPlaylists;

import java.io.IOException;

public interface GetSimilarPlaylistsInputBoundary {
    void execute(GetSimilarPlaylistsInputData getSimilarPlaylistsInputData) throws IOException;
}
