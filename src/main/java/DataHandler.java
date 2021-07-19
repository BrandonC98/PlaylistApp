import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class DataHandler {

    public String Getjson(String fileName){

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

}
