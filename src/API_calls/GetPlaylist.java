package API_calls;

import API_calls.GetToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetPlaylist
{
    private static final String token = GetToken.getToken();
    public static ArrayList<Object> getPlaylistCall(int popularity, float energy, float speechiness, float valence, float danceability,
                                                    int num_of_tracks, String genre) throws IOException {
        OkHttpClient client = (new OkHttpClient()).newBuilder().build(); //builds an http request
        HttpUrl.Builder urlBuilder = createURL(); //creates the string (see method below)
        Request request = (new Request.Builder()).url(urlBuilder.build()).get().addHeader("Authorization", "Bearer " + token ).build();
        //System.out.println(request); (sends a GET request to get a JSON collection of tracks)
        ArrayList <Object> returnedList = new ArrayList<>();
        returnedList.add(client);
        returnedList.add(request);
        return returnedList;
    }


    public static HttpUrl.Builder createURL (){ //not super elegant but gets the job done
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.spotify.com/v1/recommendations").newBuilder();
        urlBuilder.addQueryParameter("limit", String.valueOf(num_of_tracks));
        urlBuilder.addQueryParameter("max_popularity", String.valueOf(popularity));
        urlBuilder.addQueryParameter("min_popularity", String.valueOf(Math.max(popularity-10, 0)));
        urlBuilder.addQueryParameter("seed_genres", String.valueOf(genre));
        urlBuilder.addQueryParameter("target_speechiness", String.valueOf(speechiness));
        urlBuilder.addQueryParameter("target_energy", String.valueOf(energy));
        urlBuilder.addQueryParameter("target_valence", String.valueOf(valence));
        urlBuilder.addQueryParameter("target_danceability", String.valueOf(danceability));
        return urlBuilder;
    }
}
