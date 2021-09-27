package src.enigma;

import java.util.HashMap;
public class Enigma {

    //TODO: turn, generate plugboard mapping out of string input method,
    //method to iterate over characters in string and encode
    
    Plugboard plugboard;
    Rotor rightRotor;
    Rotor middleRotor;
    Rotor leftRotor;
    Reflector reflector;

    public Enigma(
        HashMap<Integer,Integer> plugboardMapping,
        String rightRotorType, int rightRotorPosition, int rightRotorRingSetting,
        String middleRotorType, int middleRotorPosition, int middleRotorRingSetting,
        String leftRotorType, int leftRotorPosition, int leftRotorRingSetting,
        String reflectorType
    ){
        this.plugboard = new Plugboard(plugboardMapping);
        this.rightRotor = new Rotor(rightRotorType, rightRotorPosition, rightRotorRingSetting);
        this.middleRotor = new Rotor(middleRotorType, middleRotorPosition, middleRotorRingSetting);
        this.leftRotor = new Rotor(leftRotorType, leftRotorPosition, leftRotorRingSetting);
        this.reflector = new Reflector(reflectorType);
    }

    //encode a single char
    public char encode(char inputChar){
        int inputInt = toInt(inputChar);
        int plugboardOutput = plugboard.encode(inputInt);
        int rightRotorOutput = rightRotor.encode(plugboardOutput);
        int middleRotorOutput = middleRotor.encode(rightRotorOutput);
        int leftRotorOutput = leftRotor.encode(middleRotorOutput);
        int reflectorOutput = reflector.encode(leftRotorOutput);
        leftRotorOutput = leftRotor.encode(reflectorOutput);
        middleRotorOutput = middleRotor.encode(leftRotorOutput);
        rightRotorOutput = rightRotor.encode(middleRotorOutput);
        plugboardOutput = plugboard.encode(rightRotorOutput);
        char outputChar = toChar(plugboardOutput);
        return outputChar;
    }

    //change a char to an int (A = 1, B = 2, ..., Z = 26)
    public int toInt(char letter){
        return Character.getNumericValue(letter) - 9;
    }
    
    //change an int to a char (A = 1, B = 2, ..., Z = 26)
    public char toChar(int number){
        return (char) (number + 64);
    }

    public void printReflectorMapping(){
        System.out.println(this.reflector.mapping);
    }
    
}
