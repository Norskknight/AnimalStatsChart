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

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "idUser", nullable = false)
    private User user;

    @Column(name = "UserName")
    private String userName;

    @Override
    public String toString() {
        return super.toString();
    }
}
