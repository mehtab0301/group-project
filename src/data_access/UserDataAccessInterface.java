package data_access;
import entity.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class UserDataAccessInterface {

    public void addUser(Map<String, User> accounts) throws IOException, ParseException {
        JSONObject joe = getFileData();
        JSONArray jar = new JSONArray();

    }
    private boolean checkUserExists(JSONObject data, String Username){

        return data.containsKey(Username);
    }
    private static JSONObject getFileData() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("DataBase/UserInfoDataBase.json"));
        return (JSONObject) obj;
    }
}
