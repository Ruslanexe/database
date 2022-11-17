package ua.lviv.iot.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
@Data
@Entity
public class Fireman {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column (name ="fireteam_id" )
    private Integer fireTeamId;
    @Basic
    @Column(name = "surname")
    private String surname;
    @ManyToMany(mappedBy = "firemans")
    private Set<Departure> departures;
}
