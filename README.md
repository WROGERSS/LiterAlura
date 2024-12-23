
# Proyecto literAlura - Latam Oracle One

Bienvenido al proyecto literAlura, una aplicación desarrolada en Spring Boot Java que permite registrar libros y autores consultados desde la API [GutenDex](https://gutendex.com/) en una base 
de datos local relacional de una manera agil y eficiente.

### Funcionamiento de la Aplicación

1. **Recolección de Datos**: El programa consulta libros desde la API [GutenDex](https://gutendex.com/).
2. **Conversión a Objetos Java**: Los datos consultados de libros desde la API se convierten en objetos Java utilizando la clase `JsonParser`.
3. **Almacenamiento**: Los libros y autores procesados se guardan en una base de datos SQL compatible (PostgreSQL, MySQL).


## Características del funcionamiento

- **Buscar libro por título**: Listar libros por su título desde la API.
- **Listar libros registrados**: Visualiza  todos los libros registrados en la base de datos seleccionados por el usuario. 
- **Listar autores registrados**: Visualiza todos los autores registrados en la base de datos asociados con libros registrados.
- **Listar autores vivos en un determinado año**: Lista autores que estaban vivos en un año específico de los libros registrados.
- **Listar libros por idioma**: Filtrar una lista  de los libros regitrados por un idioma específico.

## Tecnologías Utilizadas 

- **Java 21+**
- **SDK 18**
- **Spring Boot 3.3.5**
- **Spring Data JPA**
- **PostgreSQL**,
- **PgAdmin 8.12**
- **Jackson 2.17.0**
- **Maven 3.3.2**

## Instalación y Ejecución 

Pasos para configurar y ejecutar el proyecto en la máquina local.

### Prerrequisitos

- Java 11 o superior
- Maven 3.6 o superior
- Una base de datos SQL (PostgreSQL, MySQL)


### Configurar la base de datos en el archivo application.properties
```
spring.datasource.url=jdbc:postgresql://localhost/nombre_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

### Ejecutar la aplicacion Libreriadigital en el IDE (Intellij IDEA Community Edition )

Al ejecutar la aplicación, se visualizara un menú en la consola con las opciones acontinuación:
```
Bienvenidos a la aplicación LiterAlura
Elija una opción:
1 - Buscar libro por título
2 - Listar libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en un determinado año
5 - Listar libros por idioma
0 - Salir
```
Seleccionar la opción deseada ingresando el número correspondiente y seguir  las instrucciones en pantalla.


