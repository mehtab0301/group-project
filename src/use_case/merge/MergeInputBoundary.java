package use_case.merge;

import java.io.IOException;

public interface MergeInputBoundary {
    void execute(MergeInputData mergeInputData) throws IOException;
}
