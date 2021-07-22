public class SpotifyUrl {

    private String baseUrl;
    private String newReleases;
    private String baseTokenUrl;
    private String token;

    private void setBaseUrl(String baseUrl)
    {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public String getNewReleases() {
        return newReleases;
    }

    public String getBaseTokenUrl() {
        return baseTokenUrl;
    }

    public String getToken()
    {
        return token;
    }

    private void setToken(String token){
        this.token = token;
    }

    private void setBaseTokenUrl(String baseTokenUrl){
        this.baseTokenUrl = baseTokenUrl;
    }

    private void setNewReleases(String newReleases) {
        this.newReleases = newReleases;
    }

}
