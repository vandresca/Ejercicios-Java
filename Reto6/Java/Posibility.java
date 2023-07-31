
public enum Posibility{ 
        ROCK(1), PAPER(2), SCISSORS(3), LIZARD(4), SPOCK(5);
        
        private int value;
        
        Posibility(int value){ 
            this.value=value;
        }

        public static Posibility getElement(int value){
            for (Posibility element : Posibility.values()) {
                if (element.value() == value) {
                    return element;
                }
            }
            throw new IllegalArgumentException("Valor entero inválido");
        }

        private int value(){
            return this.value;
        }
    }
