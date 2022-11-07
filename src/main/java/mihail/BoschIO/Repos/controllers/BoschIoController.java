package mihail.BoschIO.Repos.controllers;

import mihail.BoschIO.Repos.models.BoschIoGithubRepo;
import mihail.BoschIO.Repos.service.BoschIoReposClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BoschIoController {

    @Autowired
    BoschIoReposClientService boschIoReposClientService;

    @GetMapping("/bosch-io-repos/all")
    public ResponseEntity<List<BoschIoGithubRepo>> getAllRepos(){
        return ResponseEntity.ok()
                .body(boschIoReposClientService.getBoschIoRepos());
    }

    @GetMapping("/bosch-io-repos/{fullName}")
    public ResponseEntity<BoschIoGithubRepo> filterReposByFullName(@PathVariable String fullName ){
        return ResponseEntity.ok()
                .body(boschIoReposClientService.filterBoschIoReposByFullName(fullName));
    }

    @GetMapping("/bosch-io-repos/{description}")
    public ResponseEntity<BoschIoGithubRepo> filterReposByDescription(@PathVariable String description ){
        return ResponseEntity.ok()
                .body(boschIoReposClientService.filterBoschIoReposByDescription(description));
    }

    @GetMapping("/bosch-io-repos/{language}")
    public ResponseEntity<List<BoschIoGithubRepo>> filterReposByLanguage(@PathVariable String language ){
        return ResponseEntity.ok()
                .body(boschIoReposClientService.filterBoschIoReposByLanguage(language));
    }
}
