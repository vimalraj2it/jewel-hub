package org.jewel.hub.entity.user;
import jakarta.persistence.*;

@Entity
@Table(name = "adminUsermstr") // Define the table name
public class AdminUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_int_id", nullable = false, unique = true, updatable = false)
    private Long userIntId;

    @Column(name = "user_id", nullable = false, unique = true, length = 100)
    private String userId;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "role", nullable = false, length = 255)
    private String role;

    public Long getUserIntId() {
        return userIntId;
    }

    public void setUserIntId(Long userIntId) {
        this.userIntId = userIntId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




}
