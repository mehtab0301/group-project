import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class SpotifyApiExample {
    // Note that our token expires every hour, so it must be updated constantly for it to work. We use PostMan to get it done. 
    private static final String token = "BQCpE_Upju9D8m-EKULQ2OqCBWOgB1Vx47F3YmO6zvuzcWIauWroppykYnfFrMcVuQtMsJch831vCVrsEssVtxkezZ314G_aIE7JFJZhSVAAy1uhsgGEnJCa0c2_Q2ZbBoITzTnuYG4rW8lKTlLnl7MgsD1d1L3QfrWBlvCszqaiCF7UalQQT1pv1GpOVljGH8pLUs6IjgEWuwHTYnUjkhm8iiQaon4jANZqjg";
    private static final String url = "https://api.spotify.com/v1/browse/new-releases";

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(url)
                //.method("GET", null)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            if (response.code() == 200) {
                System.out.println(responseBody.toString());
            } else {
                throw new RuntimeException("ERROR, please :)");
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
