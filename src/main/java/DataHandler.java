import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class DataHandler {

    public String GetJson(String fileName){

        File file = new File(getClass().getResource(fileName + ".json").getPath());
        String Json = "";
        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                Json += scanner.nextLine() + "\n";
            }
        }catch (Exception e){

            e.printStackTrace();
        }

        return  Json;

    }

    public SpotifyTokenResponse GetObjectToken(String HttptokenResponse){

        ObjectMapper objectMapper = new ObjectMapper();

        SpotifyTokenResponse tokenResponse = null;

        try{
            tokenResponse = objectMapper.readValue(HttptokenResponse, SpotifyTokenResponse.class);

        }catch (Exception e){
            e.printStackTrace();
        }

        return tokenResponse;

    }

}
