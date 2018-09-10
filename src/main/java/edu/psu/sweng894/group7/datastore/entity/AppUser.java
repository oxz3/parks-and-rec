package edu.psu.sweng894.group7.datastore.entity;
import javax.persistence.*;
import java.util.List;

/**
 *  Enity to manage user accounts
 */
@Entity
@SequenceGenerator(name="AppUser_SEQ", sequenceName="AppUser_Seq")
@NamedQuery(query = "select u from AppUser u", name = "query_find_all_users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="AppUser_SEQ")
    private Long userId;
    private String username;
    private String password;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<UserRole> roles;

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    //only set method to set the password allowed.
    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getName() {
        return username;
    }

    @Override
    public String toString() {
        String roleNames="";
        for(UserRole role: roles)
            roleNames=roleNames+","+role.getRolename();

        roleNames=roleNames.substring(0,roleNames.length());
        return String.format("AppUser [id=%s, name=%s, role=%s]", userId, username, roleNames);
    }

}
