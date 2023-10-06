package br.edu.ufersa.dbcomparsion.cassandra;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserCassandraService {
    private final UserCassandraRepository userCassandraRepository;

    public UserCassandraService(UserCassandraRepository userCassandraRepository) {
        this.userCassandraRepository = userCassandraRepository;
    }

    public UserCassandra save(UserCassandra user) {
        return userCassandraRepository.save(user);
    }

    public UserCassandra getById(String id){
        return userCassandraRepository.findById(id).orElse(null);
    }

    public UserCassandra update(String id, UserCassandra user){
        UserCassandra savedUser = userCassandraRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.BAD_GATEWAY,
                        "user not found"
                ));

        savedUser.setName(user.getName());
        savedUser.setUsername(user.getUsername());
        savedUser.setEmail(user.getEmail());
        savedUser.setWebsite(user.getWebsite());

        return userCassandraRepository.save(savedUser);
    }

    public void deleteById(String id) {
        userCassandraRepository.deleteById(id);
    }
}
