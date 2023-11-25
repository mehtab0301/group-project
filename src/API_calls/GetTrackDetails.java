package API_calls;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;

public class GetTrackDetails {
    private static final String token = GetToken.getToken();
    // we'll just ask the user to input the link to the song
    public static ArrayList<Object> apiTrackDetails(String songLink) throws IOException {
        int index = songLink.indexOf("track/");
        String songID = songLink.substring(index + "track/".length()); //removes everything before the trackID
        String api_call = "https://api.spotify.com/v1/tracks/" + songID;
        // the above just gets the track id and combines it to the general api call
        OkHttpClient client = new OkHttpClient(); //builds an http request
        Request request = new Request.Builder().url(api_call).addHeader("Authorization", "Bearer " + token ).build();

        ArrayList<Object> apiRequests = new ArrayList<>();
        apiRequests.add(client);
        apiRequests.add(request);
        return apiRequests;
    }
}
