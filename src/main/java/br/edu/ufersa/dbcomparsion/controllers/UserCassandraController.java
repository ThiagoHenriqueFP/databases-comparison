package br.edu.ufersa.dbcomparsion.controllers;

import br.edu.ufersa.dbcomparsion.cassandra.UserCassandra;
import br.edu.ufersa.dbcomparsion.cassandra.UserCassandraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/users/cassandra")
public class UserCassandraController {
    private final UserCassandraService userCassandraService;
    public UserCassandraController(UserCassandraService userCassandraService) {
        this.userCassandraService = userCassandraService;
    }

    @PostMapping
    public ResponseEntity<?> save (
            @RequestBody UserCassandra user
    ) {
        return ResponseEntity.ok(
                userCassandraService.save(user)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id){
        return ResponseEntity.ok(
                userCassandraService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(
                userCassandraService.getAll()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable String id,
            @RequestBody UserCassandra user
    ) {
        return ResponseEntity.ok(userCassandraService.update(id, user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        userCassandraService.deleteById(id);
    }
}
