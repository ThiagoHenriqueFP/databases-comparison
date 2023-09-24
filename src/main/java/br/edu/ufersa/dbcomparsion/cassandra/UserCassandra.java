package br.edu.ufersa.dbcomparsion.cassandra;

import br.edu.ufersa.dbcomparsion.utils.User;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class UserCassandra {
    @PrimaryKey private final String id;
    private String name;
    private String username;
    private String email;
    private String website;

    public UserCassandra(String name, String username, String email, String website) {
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

    public static UserCassandra fromUser(User u){
        return new UserCassandra(
                u.name(),
                u.username(),
                u.email(),
                u.website()
        );
    }
}
