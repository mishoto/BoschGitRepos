package mihail.BoschIO.Repos.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoschIoGithubRepo {

    private final int id;
    private final String full_name;
    private final String description;
    private final String url;
    private final String language;

    public BoschIoGithubRepo(int id, String full_name, String description, String url, String language) {
        this.id = id;
        this.full_name = full_name;
        this.description = description;
        this.url = url;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getLanguage() {
        return language;
    }
}
