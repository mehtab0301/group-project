import okhttp3.*;
import java.io.IOException;

public class SpotifyAPIGetPlaylists {
    public static void main(String []args) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/users/31sob5m46swjrjmpxoexdv6mzbwq/playlists")
                .method("GET", body)
                .addHeader("Authorization", "Bearer BQAUe6uR9s3D9QO_SlEVBtvpxl7YFj6ZAe9EFswFavsjaHYbrYVP1j0Q2WmA79sZxTyqq55JXjh3Xd9RUogpW23d8s7xy-gWt1kx1sWmx-uXv-gGKneQzrKzipuY33YpnmlEL0VrS--2lyJ9gnZ0gEfr3BHz8zo2XEsPyJBCDn5HyhHZ8iJim2NdytM18VKRNJIcGW1ggXX3uuWu0CZIKsSUdaTs1FWL3k3XrJpeC0aKk0YRTKEm53X_TGsVMMwRwJc18TpJWXP7rNb6wHclYAeOibo")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
