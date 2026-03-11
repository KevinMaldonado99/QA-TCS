
# Demoblaze Automation Testing

## Descripción

Este proyecto contiene pruebas automatizadas End-to-End para la página web Demoblaze utilizando el patrón Screenplay con Serenity BDD, Cucumber y Selenium WebDriver.

El objetivo de la automatización es validar el flujo de compra de productos dentro de la plataforma.

---

## Tecnologías utilizadas

- Java 17
- Maven
- Serenity BDD
- Cucumber
- Selenium WebDriver
- Screenplay Pattern
- Firefox Driver

---

## Estructura del proyecto

src/test/java

- models → modelos de datos
- pasosDefinitions → definiciones de los pasos BDD
- runners → configuración del runner de Cucumber  
- tareas → tareas que ejecuta el actor (Screenplay)  
- ui → localizadores de elementos de la interfaz  

src/test/resources

- features → escenarios BDD en Cucumber  
- data → datos de prueba en CSV

---

## Escenarios automatizados

1. Compra de dos productos utilizando Scenario Outline
2. Compra de productos utilizando datos externos desde archivo CSV

---

## Cómo ejecutar el proyecto

### 1. Clonar el repositorio

git clone https://github.com/usuario/demoblaze-tests.git

### 2. Ingresar al proyecto

cd demoblaze-tests

### 3. Ejecutar las pruebas

mvn clean verify

---

## Reportes generados

Después de ejecutar las pruebas se generan dos reportes:

Serenity Report

target/site/serenity/index.html

Cucumber Report

target/cucumber-report.html

---

## Autor

Kevin Maldonado

