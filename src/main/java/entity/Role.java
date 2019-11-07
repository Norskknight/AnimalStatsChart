package entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Role")
@Table(name = "Role")
public class Role {
    @Id
    @Column(name = "idRole")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int iD;

    @Column(name = "RoleName")
    private String name;

    @Column(name = "idUser")
    private User user;

    @Override
    public String toString() {
        return super.toString();
    }
}
