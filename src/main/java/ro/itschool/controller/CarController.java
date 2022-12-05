package ro.itschool.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Car;
import ro.itschool.repository.CarRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;


    @GetMapping(value = "/all")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @PostMapping
    public void saveCar(@RequestBody Car car) {
        carRepository.save(car);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCar(@PathVariable long id) {
        carRepository.deleteById(id);
    }

    @PutMapping(value = "/update")
    public void updateCar(@RequestBody Car newCar) {
        if (newCar.getId() != null && carRepository.findById(newCar.getId()).isPresent())
            carRepository.save(newCar);
        else
            throw new RuntimeException("Car not found! Update failed");
    }

    @GetMapping(value = "/by-manufacturer")
    public List<Car> getCarByManufacturerName(@RequestParam String manufacturer) {
        return carRepository.findByManufacturer(manufacturer);
    }


    @GetMapping(value = "/by-model")
    public List<Car> getCarByModelName(@RequestParam String model) {
        return carRepository.findByModel(model);

    }

    @GetMapping(value = "/by-manufacturer-and-model")
    public List<Car> getCarByManufacturerAndModelName(@RequestParam String manufacturer, @RequestParam String model) {
        return carRepository.findByManufacturerAndModel(manufacturer, model);
    }
}

// get (Read)
// post (Create)
// put (Update)
// delete (Delete)
