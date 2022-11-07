package mihail.BoschIO.Repos;

import mihail.BoschIO.Repos.models.BoschIoGithubRepo;
import mihail.BoschIO.Repos.service.BoschIoReposClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BoschIoReposApplication {

	private static final Logger log = LoggerFactory.getLogger(BoschIoReposApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(BoschIoReposApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BoschIoReposClientService boschIoReposClientService){
		return args -> {
		List<BoschIoGithubRepo> repos = boschIoReposClientService.getBoschIoRepos();
		log.info("List with {} repos are fetched", repos.size());

		String message = boschIoReposClientService.writeJsonDataToFile(repos);
		log.info(message);
		};
	}
}
