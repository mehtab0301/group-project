package API_calls;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class GetTrackDetails {
    private static final String token = GetToken.getToken();
    String songLink;
    // we'll just ask the user to input the link to the song
    //commenting this out because getTrackInfo does the same but takes a link as input
    /*
    public static void main(String[] args) throws IOException {
        int index = songLink.indexOf("track/");
        String songID = songLink.substring(index + "track/".length()); //removes everything before the trackID
        String api_call = "https://api.spotify.com/v1/tracks/" + songID;
        // the above just gets the track id and combines it to the general api call
        JSONObject jsonInfo = apiCall(api_call);
        Integer popularity = jsonInfo.getInt("popularity");
        JSONObject jsonAlbum = jsonInfo.getJSONObject("album");
        String release_date = jsonAlbum.getString("release_date");
        System.out.println(popularity);
        System.out.println(release_date);
    }*/

    public GetTrackDetails(String songLink) {
        this.songLink = songLink;
    }
    public ArrayList<Object> getTrackInfo() throws IOException {
        JSONObject jsonInfo = apiCall(songLink);
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
        trackInfo.add(release_data);
        trackInfo.add(songLink);
        return trackInfo;
    }

    private JSONObject apiCall (String songLink) throws IOException {
        String api_call = songLink;
        OkHttpClient client = new OkHttpClient(); //builds an http request
        Request request = new Request.Builder().url(api_call).addHeader("Authorization", "Bearer " + token ).build();
        Response songInfo = client.newCall(request).execute();
        ResponseBody responseBody = songInfo.body();
        String JSONResponse = responseBody.string();
        JSONObject jsonInfo = new JSONObject(JSONResponse);
        return jsonInfo;
    }
}
