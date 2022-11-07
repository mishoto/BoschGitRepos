package mihail.BoschIO.Repos.controllers;

import mihail.BoschIO.Repos.models.BoschIoGithubRepo;
import mihail.BoschIO.Repos.service.BoschIoReposClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoschIoController {

    @Autowired
    BoschIoReposClientService boschIoReposClientService;

    @GetMapping(path = "/bosch-io-repos/all-from-github-api", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BoschIoGithubRepo>> getAllReposFromGithub(){
        return ResponseEntity.ok()
                .body(boschIoReposClientService.getBoschIoRepos());
    }

    @GetMapping(path = "/bosch-io-repos/all-from-json-file", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BoschIoGithubRepo>> getAllReposFromFile(){
        return ResponseEntity.ok()
                .body(boschIoReposClientService.getAllBoschIoReposFromFile());
    }

    @GetMapping(path = "/bosch-io-repos/filter-by-name", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoschIoGithubRepo> filterReposByFullName(@RequestParam("fullName") String fullName ){
        return ResponseEntity.ok()
                .body(boschIoReposClientService.filterBoschIoReposByFullName(fullName));
    }

    @GetMapping(path = "/bosch-io-repos/filter-by-description", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoschIoGithubRepo> filterReposByDescription(@RequestParam("description") String description ){
        return ResponseEntity.ok()
                .body(boschIoReposClientService.filterBoschIoReposByDescription(description));
    }

    @GetMapping(path = "/bosch-io-repos/filter-by-language", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BoschIoGithubRepo>> filterReposByLanguage(@RequestParam("language") String language ){
        return ResponseEntity.ok()
                        .body(boschIoReposClientService.filterBoschIoReposByLanguage(language));
    }
}
