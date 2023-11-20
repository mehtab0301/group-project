package data_access;

import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class GetTrackDetails {
    private static final String token = "BQDsrsSujpz3e-5Uh1B90Hg1r6srPakbiJhAzSwNxqJhfW46peeXHxU-GlO_3eZY7pHeFhJMgC6St3KN5CziFArWf8Eqla98TzyOCSfcx_4fKVzNJFukj_E8zue9DhZU1C-f8MAzAC8M2hscpb-grC-Xrg9sMTzZHy0JKFo_3hKQ6ygzZ1BM1ebPd-d6-mH5hO4K2M15KxcWrBHgYceLAborIjx2cEdNmynXhg";
    static String songLink = "https://open.spotify.com/track/0QVO36SaIlLGXiGZoMG6sO";
    // we'll just ask the user to input the link to the song
    public static void main(String[] args) throws IOException {
        int index = songLink.indexOf("track/");
        String songID = songLink.substring(index + "track/".length()); //removes everything before the trackID
        String api_call = "https://api.spotify.com/v1/tracks/" + songID;
        // the above just gets the track id and combines it to the general api call
        OkHttpClient client = new OkHttpClient(); //builds an http request
        Request request = new Request.Builder().url(api_call).addHeader("Authorization", "Bearer " + token ).build();
        Response songInfo = client.newCall(request).execute();
        ResponseBody responseBody = songInfo.body();
        String jsonResponse = responseBody.string();
        JSONObject jsonInfo = new JSONObject(jsonResponse);
        Integer popularity = jsonInfo.getInt("popularity");
        JSONObject jsonAlbum = jsonInfo.getJSONObject("album");
        String release_date = jsonAlbum.getString("release_date");
        System.out.println(popularity);
        System.out.println(release_date);
    }
}
