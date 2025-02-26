package it.dnd.game_elements_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "races")
public class Race implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private int baseSpeed;

    @ManyToMany
    @JoinTable(
            name = "race_languages",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    @ToString.Exclude
    private Set<Language> languages;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String type;

    @Column
    private String subtype;

    @Column(columnDefinition = "TEXT")
    private String ageDescription;

    @Column(columnDefinition = "TEXT")
    private String alignmentDescription;

    private int strengthModifier;
    private int dexterityModifier;
    private int constitutionModifier;
    private int intelligenceModifier;
    private int wisdomModifier;
    private int charismaModifier;

    @Column(columnDefinition = "TEXT")
    private String racialAbilities;

    @Column(columnDefinition = "TEXT")
    private String racialSkillBonuses;

    private int racialHitDice;

    @ManyToOne
    @JoinColumn(name = "favored_class_id")
    private CharacterClass favoredClass;

    @ManyToMany
    @JoinTable(
            name = "race_automatic_languages",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    @ToString.Exclude
    private Set<Language> automaticLanguages;

    @ManyToMany
    @JoinTable(
            name = "race_bonus_languages",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    @ToString.Exclude
    private Set<Language> bonusLanguages;

    private Integer flySpeed;
    private Integer swimSpeed;
    private Integer burrowSpeed;
    private int levelAdjustment;
}
