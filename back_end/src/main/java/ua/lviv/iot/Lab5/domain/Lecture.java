package ua.lviv.iot.Lab5.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
@Data
@Entity
public class Lecture {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "topic")
    private String topic;
    @OneToMany(mappedBy = "lecture")
    private List<Feedback> feedbacksById;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    private Universitygroup universitygroup;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false)
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id", nullable = false)
    private Lecturer lecturer;


}
