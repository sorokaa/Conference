package com.task.Conference.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_schedule")
    private Long id;

    @Column(name = "time_of_talk")
    private Timestamp timeOfTalk;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;

    @OneToOne
    @JoinColumn(name = "id_talk")
    private Talk talk;
}
