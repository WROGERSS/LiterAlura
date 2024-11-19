package com.aluracursos.libreriadigital;

import com.aluracursos.libreriadigital.principal.Principal;
import com.aluracursos.libreriadigital.service.MenuService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class LibreriadigitalApplication implements CommandLineRunner {

	public static void main(String[] args) { SpringApplication.run(LibreriadigitalApplication.class, args); }
	@Autowired
	private MenuService menuService;

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal (menuService);
		principal.ExecuteApp();
	}
}
