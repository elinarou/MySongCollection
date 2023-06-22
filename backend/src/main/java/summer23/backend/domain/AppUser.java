package summer23.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    private String firstname;
    private String lastname;
    private String rolestatus;
    private String username;
    private String passwordhash;

    public AppUser() {
        super();
    }

    public AppUser(String firstname, String lastname, String rolestatus, String username, String passwordhash) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.rolestatus = rolestatus;
        this.username = username;
        this.passwordhash = passwordhash;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRolestatus() {
        return rolestatus;
    }

    public void setRolestatus(String rolestatus) {
        this.rolestatus = rolestatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    @Override
    public String toString() {
        return "AppUser [user_id=" + user_id + ", firstname=" + firstname + ", lastname=" + lastname + ", rolestatus="
                + rolestatus + ", username=" + username + ", passwordhash=" + passwordhash + "]";
    }    
    
}
