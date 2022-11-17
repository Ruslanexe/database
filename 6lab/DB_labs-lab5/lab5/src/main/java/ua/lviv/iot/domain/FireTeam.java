package ua.lviv.iot.domain;

import javax.persistence.*;
@Entity
public class FireTeam {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
}
