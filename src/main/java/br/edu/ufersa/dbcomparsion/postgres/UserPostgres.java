package br.edu.ufersa.dbcomparsion.postgres;

import br.edu.ufersa.dbcomparsion.cassandra.UserCassandra;
import br.edu.ufersa.dbcomparsion.utils.User;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table( name = "users")
public class UserPostgres {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String username;
    private String email;
    private String website;

    public UserPostgres() {
    }

    public UserPostgres(String name, String username, String email, String website) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.username = username;
        this.email = email;
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public static UserPostgres fromUser(User u){
        return new UserPostgres(
                u.name(),
                u.username(),
                u.email(),
                u.website()
        );
    }

}
