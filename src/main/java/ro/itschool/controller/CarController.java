package ro.itschool.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Car;
import ro.itschool.repository.CarRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    private static Logger logger = Logger.getLogger(CarController.class.getName());


    @GetMapping(value = "/all")
    public List<Car> getAllCars() {
        logger.log(Level.INFO,"Method getAllCars was used!");
        return carRepository.findAll();
    }

    @PostMapping
    public void saveCar(@RequestBody Car car) {
        logger.log(Level.INFO,"Method saveCar was used!");
        carRepository.save(car);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCar(@PathVariable long id) {
        logger.log(Level.INFO,"Method deleteCar was used!");
        carRepository.deleteById(id);
    }

    @PutMapping(value = "/update")
    public void updateCar(@RequestBody Car newCar) {
        logger.log(Level.INFO,"Method updateCar was used!");
        if (newCar.getId() != null && carRepository.findById(newCar.getId()).isPresent())
            carRepository.save(newCar);
        else
            throw new RuntimeException("Car not found! Update failed");
    }

    @GetMapping(value = "/by-manufacturer")
    public List<Car> getCarByManufacturerName(@RequestParam String manufacturer) {
        logger.log(Level.INFO,"Method getCarByManufacturer was used!");
        return carRepository.findByManufacturer(manufacturer);
    }


    @GetMapping(value = "/by-model")
    public List<Car> getCarByModelName(@RequestParam String model) {
        logger.log(Level.INFO,"Method getCarByModelName was used!");
        return carRepository.findByModel(model);

    }

    @GetMapping(value = "/by-manufacturer-and-model")
    public List<Car> getCarByManufacturerAndModelName(@RequestParam String manufacturer, @RequestParam String model) {
        logger.log(Level.INFO,"Method getCarByManufacturerAndModelName was used!");
        return carRepository.findByManufacturerAndModel(manufacturer, model);
    }

    @GetMapping(value ="by-age" )
    public List<Car> getCarAge(@RequestParam String age){
        logger.log(Level.INFO,"Method getCarAge was used!");
        return carRepository.findByAge(age);
    }

//    @GetMapping(value = "by-option")
//    public List<Car> getCarOptions(@RequestParam String options){
//        logger.log(Level.INFO,"Method getCarOptions was used!");
//        return carRepository.findByOptions(options);
//    }


}

// get (Read)
// post (Create)
// put (Update)
// delete (Delete)
