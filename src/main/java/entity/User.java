package entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "User")
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @Column(name = "idUser")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "UserPass")
    private String userPass;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Animal> animals = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Role> role = new HashSet<>();

    public void addAnimal(Animal animal) {
        getAnimals().add(animal);
    }

    public void addRole (Role role) {
        getRole().add(role);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}