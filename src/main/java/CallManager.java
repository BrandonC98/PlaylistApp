import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CallManager {

    private DefaultHttpClient httpClient;
    private DataHandler handler;
    ObjectMapper objectMapper;

    public CallManager()
    {

        httpClient = new DefaultHttpClient();
        handler = new DataHandler();
        objectMapper = new ObjectMapper();

    }

    public HttpResponse MakeSpotifyTokenRequest(){


        ApiCredentials credentials = null;
        SpotifyUrl spotifyUrl = null;

        try {

            spotifyUrl = objectMapper.readValue(handler.GetJson("spotifyUrl"), SpotifyUrl.class);
            credentials = objectMapper.readValue(handler.GetJson("credentials"), ApiCredentials.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpPost postRequest = new HttpPost(spotifyUrl.getBaseTokenUrl() + spotifyUrl.getToken());

        postRequest.addHeader(HttpHeaders.CONTENT_TYPE,  "application/x-www-form-urlencoded");

        String auth = credentials.getSpotifyClientId() + ":" + credentials.getSpotifyClientKey();

        postRequest.addHeader(HttpHeaders.AUTHORIZATION,"Basic " +
                Base64.getEncoder().encodeToString(auth.getBytes()));

        final List<NameValuePair> params = new ArrayList<>();

        params.add(new BasicNameValuePair("grant_type", "client_credentials"));
        UrlEncodedFormEntity formEntity = null;

        try {
            formEntity = new UrlEncodedFormEntity(params, "utf-8");
            formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
            postRequest.setEntity(formEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpResponse response = null;


        try{
            response = httpClient.execute(postRequest);

            if(response.getStatusLine().getStatusCode() != 200)
            {
                throw new RuntimeException("Failed HTTP error: " + response.getStatusLine().getStatusCode());

            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return response;
        
    }

    public HttpResponse MakeSpotifyNewReleaseRequest(String token,String countryCode, int limit)  {

        SpotifyUrl spotifyUrl = null;

        try {

            spotifyUrl = objectMapper.readValue(handler.GetJson("spotifyUrl"), SpotifyUrl.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpGet getRequest = new HttpGet(spotifyUrl.getBaseUrl() + spotifyUrl.getNewReleases() + "country=" + countryCode + "&limit=" + limit);

        getRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        getRequest.addHeader(HttpHeaders.AUTHORIZATION,"Bearer " + token);

        HttpResponse response;

        try {
            response = httpClient.execute(getRequest);

        }catch (Exception e)
        {
            e.printStackTrace();
            response = null;
        }

        return response;

    }

}
