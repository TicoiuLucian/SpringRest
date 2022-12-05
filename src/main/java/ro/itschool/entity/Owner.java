package ro.itschool.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();


    public void addCarToOwner(Car car) {
        cars.add(car);
        car.setOwner(this);
    }


}

//TODO DANI: add more attributes to owner
//TODO DANI: add Address attribute as OneToOne