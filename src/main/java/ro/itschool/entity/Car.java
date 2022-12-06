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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Owner owner;

    @OneToMany (mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CarOptionals> optionals = new ArrayList<>();

    private void addCarOptionalsToCar(CarOptionals carOptionals){
        carOptionals.add(carOptionals);
        carOptionals.setCar(this);
    }

    //TODO: Add list of carOptionals -> Roxana (OneToMany)
}
