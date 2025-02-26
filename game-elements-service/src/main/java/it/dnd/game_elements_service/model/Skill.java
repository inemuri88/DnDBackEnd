package it.dnd.game_elements_service.model;

import it.dnd.game_elements_service.model.common.CreationUpdate;
import it.dnd.game_elements_service.model.enumerated.Ability;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skills")
public class Skill extends CreationUpdate implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private boolean classSkill;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ability keyAbility;

    /*
    vado a calcolarlo direttamente nel service
    @Column(nullable = false)
    private int skillModifier;
     */

    @Column(nullable = false)
    private int abilityModifier;

    @Column(nullable = false)
    private int ranks;

    @Column(nullable = false)
    private int miscModifier;

    @Column(nullable = false)
    private int maxRanksClass;

    @Column(nullable = false)
    private int maxRanksNotClass;

    @Column(nullable = false)
    private boolean untrained;

    @Column(nullable = false)
    private boolean armourCheckPenality;

    @ManyToMany(mappedBy = "classSkills")
    @ToString.Exclude
    private Set<CharacterClass> classes;

}