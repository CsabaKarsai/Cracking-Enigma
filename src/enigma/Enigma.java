package src.enigma;

import java.util.HashMap;
public class Enigma {

    //TODO: generate plugboard mapping out of string input method
    
    Plugboard plugboard;
    Rotor rightRotor;
    Rotor middleRotor;
    Rotor leftRotor;
    Reflector reflector;

    //encode a single char
    public char encodeChar(char inputChar) throws NullPointerException{
        if (this.plugboard == null
            || this.rightRotor == null
            || this.middleRotor == null
            || this.leftRotor == null
            || this.reflector == null) {
                throw new NullPointerException();
        }
        int inputInt = toInt(inputChar);
        int plugboardOutput = plugboard.encodeForward(inputInt);
        int rightRotorOutput = rightRotor.encodeForward(plugboardOutput);
        int middleRotorOutput = middleRotor.encodeForward(rightRotorOutput);
        int leftRotorOutput = leftRotor.encodeForward(middleRotorOutput);
        int reflectorOutput = reflector.encodeForward(leftRotorOutput);
        leftRotorOutput = leftRotor.encodeBackward(reflectorOutput);
        middleRotorOutput = middleRotor.encodeBackward(leftRotorOutput);
        rightRotorOutput = rightRotor.encodeBackward(middleRotorOutput);
        plugboardOutput = plugboard.encodeBackward(rightRotorOutput);
        char outputChar = toChar(plugboardOutput);
        return outputChar;
    }

    public void setPlugboard(HashMap<Integer,Integer> mapping){
        this.plugboard = new Plugboard(mapping);
    }
    
    public void setRightRotor(String rotorType, int rotorPosition, int ringSetting){
        this.rightRotor = new Rotor(rotorType, rotorPosition, ringSetting);
    }

    public Rotor getRightRotor(){
        return this.rightRotor;
    }

    public void setMiddleRotor(String rotorType, int rotorPosition, int ringSetting){
        this.middleRotor = new Rotor(rotorType, rotorPosition, ringSetting);
    }

    public Rotor getMiddleRotor(){
        return this.middleRotor;
    }

    public void setLeftRotor(String rotorType, int rotorPosition, int ringSetting){
        this.leftRotor = new Rotor(rotorType, rotorPosition, ringSetting);
    }

    public Rotor getLeftRotor(){
        return this.leftRotor;
    }

    public void setReflector(String reflectorType){
        this.reflector = new Reflector(reflectorType);
    }

    //change a char to an int (A = 1, B = 2, ..., Z = 26)
    public int toInt(char letter){
        return Character.getNumericValue(letter) - 9;
    }
    
    //change an int to a char (A = 1, B = 2, ..., Z = 26)
    public char toChar(int number){
        return (char) (number + 64);
    }

    public void turn(){
        rightRotor.turn();
        //normal case
        if (rightRotor.getRotorPosition() == rightRotor.getTurnover()){
            middleRotor.turn();
            if (middleRotor.getRotorPosition() == middleRotor.getTurnover()) {
                leftRotor.turn();
            }
        } else {
            //turnover anomaly of middle rotor
            int middleRotorBeforeTurnover = middleRotor.getTurnover() - 1;
            if (middleRotorBeforeTurnover == 0){
                middleRotorBeforeTurnover = 26;
            }
            if (middleRotor.getRotorPosition() == middleRotorBeforeTurnover){
                middleRotor.turn();
                if (middleRotor.getRotorPosition() == middleRotor.getTurnover()){
                    leftRotor.turn();
                }
            }   
        }
    }

    public String encodeString(String input){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            char charToEncode = input.charAt(i);
            if (charToEncode == ' '){
                sb.append(charToEncode);
            } else {
                turn();
                sb.append(encodeChar(charToEncode));
            }
        }
        return sb.toString();
    }
    
}
