package com.example.demo;

import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.controller.CrimeController;
import com.example.demo.entity.Crime;

@SpringBootApplication
public class BackendTccApplication implements CommandLineRunner {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(BackendTccApplication.class, args);	
	}

  @Override
  public void run(String... args) throws Exception {
    CrimeController controller = new CrimeController();
    controller.salvarCrimes(); 
  }

}
