package br.edu.ifsp.spo.bulls.usersApi.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    private Profile profile;
    private String color;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<UserBooks> books;
}
