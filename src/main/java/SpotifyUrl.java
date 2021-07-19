public class SpotifyUrl {

    private String baseUrl;
    private String newReleases;

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

    private void setNewReleases(String newReleases) {
        this.newReleases = newReleases;
    }

}
