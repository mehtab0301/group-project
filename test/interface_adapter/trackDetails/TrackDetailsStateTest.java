package interface_adapter.trackDetails;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TrackDetailsStateTest {

    @Test
    void gettersAndSetters_workCorrectly() {
        // Arrange
        TrackDetailsState trackDetailsState = new TrackDetailsState();

        // Act and Assert
        assertNull(trackDetailsState.getTrackInfo());
        assertEquals(0, trackDetailsState.getNumOfInfo());

        // Set values
        List<Object> infoList = Arrays.asList("Title: Song Title", "Artist: Artist Name", "Duration: 3:30");
        trackDetailsState.setTrackInfo(infoList);

        // Assert after setting values
        assertEquals(infoList, trackDetailsState.getTrackInfo());
        assertEquals(infoList.size(), trackDetailsState.getNumOfInfo());
    }

    @Test
    void copyConstructor_worksCorrectly() {
        // Arrange
        TrackDetailsState originalState = new TrackDetailsState();
        List<Object> infoList = Arrays.asList("Title: Song Title", "Artist: Artist Name", "Duration: 3:30");
        originalState.setTrackInfo(infoList);

        // Act
        TrackDetailsState copiedState = new TrackDetailsState(originalState);

        // Assert
        assertEquals(originalState.getTrackInfo(), copiedState.getTrackInfo());
        assertEquals(originalState.getNumOfInfo(), copiedState.getNumOfInfo());
    }
}
