import java.util.HashMap;
import java.util.Map;

import enigma.Rotor;

import static java.util.Map.entry;

public class Main{
    public static void main(String[] args) {

        //TODO add other rotors
        Rotor rotor3 = new Rotor(2, 2, "I");
        System.out.println(rotor3.getMapping());
        int input = 1;
        System.out.println("input letter: " + toChar(input));
        int output = rotor3.encode(input);
        System.out.println("output letter: " + toChar(output));

        /*
        DEBUGGING

        System.out.println(mappingRotorI);
        System.out.println(toChar(mappingRotorINumbers.get(1)));
        System.out.println(toChar(mappingRotorINumbers.get(14)));
        System.out.println(toChar(mappingRotorINumbers.get(26)));

        System.out.println(mappingRotorI);
        mappingRotorI.put('A', 'B');
        System.out.println(mappingRotorI);
        setEntry(mappingRotorI, 'A', 'C');
        System.out.println(mappingRotorI);
        */

    }

    public static int toInt(char letter){
        return Character.getNumericValue(letter) - 9;
    }
    
    public static char toChar(int number){
        return (char) (number + 64);
    }
    
    public static void setEntry(HashMap<Character, Character> mapping, char key, char value){
        mapping.put(key, value);
    }

}