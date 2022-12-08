package ro.itschool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.CarDealership;
import ro.itschool.entity.Dealership;
import ro.itschool.repository.DealershipRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/dealership")
public class DealershipController {

    Logger logger = LoggerFactory.getLogger(DealershipController.class);
    @Autowired
    private DealershipRepository dealershipRepository;

    @GetMapping(value = "/all-cars")
    public List<Dealership> dealershipList() {
        logger.info("All cars method was called successful");
        return dealershipRepository.findAll();
    }

    @PostMapping(value = "/save-dealership")
    public void addDealership(@RequestBody Dealership dealership) {
        for (CarDealership carDealership : dealership.getCarsDealer()) {
            carDealership.setDealership(dealership);
        }
        logger.info("Save dealership was called");
        dealershipRepository.save(dealership);
    }

    @PutMapping(value = "/update-dealership")
    public void updateDealership(@RequestBody Dealership dealership) {
        for (CarDealership carDealership : dealership.getCarsDealer()) {
            carDealership.setDealership(dealership);
        }
        logger.info("Update dealership was called");
        dealershipRepository.save(dealership);
    }


    @DeleteMapping(value = "/delete/{id}")
    public void deleteDealershipById(@PathVariable Long id) {
        logger.info("Delete dealership was called");
        dealershipRepository.deleteById(id);
    }


}
