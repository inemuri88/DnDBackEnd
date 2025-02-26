package it.dnd.game_elements_service.model;


import it.dnd.game_elements_service.model.common.CreationUpdate;
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
@Table(name = "character_classes")
public class CharacterClass extends CreationUpdate implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "hit_die", nullable = false)
    private String hitDie;

    @Column(name = "skill_points_per_level", nullable = false)
    private int skillPointsPerLevel;

    @Column(name = "class_skills_text", columnDefinition = "TEXT")
    private String classSkillsText;

    @Column(name = "base_attack_bonus_type", nullable = false)
    private String baseAttackBonusType;  // Good/Average/Poor

    @Column(name = "fortitude_save_type", nullable = false)
    private String fortitudeSaveType;    // Good/Poor

    @Column(name = "reflex_save_type", nullable = false)
    private String reflexSaveType;       // Good/Poor

    @Column(name = "will_save_type", nullable = false)
    private String willSaveType;         // Good/Poor

    @ManyToMany
    @JoinTable(
            name = "class_skills",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    @ToString.Exclude
    private Set<Skill> classSkills;

    @ManyToMany(mappedBy = "classes")
    @ToString.Exclude
    private Set<Spell> spells;

    @Column(name = "spell_caster", nullable = false)
    private boolean spellCaster;

    @Column(name = "spells_per_day_table", columnDefinition = "TEXT")
    private String spellsPerDayTable;

    @Column(name = "special_abilities", columnDefinition = "TEXT")
    private String specialAbilities;
}
