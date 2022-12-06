package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
