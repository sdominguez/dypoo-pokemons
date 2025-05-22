# Proyecto Pokémon JDBC

Este proyecto Java implementa una conexión a una base de datos MySQL utilizando JDBC 8.0.33. 
Se aplican buenas prácticas de arquitectura, como el patrón DAO (Data Access Object) para el acceso a datos y Singleton para gestionar la conexión a la base de datos.

## Características

- Conexión a MySQL mediante JDBC 8
- Configuración de credenciales externa en `database.properties`
- Patrón Singleton para la clase de conexión
- Patrón DAO para separar la lógica de acceso a datos
- Compatible con IntelliJ y Gradle

## Estructura del proyecto

```
├── src/
│   └── main/
│       └── java/
│           └── com/pokemon/
│               ├── connection/           # Clase DatabaseConnetion.java
│               └── dao/                  # Clases DAO para acceso a datos
├── build.gradle
├── settings.gradle
├── gradlew / gradlew.bat
├── gradle/wrapper/
└── database.properties                  # Archivo de configuración de credenciales
```

## Configuración de la base de datos

El archivo `database.properties` debe ubicarse en `src/main/resources/` y debe contener:

```
db.url=jdbc:mysql://localhost:3306/pokemondb
db.user=root
db.password=root
```

## Requisitos

- Java 11 o superior
- MySQL 8.x
- Gradle
- IntelliJ IDEA (opcional)

## Ejecución

Para compilar y ejecutar el proyecto:

```bash
./gradlew build
```

## Autor

Proyecto de ejemplo desarrollado para fines educativos.
