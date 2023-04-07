package ucb.internship.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name="users", schema="public")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 1L;
    private String email;
    private String password;

    public User()
    {
    }

    public User(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * @param password The password to be checked
     * @return true if the password is correct, false otherwise
     */
    public boolean authenticate(String password)
    {
        return this.password.equals(password);
    }
}
