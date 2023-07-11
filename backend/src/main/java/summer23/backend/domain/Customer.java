package summer23.backend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 50, message = "This field is required and cannot be empty.")
    private String username;

    @Size(min = 1, max = 50, message = "This field is required and cannot be empty.")
    private String email;

    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Favorite> favorites;

    public Customer() {
        super();
    }

    public Customer(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
    }
    
}
