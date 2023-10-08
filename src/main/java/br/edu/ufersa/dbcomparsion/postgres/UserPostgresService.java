package br.edu.ufersa.dbcomparsion.postgres;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserPostgresService {
    private final UserPostgresRepository userPostgresRepository;

    public UserPostgresService(UserPostgresRepository userPostgresRepository) {
        this.userPostgresRepository = userPostgresRepository;
    }

    public UserPostgres save(UserPostgres user) {
        return userPostgresRepository.save(user);
    }

    public UserPostgres getById(String id){
        return userPostgresRepository.findById(id).orElse(null);
    }

    public UserPostgres update(String id, UserPostgres user){
        UserPostgres savedUser = userPostgresRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.BAD_GATEWAY,
                        "user not found"
                ));

        savedUser.setName(user.getName());
        savedUser.setUsername(user.getUsername());
        savedUser.setEmail(user.getEmail());
        savedUser.setWebsite(user.getWebsite());

        return userPostgresRepository.save(savedUser);
    }

    public void deleteById(String id) {
        userPostgresRepository.deleteById(id);
    }

    public List<UserPostgres> getAll() {
        return userPostgresRepository.findAll();
    }
}
