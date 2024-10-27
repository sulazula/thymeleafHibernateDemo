package pl.sulazula.thymeleafDBapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="userslist")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "f_name")
    private String f_name;
    @Column(name = "l_name")
    private String l_name;

    public User() {
    }

    public User(Long id, String fName, String lName) {
        this.id = id;
        this.f_name = fName;
        this.l_name = lName;
    }
}
