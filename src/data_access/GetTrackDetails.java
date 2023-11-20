package data_access;

import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class GetTrackDetails {
    private static final String token = "BQBe14ZC5JRY9sIkWW6_g2cXMvR5MDq9AsA4X3BVX_0fG9bCwkhB_QVYOgWGvQnufjNTvHsPrRU1StyU7Vsf6XQBZH9WylsS40NGpnPytBFerQiTuBdIlD-3-MU5WzNViJ-ZQgZasUF6ZgyWMR5CF7ehrcNjZ8qTJMdtAjHF_xCSBPWuPtFR5xb-qYvx1AhILssAiex5-bhwRNGb5F32SKHd8QuVDHmAdRV-U4PWIlViC6YtpxI08FUk5bxEjCwdwNAG2uHKt0XHZJzj-oc_ebogPwM";
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
