import java.util.HashMap;

import enigma.Reflector;
import enigma.Rotor;

public class Main{
    public static void main(String[] args) {

        Reflector reflector = new Reflector("C");
        System.out.println("mapping: " + reflector.getMapping());
        char inputChar = 'A';
        int input = toInt(inputChar);
        System.out.println("input letter: " + toChar(input));
        int output = reflector.encode(input);
        System.out.println("output letter: " + toChar(output));

        /*
        Rotor rotor3 = new Rotor("V", 2, 1);
        System.out.println("mapping: " + rotor3.getMapping());
        char inputChar = 'A';
        int input = toInt(inputChar);
        System.out.println("input letter: " + toChar(input));
        int output = rotor3.encode(input);
        System.out.println("output letter: " + toChar(output));
        */

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