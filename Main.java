import java.util.HashMap;
import java.util.Map;

import enigma.Rotor;

import static java.util.Map.entry;

public class Main{
    public static void main(String[] args) {

        //TODO add other rotors and debug rotorposition and ringsetting
        Rotor rotor3 = new Rotor(2, 2, "I");
        System.out.println(rotor3.getMapping());
        int input = 1;
        System.out.println("input letter: " + toChar(input));
        int output = rotor3.encode(input);
        System.out.println("output letter: " + toChar(output));

        /*
        DEBUGGING

        HashMap<Character,Character> mappingRotorI = new HashMap<Character,Character>(
            Map.ofEntries(
                entry('A', 'E'),
                entry('B', 'K'),
                entry('C', 'M'),
                entry('D', 'F'),
                entry('E', 'L'),
                entry('F', 'G'),
                entry('G', 'D'),
                entry('H', 'Q'),
                entry('I', 'V'),
                entry('J', 'Z'),
                entry('K', 'N'),
                entry('L', 'T'),
                entry('M', 'O'),
                entry('N', 'W'),
                entry('O', 'Y'),
                entry('P', 'H'),
                entry('Q', 'X'),
                entry('R', 'U'),
                entry('S', 'S'),
                entry('T', 'P'),
                entry('U', 'A'),
                entry('V', 'I'),
                entry('W', 'B'),
                entry('X', 'R'),
                entry('Y', 'C'),
                entry('Z', 'J')
            )
        );

        HashMap<Integer,Integer> mappingRotorINumbers = new HashMap<Integer,Integer>(
            Map.ofEntries(
                entry(1, 5),
                entry(2, 11),
                entry(3, 13),
                entry(4, 6),
                entry(5, 12),
                entry(6, 7),
                entry(7, 4),
                entry(8, 17),
                entry(9, 22),
                entry(10, 26),
                entry(11, 14),
                entry(12, 20),
                entry(13, 15),
                entry(14, 23),
                entry(15, 25),
                entry(16, 8),
                entry(17, 24),
                entry(18, 21),
                entry(19, 19),
                entry(20, 16),
                entry(21, 1),
                entry(22, 9),
                entry(23, 2),
                entry(24, 18),
                entry(25, 3),
                entry(26, 10)
            )
        );

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