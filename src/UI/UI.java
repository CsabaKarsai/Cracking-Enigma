package src.UI;

public class UI {

    //get i-th entry validated user input for plugboard
    public String getIthEntry(String input, int i) throws IndexOutOfBoundsException{
        String[] splitted = input.split(",");
        return splitted[i - 1];
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
