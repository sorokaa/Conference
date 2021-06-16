package com.task.Conference.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    public Schedule() {}

}
