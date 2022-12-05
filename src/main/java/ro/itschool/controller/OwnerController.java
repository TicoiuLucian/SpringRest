package ro.itschool.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Car;
import ro.itschool.entity.Owner;
import ro.itschool.repository.OwnerRepository;


@RestController
@RequestMapping(value = "/owner")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @PostMapping
    public void saveOwner(@RequestBody Owner owner) {
        for (Car car : owner.getCars()) {
            car.setOwner(owner);
        }
        ownerRepository.save(owner);
    }

    @PutMapping
    public void updateOwner(@RequestBody Owner owner) {
        for (Car car : owner.getCars()) {
            car.setOwner(owner);
        }
        ownerRepository.save(owner);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerRepository.deleteById(id);
    }
}
