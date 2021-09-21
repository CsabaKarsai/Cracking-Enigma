package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
    public void testReflectorCEncode(){
        Reflector reflectorC = new Reflector("C");
        char inputChar = 'A';
        int inputInt = toInt(inputChar);
        int outputInt = reflectorC.encode(inputInt);
        char outputChar = toChar(outputInt);
        assertEquals('F', outputChar);
    }

    public int toInt(char letter){
        return Character.getNumericValue(letter) - 9;
    }
    
    public char toChar(int number){
        return (char) (number + 64);
    }

}
