package ro.itschool.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Car;
import ro.itschool.entity.Owner;
import ro.itschool.repository.OwnerRepository;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping(value = "/owner")
public class OwnerController {



    @Autowired
    private OwnerRepository ownerRepository;

    private Logger logger = Logger.getLogger(OwnerController.class.getName());

    //  @PostMapping
    // public void saveOwner(@RequestBody Owner owner) {
    //     for (Car car : owner.getCars()) {
    //         car.setOwner(owner);
    //     }
    //     ownerRepository.save(owner);
    //  }

    @PostMapping
    public void saveOwner(@RequestBody Owner owner){
        logger.log(Level.INFO,"The method saveOwner was used to add owner to DB.");
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
        logger.log(Level.INFO,"Method deleteOwner was used to delete owners.");
        ownerRepository.deleteById(id);
    }
}
