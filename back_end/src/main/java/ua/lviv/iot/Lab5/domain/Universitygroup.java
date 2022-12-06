package ua.lviv.iot.Lab5.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Table(name = "universitygroup",schema = "labor_sql")
@Data
@EqualsAndHashCode(exclude = "programs")
@Entity
public class Universitygroup {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "number")
    private Integer number;
    @OneToMany(mappedBy = "universitygroup")
    private List<Lecture> lecturesById;
    @OneToMany(mappedBy = "universitygroup")
    private List<Student> studentsById;
    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "id", nullable = false)
    private Program program;
    @ManyToMany
    @JoinTable(name = "groupprogram", catalog = "", schema = "labor_sql", joinColumns = @JoinColumn(name = "Group_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "Program_id", referencedColumnName = "id", nullable = false))
    private Set<Program> programs;

}
