package API_calls;

import API_calls.GetToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GetSimilarPlaylists {
    private static final String token = GetToken.getToken();
    // implement getSongName method, which will return a song name from the SpotifyAPIDataObject list
    public static Integer numOfPlaylists = 3;
    static String playlistStringNum = String.valueOf(numOfPlaylists);

    // Once again, these values (except the token) need to be connected to the user input. The below function returns
    public static ArrayList<Object> getPlaylistApi(String songName) throws IOException {
        String api_call = "https://api.spotify.com/v1/search?q=remaster%2520" + URLEncoder.encode("track:" +
                songName, StandardCharsets.UTF_8) + "&type=playlist&limit=" + playlistStringNum +"&offset=0";
        // the above gets a search call to the spotify API

        OkHttpClient client = new OkHttpClient(); //builds an http request

        Request request = new Request.Builder().url(api_call).addHeader("Authorization", "Bearer " + token ).build();

        // Everything below this can be added into the DataAccessObject. It does the API call,
        // filters to the playlist links and adds it to the playlistLinks ArrayList
        ArrayList<Object> apiRequests = new ArrayList<>();
        apiRequests.add(client);
        apiRequests.add(request);
        return apiRequests;

    }
}
