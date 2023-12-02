package use_case.getSimilarPlaylists;

import API_calls.GetSimilarPlaylists;
import entity.SimilarPlaylists;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static API_calls.GetSimilarPlaylists.numOfPlaylists;

public class GetSimilarPlaylistsHelper {

    public static SimilarPlaylists createSimilarPlaylists(String songName) throws IOException {
        List<Object> getApiCall = GetSimilarPlaylists.getPlaylistApi(songName);
        // get requests necessary for execution
        OkHttpClient client = (OkHttpClient) getApiCall.get(0);
        Request request = (Request) getApiCall.get(1);
        ArrayList<String> playlistLinks = new ArrayList<>();
        Response songInfo = client.newCall(request).execute();
        ResponseBody responseBody = songInfo.body();
        String jsonResponse = responseBody.string();
        JSONObject jsonInfo = new JSONObject(jsonResponse);
        JSONObject jsonPlaylists = jsonInfo.getJSONObject("playlists");
        //The below for loop gets the links and adds it to playlistLinks
        JSONArray jsonItems = jsonPlaylists.getJSONArray("items");
        for (int i = 0; i < numOfPlaylists; i++){
            JSONObject item = jsonItems.getJSONObject(i);
            String link = item.getJSONObject("external_urls").getString("spotify");
            playlistLinks.add(link);
        }
        SimilarPlaylists similarPlaylists = new SimilarPlaylists(playlistLinks);
        return similarPlaylists;
    }
}
