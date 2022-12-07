package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturer;

    private String model;

    private String year;

    private String age;

    private String options;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Owner owner;



    //TODO: Add list of carOptionals -> Roxana (OneToMany)
}
