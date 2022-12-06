package ua.lviv.iot.Lab5.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table(name = "program",schema = "labor_sql")
@Data
@EqualsAndHashCode(exclude = "universitygroups")
@Entity
public class Program {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "programs")
    private Set<Universitygroup> universitygroups;


}
