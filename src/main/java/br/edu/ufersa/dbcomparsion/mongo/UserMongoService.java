package br.edu.ufersa.dbcomparsion.mongo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserMongoService {
    private final UserMongoRepository userMongoRepository;

    public UserMongoService(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    public UserMongo save(UserMongo user) {
        return userMongoRepository.save(user);
    }

    public UserMongo getById(String id){
        return userMongoRepository.findById(id).orElse(null);
    }

    public UserMongo update(String id, UserMongo user){
        UserMongo savedUser = userMongoRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.BAD_GATEWAY,
                        "user not found"
                ));

        savedUser.setName(user.getName());
        savedUser.setUsername(user.getUsername());
        savedUser.setEmail(user.getEmail());
        savedUser.setWebsite(user.getWebsite());

        return userMongoRepository.save(savedUser);
    }
    public void deleteById(String id) {
        userMongoRepository.deleteById(id);
    }

}
