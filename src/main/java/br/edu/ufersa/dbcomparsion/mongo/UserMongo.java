package br.edu.ufersa.dbcomparsion.mongo;

import br.edu.ufersa.dbcomparsion.utils.User;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class UserMongo {
    private String id;
    private String name;
    private String username;
    private String email;
    private String website;

    public UserMongo(String name, String username, String email, String website) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.username = username;
        this.email = email;
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public static UserMongo fromUser(User u){
        return new UserMongo(
                u.name(),
                u.username(),
                u.email(),
                u.website()
        );
    }
}
