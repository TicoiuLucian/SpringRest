package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Dealership;

public interface DealershipRepository extends JpaRepository<Dealership, Long> {

}
