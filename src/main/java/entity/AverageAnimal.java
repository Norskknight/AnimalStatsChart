package entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@Entity(name = "Animal")
@Table(name = "AnimalList")
public class AverageAnimal {

    // TODO: 11/6/19 get Animal stats for an animal by name

    @Id
    @Column(name = "idAverageAnimalList")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "AverageAnimalName")
    private String name;

    @Column(name = "AverageAnimalHealth")
    private int health;

    private ArrayList healthList;

    @Column(name = "AverageAnimalStamina")
    private int stamina;

    private ArrayList staminaList;

    @Column(name = "AverageAnimalStrength")
    private int strength;

    private ArrayList strengthList;

    @Column(name = "AverageAnimalAgility")
    private int agility;

    private ArrayList agilityList;

    @Column(name = "AverageAnimalDexterity")
    private int dexterity;

    private ArrayList dexterityList;

    @Column(name = "AverageAnimalIntelligence")
    private int intelligence;

    private ArrayList intelligenceList;

    // TODO: 11/6/19 create Standard Deviation removal method for array lists
}
