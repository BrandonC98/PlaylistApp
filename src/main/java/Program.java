import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.auth.Credentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.nio.file.Files;

public class Program {

    public  static  void  main(String[]  args) throws IOException {

        DataHandler handler = new DataHandler();

        ObjectMapper objectMapper = new ObjectMapper();


        ApiCredentials cred = objectMapper.readValue(handler.Getjson("credentials"), ApiCredentials.class);
        SpotifyUrl spotifyUrl = objectMapper.readValue(handler.Getjson("spotifyUrl"), SpotifyUrl.class);


        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpGet getRequest = new HttpGet(
                spotifyUrl.getBaseUrl() + spotifyUrl.getNewReleases() + "country=GB&limit=5"
        );

        getRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        getRequest.addHeader(HttpHeaders.AUTHORIZATION,"Bearer " + cred.getSpotifyToken());

        HttpResponse response;

        try{
            response = httpClient.execute(getRequest);

            if(response.getStatusLine().getStatusCode() != 200)
            {
                throw new RuntimeException("Failed HTTP error: " + response.getStatusLine().getStatusCode());

            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent()))
            );

            String out;
            System.out.println("server output");

            while((out = br.readLine()) != null){
                 System.out.println(out);
            }



        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }


}
