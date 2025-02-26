package it.dnd.game_elements_service.model;

import it.dnd.game_elements_service.model.common.CreationUpdate;
import it.dnd.game_elements_service.model.enumerated.School;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "spells")
public class Spell extends CreationUpdate implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "spell_classes", // Nome della tabella di join
            joinColumns = @JoinColumn(name = "spell_id"), // Colonna per l'ID degli spells
            inverseJoinColumns = @JoinColumn(name = "class_id") // Colonna per l'ID delle classi
    )
    @ToString.Exclude
    private List<CharacterClass> classes = new ArrayList<>();

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private String castingTime;

    @Column(name = "spell_range", nullable = false)  // cambiato da 'range' a 'spell_range'
    private String range;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private String components;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private School school;

    @Column(nullable = false)
    private boolean concentration;

}
