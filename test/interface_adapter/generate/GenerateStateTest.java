package interface_adapter.generate;

import interface_adapter.generate.GenerateState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenerateStateTest {

    @Test
    void gettersAndSetters() {
        // Arrange
        GenerateState generateState = new GenerateState();

        // Act
        generateState.setGenre("Rock");
        generateState.setPopularity(80);
        generateState.setDanceability(0.75F);
        generateState.setValence(0.8F);
        generateState.setSpeechiness(0.6F);
        generateState.setEnergy(0.9F);
        generateState.setNumberOfTracks(15);

        // Assert
        assertEquals("Rock", generateState.getGenre());
        assertEquals(80, generateState.getPopularity());
        assertEquals(0.75F, generateState.getDanceability(), 0.001); // Using delta for float comparison
        assertEquals(0.8F, generateState.getValence(), 0.001);
        assertEquals(0.6F, generateState.getSpeechiness(), 0.001);
        assertEquals(0.9F, generateState.getEnergy(), 0.001);
        assertEquals(15, generateState.getNumberOfTracks());
    }

    @Test
    void copyConstructor() {
        // Arrange
        GenerateState originalState = new GenerateState();
        originalState.setGenre("Pop");
        originalState.setPopularity(60);
        originalState.setDanceability(0.8F);
        originalState.setValence(0.7F);
        originalState.setSpeechiness(0.5F);
        originalState.setEnergy(0.7F);
        originalState.setNumberOfTracks(10);

        // Act
        GenerateState copiedState = new GenerateState(originalState);

        // Assert
        assertEquals(originalState.getGenre(), copiedState.getGenre());
        assertEquals(originalState.getPopularity(), copiedState.getPopularity());
        assertEquals(originalState.getDanceability(), copiedState.getDanceability(), 0.001);
        assertEquals(originalState.getValence(), copiedState.getValence(), 0.001);
        assertEquals(originalState.getSpeechiness(), copiedState.getSpeechiness(), 0.001);
        assertEquals(originalState.getEnergy(), copiedState.getEnergy(), 0.001);
        assertEquals(originalState.getNumberOfTracks(), copiedState.getNumberOfTracks());
    }
}
