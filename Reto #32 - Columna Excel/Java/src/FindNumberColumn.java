package Java.src;

import java.util.HashMap;

public class FindNumberColumn {
    
    static HashMap<String, Integer> alphabet;

    public static long run(String column){
        loadAlphabet();
        long numberColumn = 0;
        int columnSize = column.length();
        for(int i=0; i<columnSize; i++){
            if(i == columnSize -1){
                numberColumn +=findPosition(column.charAt(i));
            }else{
                numberColumn += findPosition(column.charAt(i))* Math.pow(alphabet.size(),columnSize-1-i);
            }
        }
        return numberColumn;
    }

    private static int findPosition(Character letterColumn){
        return alphabet.get(letterColumn.toString());
    }

    private static void loadAlphabet(){
        alphabet = new HashMap<String, Integer>();
        int index = 1;
        for(Character c = 'A'; c<='Z'; c++){
            alphabet.put(c.toString(),index);
            index++;
        }
    }
}
