import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpotifyApiDataAccessObject
{
    private static final String token = "BQCRWJaZ1qfFvfAaayzE_8Utg9L7OtiQIOR6g6Tz_PmX9RhFr7Xzj8_mwtMxqJvFynYSAOUX9AclqsO2aZAuJSr5BaPlLk16KJBduPXi1gLkntcwr2pPcnP7AmjOQVVp_3oomGw18FDihHtd5u-ZdZbmQ8nm6t55gIjVJgC7GGugqNlSsHhp2EBWSfVd1oM77E-bM0S2KO9V_dpLhJymaPrwGe68pUFUcjX8kWLvdW-3DpyPSPvG6ANFw6LgfP6e8wjzDKY04g";
    static Integer popularity = 5;
    static Float energy = 0.5F;
    static Float speechiness = 0.5F;
    static Float valence = 0.5F;
    static Float danceability = 0.5F;
    static Integer num_of_tracks = 2;
    static String genre = "rock";
    // all of these will need to be replaced with the button values and the token with the users values
    // I used these for testing purposes

    public static void main(String[] args) throws IOException {
        OkHttpClient client = (new OkHttpClient()).newBuilder().build(); //builds an http request
        HttpUrl.Builder urlBuilder = createURL(); //creates the string (see method below)
        Request request = (new Request.Builder()).url(urlBuilder.build()).get().addHeader("Authorization", "Bearer " + token ).build();
        //System.out.println(request); (sends a GET request to get a JSON collection of tracks)
        Response tracks = client.newCall(request).execute(); // stores the tracks in a Response Object (standard practice, not exactly sure)
        //System.out.println(tracks.body().string()); //note, whenever the .string() thing is run, it closes tracks, and it becomes unreadable from then on
        List<String> listTracks = getTracks(tracks);
        System.out.println(listTracks);

        try {
            System.out.println("Response Code: " + tracks.code());
            ResponseBody responseBody = tracks.body();
            if (!tracks.isSuccessful()) {
                String errorBody = responseBody.string();
                System.out.println("Request failed with code: " + tracks.code());
                System.out.println("Error Body: " + errorBody);
                throw new RuntimeException("Check that the genre is input or that the token is refreshed");
            }

            //System.out.println("Response Body: " + String.valueOf(responseBody));
        } finally {
            tracks.close(); //avoids potential errors of closing prematurely (I don't remember exactly, but it could contribute to 400 code)
        } //should be done last! .close, closes tracks and becomes unreadable. Also note .string() does the same thing

    }


    public static HttpUrl.Builder createURL (){ //not super elegant but gets the job done
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.spotify.com/v1/recommendations").newBuilder();
        urlBuilder.addQueryParameter("limit", String.valueOf(num_of_tracks));
        urlBuilder.addQueryParameter("target_popularity", String.valueOf(popularity));
        urlBuilder.addQueryParameter("seed_genres", String.valueOf(genre));
        urlBuilder.addQueryParameter("target_speechiness", String.valueOf(speechiness));
        urlBuilder.addQueryParameter("target_energy", String.valueOf(energy));
        urlBuilder.addQueryParameter("target_valence", String.valueOf(valence));
        urlBuilder.addQueryParameter("target_danceability", String.valueOf(danceability));
        return urlBuilder;
    }

    public static List<String> getTracks(Response response) {
        List<String> trackIds = new ArrayList<>();

        try {
            // Read the response body content
            String responseBody = Objects.requireNonNull(response.body()).string(); //Intellij autocorrected

            // Parse JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            // Access the "tracks" array
            JsonNode tracksArray = objectMapper.readTree(responseBody).path("tracks"); //found this JSON reading method online

            // retrieves the id field and stores it
            for (JsonNode trackNode : tracksArray) {
                String trackId = trackNode.path("id").asText(); //converts JSON to String
                trackIds.add(trackId); // adds to trackIds array
                System.out.println("Track ID: " + trackId); //prints Track ID (with these settings should be Kashmir and Steady as She Goes)
            }

        } catch (IOException e) {
            throw new RuntimeException(e); // necessary for the .string() to work
        }

        return trackIds;
    }

}
