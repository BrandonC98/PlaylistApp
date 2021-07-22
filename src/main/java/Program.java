
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Program {

    public  static  void  main(String[]  args) throws IOException {

        CallManager callManager = new CallManager();
        DataHandler handler = new DataHandler();

        var tokenResponse = callManager.MakeSpotifyTokenRequest();
        var tokenJson = JsonFormatter.InputSteamToJson(tokenResponse.getEntity().getContent());

        var newReleaseResponse = callManager.MakeSpotifyNewReleaseRequest(handler.GetObjectToken(tokenJson).getAccess_token(), "GB", 5);
        var newReleaseJson = JsonFormatter.InputSteamToJson(newReleaseResponse.getEntity().getContent());

        System.out.println(newReleaseJson);


    }




}
