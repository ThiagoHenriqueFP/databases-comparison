package br.edu.ufersa.dbcomparsion.controllers;

import br.edu.ufersa.dbcomparsion.mongo.UserMongo;
import br.edu.ufersa.dbcomparsion.mongo.UserMongoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/mongo")
public class UserMongoController {
    private final UserMongoService userMongoService;
    public UserMongoController(UserMongoService userMongoService) {
        this.userMongoService = userMongoService;
    }

    @PostMapping
    public ResponseEntity<?> save (
            @RequestBody UserMongo user
    ) {

        UserMongo u = new UserMongo(
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getWebsite()
        );

        return ResponseEntity.ok(
                userMongoService.save(u)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id){
        return ResponseEntity.ok(
                userMongoService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(
                userMongoService.getAll()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable String id,
            @RequestBody UserMongo user
    ) {
        return ResponseEntity.ok(userMongoService.update(id, user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        userMongoService.deleteById(id);
    }
}
