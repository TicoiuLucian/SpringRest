package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String city;

    private String addressStatus;

    private Long population;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Owner owner;

}
