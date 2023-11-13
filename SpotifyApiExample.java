import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class SpotifyApiExample {
    // Note that our token expires every hour, so it must be updated constantly for it to work. We use PostMan to get it done. 
    private static final String token = "BQBGiAGSWiQ6CFmyGLR9A-9sjh4dhgN-U4czUUGXUhqV_42c0ns3K0C3PXPEg4i9qOkUFI9nNweRy25y4hIlIfigHdKaQLM83BHPQnokiQQ4Yat8HJyuuB76_37UWsj2GQGgtK6V8JhfmArO-RkBlqApXra1UBIqo_ZbM2Sb7Aix9iVuNuqFelJXRjCLxnJLZIGdRNvGg5yU7euHVYq-vrsQoCUYyNyceYwiXw";
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
