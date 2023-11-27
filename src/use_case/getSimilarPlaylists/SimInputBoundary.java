package use_case.getSimilarPlaylists;

import java.io.IOException;

public interface SimInputBoundary {
    void execute(SimInputData SimInputData) throws IOException;
}
