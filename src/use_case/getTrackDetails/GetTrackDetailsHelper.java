package use_case.getTrackDetails;

import API_calls.GetTrackDetails;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetTrackDetailsHelper {

    // Example song link: "https://open.spotify.com/track/0QVO36SaIlLGXiGZoMG6sO"
    public static List<Object> createTrackDetails(String songLink) throws IOException {
        /* returns an arraylist of objects so that
        trackInfo(0) = name of song
        trackInfo(1) = artists
        trackInfo(2) = popolarity
        trackInfo(3) = songlink
        trackInfo(4) = releasedate
         */
        ArrayList<Object> apiRequest = GetTrackDetails.apiTrackDetails(songLink);
        OkHttpClient client = (OkHttpClient) apiRequest.get(0);
        Request request = (Request) apiRequest.get(1);
        Response songInfo = client.newCall(request).execute();
        ResponseBody responseBody = songInfo.body();
        String jsonResponse = responseBody.string();
        JSONObject jsonInfo = new JSONObject(jsonResponse);
        ArrayList<Object> trackInfo = new ArrayList<>();
        Integer popularity = jsonInfo.getInt("popularity");
        String name = jsonInfo.getString("name");
        String release_data = jsonInfo.getJSONObject("album").getString("release_date");
        JSONArray jsonArtists = jsonInfo.getJSONArray("artists");
        ArrayList<String> artists = new ArrayList<>();
        for(int i = 0; i < jsonArtists.length(); ++i){
            artists.add(jsonArtists.getJSONObject(i).getString("name"));
        }
        trackInfo.add(name);
        trackInfo.add(artists);
        trackInfo.add(popularity);
        trackInfo.add(songLink);
        trackInfo.add(release_data);
        return trackInfo;
    }
}
