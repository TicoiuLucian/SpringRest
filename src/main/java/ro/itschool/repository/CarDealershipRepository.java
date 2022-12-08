package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.CarDealership;

public interface CarDealershipRepository extends JpaRepository<CarDealership, Long> {
}
