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

    //encode a single char
    public char encode(char inputChar) throws NullPointerException{
        if (this.plugboard == null
            || this.rightRotor == null
            || this.middleRotor == null
            || this.leftRotor == null
            || this.reflector == null){
                throw new NullPointerException();
        }
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

    public void setPlugboard(HashMap<Integer,Integer> mapping){
        this.plugboard = new Plugboard(mapping);
    }
    
    public void setRightRotor(String rotorType, int rotorPosition, int ringSetting){
        this.rightRotor = new Rotor(rotorType, rotorPosition, ringSetting);
    }

    public void setMiddleRotor(String rotorType, int rotorPosition, int ringSetting){
        this.middleRotor = new Rotor(rotorType, rotorPosition, ringSetting);
    }

    public void setLeftRotor(String rotorType, int rotorPosition, int ringSetting){
        this.leftRotor = new Rotor(rotorType, rotorPosition, ringSetting);
    }

    public void setReflector(String rotorType, int rotorPosition, int ringSetting){
        this.rightRotor = new Rotor(rotorType, rotorPosition, ringSetting);
    }

    //change a char to an int (A = 1, B = 2, ..., Z = 26)
    public int toInt(char letter){
        return Character.getNumericValue(letter) - 9;
    }
    
    //change an int to a char (A = 1, B = 2, ..., Z = 26)
    public char toChar(int number){
        return (char) (number + 64);
    }
    
}
