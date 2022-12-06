package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.itschool.entity.CarOptionals;
import ro.itschool.repository.CarOptionalsRepository;


@RestController
@RequestMapping(value = "/carOptionals")

public class CarOptionalsController {
    @Autowired
    private CarOptionalsRepository carOptionalsRepository;

    @PostMapping
    public void saveCarOptionals(@RequestBody CarOptionals carOptionals) {
       carOptionalsRepository.save(carOptionals);

    }

}
