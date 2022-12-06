package ua.lviv.iot.Lab5.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
@Data
@Entity
public class Subject {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "duration")
    private Integer duration;
    @Basic
    @Column(name = "difficulty")
    private Integer difficulty;
    @OneToMany(mappedBy = "subject")
    private List<Lecture> lecturesById;


}
