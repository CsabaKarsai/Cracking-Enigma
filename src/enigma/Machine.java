package src.enigma;

public class Machine {

    //TODO: constructor, turn, encrypt/decrypt
    
    //converts char to integer (A = 1, B = 2, ..., Z = 26)
    public int toInt(char letter){
        return Character.getNumericValue(letter) - 9;
    }
    
    //converts integer to char (1 = A, 2 = B, ..., 26 = Z)
    public char toChar(int number){
        return (char) (number + 64);
    }
    
}
