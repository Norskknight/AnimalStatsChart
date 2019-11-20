package entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Animal")
@Table(name = "Animals")
public class Animal {

    public Animal(String name, String animalClass, String fiction, int health, int stamina, int strength, int agility, int dexterity, int intelligence, User user) {
        this.name = name;
        this.animalClass = animalClass;
        this.fiction = fiction;
        this.health = health;
        this.stamina = stamina;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.user = user;
    }

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

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "idUser")
    private User user;

    public Animal() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
