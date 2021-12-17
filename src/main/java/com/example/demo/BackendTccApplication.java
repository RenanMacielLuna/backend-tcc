package com.example.demo;

import java.io.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.utils.CrimeUtils;

@SpringBootApplication
public class BackendTccApplication implements CommandLineRunner {

  @Autowired
  private CrimeUtils crimeUtils;
  
	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(BackendTccApplication.class, args);	
	}

  @Override
  public void run(String... args) throws Exception {
//    crimeUtils.salvarCrimes();
  }

}
