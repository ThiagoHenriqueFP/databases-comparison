package br.edu.ufersa.dbcomparsion.controllers;

import br.edu.ufersa.dbcomparsion.postgres.UserPostgres;
import br.edu.ufersa.dbcomparsion.postgres.UserPostgresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/postgres")
public class UserPostgresController {
    private final UserPostgresService userPostgresService;
    public UserPostgresController(UserPostgresService userPostgresService) {
        this.userPostgresService = userPostgresService;
    }

    @PostMapping
    public ResponseEntity<?> save (
            @RequestBody UserPostgres user
            ) {
        return ResponseEntity.ok(
             userPostgresService.save(user)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id){
        return ResponseEntity.ok(
                userPostgresService.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable String id,
            @RequestBody UserPostgres user
    ) {
        return ResponseEntity.ok(userPostgresService.update(id, user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        userPostgresService.deleteById(id);
    }
}
