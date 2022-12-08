package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString

public class CarOptionals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String extraOrDefault;
    private Long price;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Car car;

    public void add(CarOptionals carOptionals) {
    }
}
