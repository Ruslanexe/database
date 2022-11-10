package ua.lviv.iot.Lab5.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
@Data
@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "age")
    private Integer age;
    @OneToMany(mappedBy = "student")
    private List<Feedback> feedbacksById;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    private Universitygroup universitygroup;


}
