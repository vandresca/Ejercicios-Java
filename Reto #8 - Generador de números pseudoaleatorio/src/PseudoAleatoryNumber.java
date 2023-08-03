package src;

public class PseudoAleatoryNumber {
    public static int randomInt(){
        return (int)(System.nanoTime()%101);
    }
}
