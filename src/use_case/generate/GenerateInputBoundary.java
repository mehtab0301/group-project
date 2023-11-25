package use_case.generate;

import java.io.IOException;

public interface GenerateInputBoundary {
    void execute(GenerateInputData generateInputData) throws IOException;
}
