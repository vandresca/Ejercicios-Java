package src;


/*
 * Crea un generador de números pseudoaleatorios entre 0 y 100.
 * - No puedes usar ninguna función "random" (o semejante) del 
 *   lenguaje de programación seleccionado.
 *
 * Es más complicado de lo que parece...
 */

public class Reto8{
    public static void main(String[] args) {
        for(int i=1; i<= 100; i++){
            Printer.print(String.valueOf(PseudoAleatoryNumber.randomInt()));
        }
    }
}