package br.edu.ufersa.dbcomparsion.utils;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RetrieveUsers {
    private List<User> users = new ArrayList<>();
    private final RestTemplate rt = new RestTemplate();


    public void fetchUsers() {
        users = List.of(Objects.requireNonNull(rt.getForEntity(
                "https://jsonplaceholder.typicode.com/users",
                User[].class
        ).getBody()));
    }

    public List<User> getUsers() {
        return users;
    }
}
