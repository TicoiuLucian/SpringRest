package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByManufacturer(String manufacturer);

    List<Car> findByModel(String model);

    List<Car> findByManufacturerAndModel(String manufacturer, String model);

    //TODO George: add methods to filter cars by age and by options (From Roxana)

    List<Car> findByAge(String age);

    List<Car> findByOptions(String options);

}
