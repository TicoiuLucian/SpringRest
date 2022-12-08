package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Address;
import ro.itschool.repository.AddressRepository;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping(value = "/by-city")
    public List<Address> getAddressByCityName(@RequestParam String city) {
        return addressRepository.findByCity(city);
    }

}
