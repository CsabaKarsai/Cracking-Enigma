package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;

import src.enigma.Plugboard;
import src.enigma.Reflector;
import src.enigma.Rotor;

public class UnitTests {
    
    @Test
    public void testRotorIEncode(){
        Rotor rotorI = new Rotor("I", 1, 1);
        char inputChar = 'A';
        int inputInt = toInt(inputChar);
        int outputInt = rotorI.encode(inputInt);
        char outputChar = toChar(outputInt);
        assertEquals('E', outputChar);

        rotorI = new Rotor("I", 2, 1);
        outputInt = rotorI.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('J', outputChar);

        rotorI = new Rotor("I", 1, 2);
        outputInt = rotorI.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('K', outputChar);

        rotorI = new Rotor("I", 17, 8);
        outputInt = rotorI.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('Q', outputChar);

        rotorI = new Rotor("I", 9, 15);
        inputChar = 'T';
        inputInt = toInt(inputChar);
        outputInt = rotorI.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('C', outputChar);
    }

    @Test
    public void testRotorIIEncode(){
        Rotor rotorII = new Rotor("II", 1, 1);
        char inputChar = 'A';
        int inputInt = toInt(inputChar);
        int outputInt = rotorII.encode(inputInt);
        char outputChar = toChar(outputInt);
        assertEquals('A', outputChar);

        rotorII = new Rotor("II", 2, 1);
        outputInt = rotorII.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('I', outputChar);

        rotorII = new Rotor("II", 1, 2);
        outputInt = rotorII.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('F', outputChar);

        rotorII = new Rotor("II", 13, 17);
        outputInt = rotorII.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('J', outputChar);

        rotorII = new Rotor("II", 9, 15);
        inputChar = 'J';
        inputInt = toInt(inputChar);
        outputInt = rotorII.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('Q', outputChar);
    }

    @Test
    public void testRotorIIIEncode(){
        Rotor rotorIII = new Rotor("III", 1, 1);
        char inputChar = 'A';
        int inputInt = toInt(inputChar);
        int outputInt = rotorIII.encode(inputInt);
        char outputChar = toChar(outputInt);
        assertEquals('B', outputChar);

        rotorIII = new Rotor("III", 2, 1);
        outputInt = rotorIII.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('C', outputChar);

        rotorIII = new Rotor("III", 1, 2);
        outputInt = rotorIII.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('P', outputChar);

        rotorIII = new Rotor("III", 3, 9);
        outputInt = rotorIII.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('Q', outputChar);

        rotorIII = new Rotor("III", 10, 6);
        inputChar = 'U';
        inputInt = toInt(inputChar);
        outputInt = rotorIII.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('M', outputChar);
    }

    @Test
    public void testRotorIVEncode(){
        Rotor rotorIV = new Rotor("IV", 1, 1);
        char inputChar = 'A';
        int inputInt = toInt(inputChar);
        int outputInt = rotorIV.encode(inputInt);
        char outputChar = toChar(outputInt);
        assertEquals('E', outputChar);

        rotorIV = new Rotor("IV", 2, 1);
        outputInt = rotorIV.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('R', outputChar);

        rotorIV = new Rotor("IV", 1, 2);
        outputInt = rotorIV.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('C', outputChar);

        rotorIV = new Rotor("IV", 23, 5);
        outputInt = rotorIV.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('B', outputChar);

        rotorIV = new Rotor("IV", 12, 7);
        inputChar = 'Y';
        inputInt = toInt(inputChar);
        outputInt = rotorIV.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('Q', outputChar);
    }

    @Test
    public void testRotorVEncode(){
        Rotor rotorV = new Rotor("V", 1, 1);
        char inputChar = 'A';
        int inputInt = toInt(inputChar);
        int outputInt = rotorV.encode(inputInt);
        char outputChar = toChar(outputInt);
        assertEquals('V', outputChar);

        rotorV = new Rotor("V", 2, 1);
        outputInt = rotorV.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('Y', outputChar);

        rotorV = new Rotor("V", 1, 2);
        outputInt = rotorV.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('L', outputChar);

        rotorV = new Rotor("V", 16, 11);
        outputInt = rotorV.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('D', outputChar);

        rotorV = new Rotor("V", 3, 20);
        inputChar = 'N';
        inputInt = toInt(inputChar);
        outputInt = rotorV.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('W', outputChar);
    }

    @Test
    public void testReflectorAEncode(){
        Reflector reflectorA = new Reflector("A");
        char inputChar = 'G';
        int inputInt = toInt(inputChar);
        int outputInt = reflectorA.encode(inputInt);
        char outputChar = toChar(outputInt);
        assertEquals('Y', outputChar);

        inputChar = 'Y';
        inputInt = toInt(inputChar);
        outputInt = reflectorA.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('G', outputChar);

        inputChar = 'H';
        inputInt = toInt(inputChar);
        outputInt = reflectorA.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('X', outputChar);

        inputChar = 'Z';
        inputInt = toInt(inputChar);
        outputInt = reflectorA.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('D', outputChar);
    }
    
    @Test
    public void testReflectorBEncode(){
        Reflector reflectorB = new Reflector("B");
        char inputChar = 'C';
        int inputInt = toInt(inputChar);
        int outputInt = reflectorB.encode(inputInt);
        char outputChar = toChar(outputInt);
        assertEquals('U', outputChar);

        inputChar = 'U';
        inputInt = toInt(inputChar);
        outputInt = reflectorB.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('C', outputChar);

        inputChar = 'Q';
        inputInt = toInt(inputChar);
        outputInt = reflectorB.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('E', outputChar);

        inputChar = 'M';
        inputInt = toInt(inputChar);
        outputInt = reflectorB.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('O', outputChar);
    }

    @Test
    public void testReflectorCEncode(){
        Reflector reflectorC = new Reflector("C");
        char inputChar = 'A';
        int inputInt = toInt(inputChar);
        int outputInt = reflectorC.encode(inputInt);
        char outputChar = toChar(outputInt);
        assertEquals('F', outputChar);

        inputChar = 'F';
        inputInt = toInt(inputChar);
        outputInt = reflectorC.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('A', outputChar);

        inputChar = 'J';
        inputInt = toInt(inputChar);
        outputInt = reflectorC.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('D', outputChar);

        inputChar = 'S';
        inputInt = toInt(inputChar);
        outputInt = reflectorC.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('U', outputChar);
    }

    @Test
    public void testPlugboardEncode(){
        HashMap<Integer,Integer> mapping = new HashMap<Integer,Integer>(
            Map.ofEntries(
                entry(1, 26),
                entry(2, 25),
                entry(3, 24),
                entry(4, 23),
                entry(5, 22),
                entry(6, 21),
                entry(7, 20),
                entry(8, 19),
                entry(9, 18),
                entry(10, 17),
                entry(11, 11),
                entry(12, 12),
                entry(13, 13),
                entry(14, 14),
                entry(15, 15),
                entry(16, 16),
                entry(17, 10),
                entry(18, 9),
                entry(19, 8),
                entry(20, 7),
                entry(21, 6),
                entry(22, 5),
                entry(23, 4),
                entry(24, 3),
                entry(25, 2),
                entry(26, 1)
            )
        );

        Plugboard plugboard = new Plugboard(mapping);
        char inputChar = 'A';
        int inputInt = toInt(inputChar);
        int outputInt = plugboard.encode(inputInt);
        char outputChar = toChar(outputInt);
        assertEquals('Z', outputChar);

        inputChar = 'B';
        inputInt =toInt(inputChar);
        outputInt = plugboard.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('Y', outputChar);

        inputChar = 'M';
        inputInt =toInt(inputChar);
        outputInt = plugboard.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('M', outputChar);

        inputChar = 'U';
        inputInt =toInt(inputChar);
        outputInt = plugboard.encode(inputInt);
        outputChar = toChar(outputInt);
        assertEquals('F', outputChar);
    }

    public int toInt(char letter){
        return Character.getNumericValue(letter) - 9;
    }
    
    public char toChar(int number){
        return (char) (number + 64);
    }

}
