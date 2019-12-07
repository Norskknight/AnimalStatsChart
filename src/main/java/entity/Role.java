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
    @Column(name = "roleId")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int iD;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "userName", referencedColumnName = "Username", nullable = false)
    private User user;

    @Override
    public String toString() {
        return super.toString();
    }
}
