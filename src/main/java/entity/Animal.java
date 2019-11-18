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
    @Column(name = "idAnimalList")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "AnimalName")
    private String name;

    @Column(name = "AnimalClass")
    private String animalClass;

    @Column(name = "AnimalFiction")
    private String fiction;

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

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "idUser")
    private User user;

    @Override
    public String toString() {
        return super.toString();
    }
}
