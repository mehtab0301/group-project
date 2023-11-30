package DataBase;
import API_calls.GetTrackDetails;
import entity.Playlist;
import entity.Song;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.*;
import java.util.*;


public class DataAccessInterface {
    public void addUser(String Username) throws IOException, ParseException {
        JSONObject joe = getFileData();
        JSONArray jar = new JSONArray();
        if(checkUserExists(joe, Username)){
            System.out.println("L");
        }
        else
            joe.put(Username, jar);
        PrintWriter pw = new PrintWriter("/Users/derekdsouza/Documents/Intellij projects/GroupProject/src/DataBase/DataBase.json");
        pw.write(joe.toJSONString());
        pw.flush();
        pw.close();

    }

    private boolean checkUserExists(JSONObject data, String Username){
        return data.containsKey(Username);
    }
    public void addPlaylist(Playlist playlist, String Username) throws IOException, ParseException {
        JSONObject joe = getFileData();
        JSONArray jar = new JSONArray();
        JSONArray userJar = ((JSONArray) joe.get(Username));
        ArrayList<Song> songs = playlist.getSongs();
        for(Song song : songs)
            jar.add(song.getLink());
        userJar.add(jar);
        joe.put(Username, userJar);
        PrintWriter pw = new PrintWriter("/Users/derekdsouza/Documents/Intellij projects/GroupProject/src/DataBase/DataBase.json");
        pw.write(joe.toJSONString());
        pw.flush();
        pw.close();

    }

    public Playlist getPlaylist(JSONArray userPlaylist) throws IOException, ParseException {
        ArrayList<Song> songs = new ArrayList<>();
        for (Object link : userPlaylist) {
            String stringLink = ((String) link);
            GetTrackDetails apiCaller = new GetTrackDetails(stringLink);
            ArrayList<Object> trackInfo = apiCaller.getTrackInfo();
            Song song = new Song((String) trackInfo.get(0),(ArrayList<String>) trackInfo.get(1), (int) trackInfo.get(2), (String) trackInfo.get(4), null);
            songs.add(song);
            }

        Playlist playlist = new Playlist(songs);
        return playlist;
    }

    public ArrayList<Playlist> getAllPlaylists(String Username) throws IOException, ParseException {
        JSONObject joe = getFileData();
        JSONArray userJar = (JSONArray) joe.get(Username);
        ArrayList<Playlist> allPlaylists = new ArrayList<>();
        for(Object playlists : userJar){
            JSONArray playlist = ((JSONArray) playlists);
            allPlaylists.add(getPlaylist(playlist));
        }
        return allPlaylists;
    }

    public int numberOfPlaylists(String Username) throws IOException, ParseException {
        JSONObject joe = getFileData();
        JSONArray userJar = (JSONArray) joe.get(Username);
        return userJar.size();
    }
    private static JSONObject getFileData() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("/Users/derekdsouza/Documents/Intellij projects/GroupProject/src/DataBase/DataBase.json"));
        return (JSONObject) obj;
    }
}
