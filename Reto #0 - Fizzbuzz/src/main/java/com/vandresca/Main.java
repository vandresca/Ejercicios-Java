package com.vandresca;

/**
 * Listar los números del 1 al 100 ambos incluidos
 * Si el número es múltiplo de 3 sustituir por la palabra 'fizz'
 * Si el número es múltiplo de 5 sustituir por la palabra 'buzz'
 * Si el número es múltiplo de 3 y 5 sustituir por la palabra 'fizzbuzz'
 *
 * Autor: Víctor Andrés
 * Fecha: 11-08-2023
 *
 * Aplicación de Principios SOLID:
 *
 * - Principio de Responsabilidad Única (SRP):
 *   - Las clases `FizzRule`, `BuzzRule` y `FizzBuzz` tienen una única responsabilidad bien definida,
 *     separando la lógica de generación de reglas y resultados.
 *
 * - Principio de Abierto/Cerrado (OCP):
 *   - Las clases de reglas (`FizzRule`, `BuzzRule`) implementan la interfaz `RuleInterface`,
 *     permitiendo agregar nuevas reglas sin modificar el código existente.
 *   - La clase `FizzBuzz` puede extenderse para manejar nuevas reglas sin cambiar su estructura principal.
 *
 * - Principio de Sustitución de Liskov (LSP):
 *   - No se presenta una violación directa del LSP, ya que todas las clases derivadas cumplen
 *     con los contratos definidos en la interfaz `RuleInterface`.
 *
 * - Principio de Segregación de la Interfaz (ISP):
 *   - La interfaz `RuleInterface` es pequeña y cohesiva, conteniendo solo métodos relevantes
 *     para la generación de reglas Fizz y Buzz.
 *   - Las clases `FizzRule` y `BuzzRule` implementan solo los métodos requeridos por la interfaz,
 *     evitando la implementación de métodos innecesarios.
 *
 * - Principio de Inversión de Dependencias (DIP):
 *   - La clase `FizzBuzz` depende de abstracciones (la interfaz `RuleInterface`) en lugar de detalles concretos,
 *     permitiendo la inyección de diferentes reglas sin acoplar el código principal.
 *
 */

public class Main{
    public static void main(String[] args) {
        IRule[] rules = {new FizzRule(), new BuzzRule()};
        FizzBuzz fizzbuzz = new FizzBuzz(rules);
        fizzbuzz.generate(100);
    }
}