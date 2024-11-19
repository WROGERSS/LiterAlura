package com.aluracursos.libreriadigital.principal;

import com.aluracursos.libreriadigital.service.MenuService;
import com.aluracursos.libreriadigital.service.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    private final MenuService menuService;

    @Autowired
    public Principal(MenuService menuService) {
        this.menuService = menuService;
    }

    public void ExecuteApp() {
        Menu menu = new Menu();
        Scanner teclado = new Scanner(System.in);
        System.out.println(menu.getBienvenida());
        int opcion;
        do {
            try {
                System.out.print(menu.getMenu() + " ");
                opcion = teclado.nextInt();
                teclado.nextLine();
                switch (opcion) {
                    case 1:
                        menuService.guardarLibro();
                        break;
                    case 2:
                        menuService.listarLibrosRegistrados();
                        break;
                    case 3:
                        menuService.listarAutoresRegistrados();
                        break;
                    case 4:
                        menuService.listarAutoresVivosEnUnYear();
                        break;
                    case 5:
                        menuService.listarLibrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Saliendo de la aplicación literAlura...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un número del menu de opciones");
                opcion = -1;
                teclado.nextLine();
            }
        } while (opcion != 0);
        teclado.close();
    }
}

