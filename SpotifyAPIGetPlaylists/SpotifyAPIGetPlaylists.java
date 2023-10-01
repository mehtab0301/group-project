package SpotifyAPIGetPlaylists;

import java.io.*;
import okhttp3.*;
public class SpotifyAPIGetPlaylists {
    public static void main(String []args) throws IOException{
        // Note that the token will expire in one hour.
        String token = "BQAbuG2wxNfhZMhYFegx9ZR_OclJ-6NSDLTQU9lAO_MoTcAi1imKX00fGVL3RdpLLwWYmy_34sqXdkWKb-tp77rNT7Fq0w5GAeBL41crZ7JlIE6goa82uiOmjrno7m-zC6uNJ50fGNyLYjSMd7X32ReacgR63Dakc8xYvT7AUsomk5EBvngZvioDxhHIWVL-2Yd4gYFIqQrlx2vA3Ibd1-_TC5EOhQ53lVqxTj6wiDjISkf_x3iOz6t63js-_1gm7mSdePu4GMyZaCe0FuO6YUFaJTA";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        // RequestBody body = RequestBody.create(mediaType, "");

        // Sample userID from one group member
        String userID = "31sob5m46swjrjmpxoexdv6mzbwq";

        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/users/" + userID + "/playlists")
                // .method("GET", body)
                .addHeader("Authorization", "Bearer " + token)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}