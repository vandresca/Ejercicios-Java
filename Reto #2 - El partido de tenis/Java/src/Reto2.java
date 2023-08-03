package src;
/**
 * Escribe un programa que muestre un juego de tenis y quien
 * lo ha ganado.
 * El programa rebira una secuencia formada por:
 * "P1" (Player 1) o "P2" (Player 2) segun quien gane cada juego
 * - Las puntuaciones son:
 *  "Love" (cero), "15", "30", "40", "Deuce" (empate), "Advantage",  ventaja
 * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1] el programa
 *  mostraría:
 *      15 - Love
 *      30 - Love
 *      30 - 15
 *      30 - 30
 *      40 - 30
 *      Deuce
 *      Advantage P1
 *      Ha ganado P1
 * - Es posible controlar errores en la entrada de datos.
 * - Consulta las reglas de juego si tienes dudas sobre el sistema de puntos.
 */
public class Reto2{

    public static void main(String[] args) {
       TennisGame tennisGame = new TennisGame();
       tennisGame.play();
    }
}