package com.task.Conference.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private Long number;

    public Room() {}

}
