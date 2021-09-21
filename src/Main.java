package src;

import java.util.HashMap;

import src.enigma.Reflector;
import src.enigma.Rotor;

public class Main{
    public static void main(String[] args) {

        

    }

    public static int toInt(char letter){
        return Character.getNumericValue(letter) - 9;
    }
    
    public static char toChar(int number){
        return (char) (number + 64);
    }

}