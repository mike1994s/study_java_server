package dbService.dataSets;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UsersDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true, updatable = false)
    private String login;

    @Column(name ="password", updatable = false)
    private String pass;

    @Column(name ="email", updatable = false)
    private String email;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet(long id, String login, String email, String pass) {
        this.setId(id);
        this.setLogin(login);
        this.setEmail(email);
        this.setPass(pass);
    }

    public UsersDataSet(String login, String email, String pass) {
        this.setId(-1);
        this.setLogin(login);
        this.setEmail(email);
        this.setPass(pass);

    }

    @SuppressWarnings("UnusedDeclaration")
    public String getLogin() {
        return login;
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getEmail() {
        return email;
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getPass() {
        return pass;
    }

    public long getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + login + '\'' +
                '}';
    }
}
