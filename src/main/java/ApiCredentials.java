public class ApiCredentials {

    private String spotifyToken;
    private String spotifyClientId;
    private String spotifyClientKey;

    public String getSpotifyToken()
    {
        return spotifyToken;
    }
    public void setSpotifyToken(String token)
    {
        spotifyToken = token;
    }

    public String getSpotifyClientId(){
        return spotifyClientId;
    }

    private void setSpotifyClientId(String spotifyClientId) {
        this.spotifyClientId = spotifyClientId;
    }

    public void setSpotifyClientKey(String spotifyClientKey) {
        this.spotifyClientKey = spotifyClientKey;
    }

    public String getSpotifyClientKey() {
        return spotifyClientKey;
    }
}
