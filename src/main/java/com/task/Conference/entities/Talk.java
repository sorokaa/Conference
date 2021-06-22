package com.task.Conference.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
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
    @OneToOne(mappedBy = "talk")
    private Schedule schedule;


    @ManyToMany(mappedBy = "talks", cascade = CascadeType.MERGE)
    private Set<User> speakers = new HashSet<>();

    public Talk(String theme, String short_info) {
        this.theme = theme;
        this.shortInfo = short_info;
    }

}
