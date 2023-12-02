package use_case.getTrackDetails;

import java.io.IOException;

public interface GetTrackDetailsInputBoundary {
    void execute(GetTrackDetailsInputData getTrackDetailsInputData) throws IOException;
}
