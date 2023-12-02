package use_case.getTrackDetails;

import API_calls.GetTrackDetails;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetTrackDetailsHelper {

    // Example song link: "https://open.spotify.com/track/0QVO36SaIlLGXiGZoMG6sO"
    public static List<Object> createTrackDetails(String songLink) throws IOException {
        ArrayList<Object> apiRequest = GetTrackDetails.apiTrackDetails(songLink);
        OkHttpClient client = (OkHttpClient) apiRequest.get(0);
        Request request = (Request) apiRequest.get(1);
        Response songInfo = client.newCall(request).execute();
        ResponseBody responseBody = songInfo.body();
        String jsonResponse = responseBody.string();
        JSONObject jsonInfo = new JSONObject(jsonResponse);
        Integer popularity = jsonInfo.getInt("popularity");
        JSONObject jsonAlbum = jsonInfo.getJSONObject("album");
        String release_date = jsonAlbum.getString("release_date");
        ArrayList<Object> trackDetails = new ArrayList<>();
        trackDetails.add(popularity);
        trackDetails.add(release_date);
        return trackDetails;
    }
}
