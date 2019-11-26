package entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "AverageAnimal")
@Table(name = "AverageAnimals")
public class AverageAnimal {

    // TODO: 11/6/19 get Animal stats for an animal by name

    @Id
    @Column(name = "idAnimals")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "AnimalsName")
    private String name;

    @Column(name = "AnimalsClass")
    private String animalClass;

    @Column(name = "AnimalsFiction")
    private String fiction;

    @Column(name = "AnimalsHealth")
    private int health;


    @Column(name = "AnimalsStamina")
    private int stamina;


    @Column(name = "AnimalsStrength")
    private int strength;


    @Column(name = "AnimalsAgility")
    private int agility;

    @Column(name = "AnimalsDexterity")
    private int dexterity;


    @Column(name = "AnimalsIntelligence")
    private int intelligence;

    @Override
    public String toString() {
        return super.toString();
    }

// TODO: 11/6/19 create Standard Deviation removal method for array lists
}
