package ro.itschool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.CarDealership;
import ro.itschool.repository.CarDealershipRepository;

import java.util.List;
@RestController
@RequestMapping(value = "/car-dealership")
public class CarDealershipController {
    Logger logger = LoggerFactory.getLogger(CarDealershipController.class);
    @Autowired
    private CarDealershipRepository carDealershipRepository;


    @GetMapping(value = "/all")
    public List<CarDealership> getAllCars() {
        logger.info("All cars was called");
        return carDealershipRepository.findAll();
    }

    @PostMapping
    public void saveCar(@RequestBody CarDealership carDealership) {
        logger.info("Save car was called");
        carDealershipRepository.save(carDealership);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCar(@PathVariable long id) {
        logger.info("Delete id was called");
        carDealershipRepository.deleteById(id);
    }

    @PutMapping(value = "/update")
    public void updateCar(@RequestBody CarDealership newCar) {
        logger.info("Update car was called");
        if (newCar.getId() != null && carDealershipRepository.findById(newCar.getId()).isPresent())
            carDealershipRepository.save(newCar);
        else
            throw new RuntimeException("Car not found! Update failed");
    }

}
