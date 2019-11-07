package entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Animal")
@Table(name = "AnimalList")
public class Animal {

    // TODO: 11/6/19 sent to average animal Animal();

    @Id
    @Column(name = "idAnimalList")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "AnimalName")
    private String name;

    @Column(name = "AnimalHealth")
    private int health;

    @Column(name = "AnimalStamina")
    private int stamina;

    @Column(name = "AnimalStrength")
    private int strength;

    @Column(name = "AnimalAgility")
    private int agility;

    @Column(name = "AnimalDexterity")
    private int dexterity;

    @Column(name = "AnimalIntelligence")
    private int intelligence;


    @Override
    public String toString() {
        return super.toString();
    }
}
