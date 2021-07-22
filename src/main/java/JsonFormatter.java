import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonFormatter {

    public static String InputSteamToJson(InputStream stream){


        String jsonContent = "";



            BufferedReader br = new BufferedReader(
                    new InputStreamReader(stream)
            );

            String output = "";

            while(true){
                try {
                    if (!((output = br.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                jsonContent += output + "\n";
            }

            return jsonContent;
    }

}
