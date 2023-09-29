import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class SpotifyApiExample {
    // Note that our token expires every hour, so it must be updated constantly for it to work. We use PostMan to get it done. 
    private static final String token = "BQCyeRKvG8PVjdiGsfnV9ns66jnS3eHCl5FRhAwhIxQSb_JEgr12qscfjWaylFtB23a72Twobksn0r5jWdniYl0fJMhnKtY8e0EYKIIhIK9gEmmB8WdVcdjnI4MaPWNY3KGVfqfDQBKUGPFv1My5B50QdjgUH2LMwPA_wQ8b5aiOKN6xN5EKIBHshxVpgikA-zdaIk7s61_tbdFJZadJt-KloSYpPScvRXT7BOLL4zNhQCH5SfclOsb5Rm1yCQ_0Ty52rAt4NQ";
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
