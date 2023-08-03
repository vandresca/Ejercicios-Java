/**
 * Programa que genere una contraseña en la que se pueda:
 * - Elegir si tiene 8 o 16 carácteres
 * - Elegir si se quiere que tenga mayúsculas
 * - Elegir si se quiere que tenga números
 * - Elegir si se quiere que tenga simbolos
 */
public class Reto3 {

    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.run();
    }
}

