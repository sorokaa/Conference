package com.task.Conference.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="talk")
public class Talk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talk")
    private Long id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "short_info")
    private String shortInfo;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talk")
    private List<Schedule> schedules;


    @ManyToMany
    @JoinTable(
        name = "USER_TALKS",
        joinColumns = { @JoinColumn(name = "id_talk") },
        inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<User> speakers = new HashSet<>();

    public Talk(String theme, String short_info) {
        this.theme = theme;
        this.shortInfo = short_info;
    }

}
