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
    public  void addUser(String Username) throws IOException, ParseException {
        JSONObject joe = getFileData();
        Map m = new LinkedHashMap();
        if(checkUserExists(joe, Username)){
            System.out.println("L");
        }
        else
            joe.put(Username, m);
        PrintWriter pw = new PrintWriter("/Users/derekdsouza/Documents/Intellij projects/GroupProject/src/DataBase/DataBase.json");
        pw.write(joe.toJSONString());
        pw.flush();
        pw.close();

    }

    private boolean checkUserExists(JSONObject data, String Username){
        return data.containsKey(Username);
    }
    public void addPlaylist(Playlist playlist, String Username, String playlistName) throws IOException, ParseException {
        JSONObject joe = getFileData();
        JSONArray jar = new JSONArray();
        Map m = ((Map) joe.get(Username));
        ArrayList<Song> songs = playlist.getSongs();
        for(Song song : songs)
            jar.add(song.getLink());
        m.put(playlistName, jar);
        joe.put(Username, m);
        PrintWriter pw = new PrintWriter("/Users/derekdsouza/Documents/Intellij projects/GroupProject/src/DataBase/DataBase.json");
        pw.write(joe.toJSONString());
        pw.flush();
        pw.close();

    }

    public Playlist getPlaylist(String playlistName, String Username) throws IOException, ParseException {
        JSONObject joe = getFileData();
        Map m = ((Map) joe.get(Username));
        ArrayList<String> playlistLinks = ((ArrayList<String>) m.get(playlistName));
        ArrayList<Song> songs = new ArrayList<>();
        for(String link : playlistLinks) {
            GetTrackDetails apiCaller = new GetTrackDetails(link);
            ArrayList<Object> trackInfo = apiCaller.getTrackInfo();
            Song song = new Song((String) trackInfo.get(0),(ArrayList<String>) trackInfo.get(1), (int) trackInfo.get(2), (String) trackInfo.get(4), null);
            songs.add(song);
        }
        Playlist playlist = new Playlist(songs, playlistName);
        return playlist;
    }

    public ArrayList<Playlist> getAllPlaylists(String Username) throws IOException, ParseException {
        JSONObject joe = getFileData();
        Map m = ((Map) joe.get(Username));
        ArrayList<Playlist> allPlaylists = new ArrayList<>();
        for(Object key : m.keySet()){
            allPlaylists.add(getPlaylist((String) key, Username));
        }
        return allPlaylists;
    }

    private JSONObject getFileData() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("/Users/derekdsouza/Documents/Intellij projects/GroupProject/src/DataBase/DataBase.json"));
        return (JSONObject) obj;
    }
}
