package mihail.BoschIO.Repos.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import mihail.BoschIO.Repos.configs.GithubApiConnection;
import mihail.BoschIO.Repos.models.BoschIoGithubRepo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoschIoReposClientService {

    private final RestOperations restOperations;
    private final String githubUrl;

    public BoschIoReposClientService(final RestTemplateBuilder restTemplateBuilder,
                              final GithubApiConnection githubApiConnectionProps) {

        this.restOperations = restTemplateBuilder
                .setReadTimeout(githubApiConnectionProps.getReadTimeout())
                .setConnectTimeout(githubApiConnectionProps.getConnectTimeout())
                .build();

        this.githubUrl = githubApiConnectionProps.getUrl();
    }

    public List<BoschIoGithubRepo> getBoschIoRepos(){
        ResponseEntity<List<BoschIoGithubRepo>> exchange = restOperations.exchange(githubUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<BoschIoGithubRepo>>() {
        });
        return exchange.getBody();
    }

    public String writeJsonDataToFile(List<BoschIoGithubRepo> boschIoGithubRepoList) {
        String message;
        try(FileWriter file = new FileWriter("bosch-io-repos.json")){
            file.write(new Gson().toJson(boschIoGithubRepoList));
            file.flush();
            message = "Successfully write repositories list to file";
        }catch (IOException ex){
            message = "Write to file failed";
            ex.getCause();
            ex.printStackTrace();
        }
        return message;
    }

    public List<BoschIoGithubRepo> readJsonDataFromFile(Path path){
        List<BoschIoGithubRepo> repos = new ArrayList<>();
        try{
            String reposAsJson = Files.readString(path);
            repos = new Gson().fromJson(reposAsJson, new TypeToken<List<BoschIoGithubRepo>>(){}.getType());

        }catch(IOException ex){
            ex.getCause();
            ex.printStackTrace();
        }
        return repos;
    }

    public List<BoschIoGithubRepo> getAllBoschIoReposFromFile(){
        return readJsonDataFromFile(Path.of("bosch-io-repos.json"));
    }

    public BoschIoGithubRepo filterBoschIoReposByFullName(String fullName){
        List<BoschIoGithubRepo> repos = readJsonDataFromFile(Path.of("bosch-io-repos.json"));
        return repos.stream()
                    .filter(repo -> repo.getFull_name().equals(fullName))
                    .findAny()
                    .orElse(null);
    }

    public BoschIoGithubRepo filterBoschIoReposByDescription(String description){
        List<BoschIoGithubRepo> repos = readJsonDataFromFile(Path.of("bosch-io-repos.json"));
        return repos.stream()
                    .filter(repo -> (repo.getDescription() != null && repo.getDescription().equals(description)))
                    .findAny()
                    .orElse(null);
    }

    public List<BoschIoGithubRepo> filterBoschIoReposByLanguage(String language){
        List<BoschIoGithubRepo> repos = readJsonDataFromFile(Path.of("bosch-io-repos.json"));
        return repos.stream()
                .filter(repo -> (repo.getLanguage() != null && repo.getLanguage().equals(language)))
                .collect(Collectors.toUnmodifiableList());
    }
}
