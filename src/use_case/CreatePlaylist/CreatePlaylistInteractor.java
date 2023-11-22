package use_case.CreatePlaylist;

import API_calls.GetToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import API_calls.GetPlaylist;

public class CreatePlaylistInteractor {

    private static final String token = GetToken.getToken();
    static int popularity = 5;
    static float energy = 0.5F;
    static float speechiness = 0.5F;
    static float valence = 0.5F;
    static float danceability = 0.5F;
    static int num_of_tracks = 2;
    static String genre = "rock";
    public void generatePlaylists() throws IOException {
        ArrayList<Object> api_call = GetPlaylist.getPlaylistCall(popularity, energy, speechiness, valence, danceability, num_of_tracks, genre);
        OkHttpClient client = (OkHttpClient) api_call.get(0);
        Request request = (Request) api_call.get(1); //info from api_call method

        Response tracks = client.newCall(request).execute(); // stores the tracks in a Response Object (standard practice, not exactly sure)
        //System.out.println(tracks.body().string()); //note, whenever the .string() thing is run, it closes tracks, and it becomes unreadable from then on

        List<String> listTracks = getTrackLinks(tracks);
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

    public static List<String> getTrackLinks(Response response){
        List<String> trackLinks = new ArrayList<>();
        List<String> local_tracks = getTracks(response);

        for (String trackId : local_tracks) {
            String trackLink = "https://open.spotify.com/track/" + trackId;
            trackLinks.add(trackLink);
            System.out.println("Link: " + trackLink); //prints Track ID (with these settings should be Kashmir and Steady as She Goes)
        }

        return trackLinks;
    }
}
