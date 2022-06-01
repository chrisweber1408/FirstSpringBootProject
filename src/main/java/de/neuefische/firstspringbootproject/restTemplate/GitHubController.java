package de.neuefische.firstspringbootproject.restTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//https://api.github.com/users/chrisweber1408/repos

@RestController
@RequestMapping("/github")
public class GitHubController {

    @GetMapping("/user")
    public List<String> getRepositorys(){
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.stream(restTemplate.getForObject("https://api.github.com/users/chrisweber1408/repos", GitHubRepository[].class))
                .map(GitHubRepository::getName)
                .toList();

    }
}
