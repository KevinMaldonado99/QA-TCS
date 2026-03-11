# Conclusiones de la prueba automatizada

Durante el desarrollo y ejecución de las pruebas automatizadas sobre la página web Demoblaze, implementé la validación del flujo de compra de productos utilizando Serenity BDD, Cucumber y el patrón Screenplay. El objetivo principal fue comprobar que el proceso de selección de productos, agregado al carrito y finalización de la compra funcione correctamente dentro de la aplicación.

## Observaciones durante la prueba

Durante la ejecución de los escenarios pude observar que el flujo principal de compra funciona correctamente. Fue posible navegar por el catálogo de productos, seleccionar productos específicos, agregarlos al carrito y completar la compra mediante el formulario de pago que presenta la plataforma.

Al finalizar la compra, el sistema genera un mensaje de confirmación que contiene información relevante de la transacción, como el identificador de la compra, el monto total, el número de tarjeta, el nombre del cliente y la fecha de la operación. Esta información fue extraída durante la automatización y utilizada para validar que el proceso se completó correctamente.

También observé que durante la ejecución aparecen algunos mensajes de advertencia en la consola del navegador Firefox relacionados con scripts internos del navegador. Sin embargo, estos mensajes no afectan el flujo funcional de la aplicación ni la ejecución de las pruebas automatizadas.

## Errores encontrados y cómo fueron solucionados

Durante la implementación de la automatización se presentaron algunos inconvenientes comunes en pruebas de automatización web, los cuales fueron analizados y corregidos.

Uno de los problemas más frecuentes estuvo relacionado con la sincronización de los elementos de la página. En algunos casos los elementos aún no estaban disponibles cuando el script intentaba interactuar con ellos. Para solucionar este inconveniente implementé esperas explícitas utilizando las herramientas de Serenity, asegurando que los elementos estuvieran visibles antes de interactuar con ellos.

Otro inconveniente que pude observar fue cuando el escenario basado en CSV ejecutaba más de una iteración sin regresar correctamente a la página inicial. Esto ocasionaba errores al intentar localizar algunos elementos del sitio. Para resolverlo, ajusté el flujo de navegación asegurando que el escenario siempre partiera desde el estado correcto antes de iniciar una nueva interacción.

También se presentaron algunos errores al mapear correctamente los textos de los productos dentro de los selectores dinámicos. Esto fue solucionado ajustando los localizadores para que coincidieran exactamente con los nombres de los productos que aparecen en la página.

## Consideraciones técnicas

Durante el desarrollo de la solución consideré importante mantener una estructura clara del proyecto. Para ello utilicé el patrón Screenplay, el cual permite separar responsabilidades entre actores, tareas, localizadores de interfaz y definiciones de pasos. Esta estructura facilita la mantenibilidad del proyecto y permite escalar la automatización en el futuro.

Además, implementé la parametrización de escenarios utilizando Scenario Outline y datos externos desde archivos CSV. Esto permite ejecutar el mismo flujo de prueba utilizando diferentes combinaciones de datos sin necesidad de modificar el código.

También se generaron reportes automáticos utilizando Serenity BDD y Cucumber, los cuales permiten visualizar de manera clara el resultado de los escenarios ejecutados, el estado de cada paso y el tiempo de ejecución de las pruebas.

## Buenas prácticas aplicadas

Durante el desarrollo de la automatización se aplicaron varias buenas prácticas de automatización de pruebas:

* Uso del patrón Screenplay para mejorar la organización y mantenibilidad del código.
* Separación clara entre tareas, interfaz de usuario y definiciones de pasos.
* Uso de datos externos mediante archivos CSV para pruebas basadas en datos.
* Implementación de esperas explícitas para mejorar la estabilidad de la automatización.
* Generación de reportes detallados mediante Serenity BDD y Cucumber.

## Conclusion Final.

En conclusión, la automatización implementada permite validar correctamente el flujo principal de compra dentro de la aplicación Demoblaze. La estructura del proyecto facilita la ampliación de los escenarios y la reutilización de componentes, lo que permite que la solución sea escalable y mantenible para futuras pruebas de regresión.
