package ro.itschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.itschool.controller.CarController;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class MyFirstRestAppApplication {



	public static void main(String[] args) {
		SpringApplication.run(MyFirstRestAppApplication.class, args);


	}


	//TODO Liviu : prepare a set of data to be inserted in DB every time we start the app (Search import.sql or data.sql on google)

	//TODO Sebastian : Create Dealership flow

	//TODO Victor : log every method // added logger method on CarController and OwnerController

}
