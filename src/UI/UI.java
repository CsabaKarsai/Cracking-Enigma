package src.UI;

public class UI {

    //iterate over comma seperated String and get i-th entry
    public String getIthEntry(String input, int i) throws IndexOutOfBoundsException{
        if (i > input.length() - 1){
            throw new IndexOutOfBoundsException();
        }
        String[] splitted = input.split(",");;
        return splitted[i - 1];
    }
    
}
