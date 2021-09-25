package src.UI;

public class UI {

    //TODO: constructor to be used in unit tests

    //iterate over comma seperated String and get i-th entry
    public String getIthEntry(String input, int i) throws IndexOutOfBoundsException{
        if (i > input.length() - 1){
            throw new IndexOutOfBoundsException();
        }
        String[] splitted = input.split(",");;
        return splitted[i - 1];
    }

    public int toInt(char letter){
        return Character.getNumericValue(letter) - 9;
    }
    
    public char toChar(int number){
        return (char) (number + 64);
    }
    
}
