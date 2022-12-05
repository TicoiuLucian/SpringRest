package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    //TODO Adriana: Filter by city, filter by city if city si smaller than x population
}
