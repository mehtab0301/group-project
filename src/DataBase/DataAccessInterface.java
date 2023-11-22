package DataBase;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import entity.Song;
import java.io.*;
import java.util.*;


public class DataAccessInterface {
    public void addUser(String Username) throws IOException {
        String[] userData = {Username, "", ""};
        CSVWriter writer = new CSVWriter(new FileWriter("UserPlaylists.csv"));
        List<String[]> data = getFileData();

        if(checkUserExists(data, Username)) {
            System.out.println("Username already exists choose new name");
        }
        else {
            data.add(userData);
        }
        writer.writeAll(data);
        writer.close();


    }

    private boolean checkUserExists(List<String[]> data, String username){
        for (String[] line : data) {
            if (line[0].equals(username))
                return true;
        }
        return false;

    }
    public void addPlaylist(ArrayList<Song> playlist,String Username, String playlistName ) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("UserPlaylists.csv"));
        List<String[]> data = getFileData();


    }

    public ArrayList<Song>[] getPlaylist(String playlistName, String username) {
        return null;
    }

    public ArrayList<Song>[] getUserPlaylists(String username) {
        return null;
    }

    private static List<String[]> getFileData(){
        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader("UsersPlaylists.csv")).build();
            return reader.readAll();
        } catch (IOException | CsvException e) {
            System.out.println("broke lmao");
        }
    }
}
