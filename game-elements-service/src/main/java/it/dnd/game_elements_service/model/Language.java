package it.dnd.game_elements_service.model;

import it.dnd.game_elements_service.model.common.CreationUpdate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"racesWithAutomatic", "racesWithBonus"})
@Builder
@Table(name = "languages")
public class Language extends CreationUpdate implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(mappedBy = "automaticLanguages")
    private transient  Set<Race> racesWithAutomatic = new HashSet<>();

    @ManyToMany(mappedBy = "bonusLanguages")
    private transient  Set<Race> racesWithBonus = new HashSet<>();

    @Column(nullable = false)
    private String alphabet;

    @Column(nullable = false)
    private boolean isSecret;

}