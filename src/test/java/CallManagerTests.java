import org.apache.http.HttpResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import  org.testng.Assert;

import java.io.IOException;

public class CallManagerTests {

    private HttpResponse response;

    @BeforeTest
    public void Setup() throws IOException {

        CallManager callManager = new CallManager();
        response = callManager.MakeSpotifyTokenRequest();

    }

    @Test
    public  void  WhenMakeSpotifyTokenRequestIsCalled_ItReturnsA200Code() {


        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);

    }

    @Test
    public  void  WhenMakeSpotifyTokenRequestIsCalled_3600IsSetAsTheExpireTime() throws IOException {

        DataHandler handler = new DataHandler();
        var tokenJson = JsonFormatter.InputSteamToJson(response.getEntity().getContent());

        Assert.assertEquals(handler.GetObjectToken(tokenJson).getExpires_in(), 3600);

    }


}
