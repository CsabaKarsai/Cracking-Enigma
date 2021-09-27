package src.UI;

public class UI {

    //get i-th entry validated user input for plugboard
    public String getIthEntry(String input, int i) throws IndexOutOfBoundsException{
        String[] splitted = input.split(",");
        return splitted[i - 1];
    }
    
}
