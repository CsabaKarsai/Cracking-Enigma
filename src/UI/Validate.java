package src.UI;

public class Validate {

    //TODO: implemented validate method
    
    //check userInput is in correct Format
    public Boolean inputIsValid(String input){
        input = input.toUpperCase();
        System.out.println("input: " + input);
        String pattern = "[A-Z]{2}(,[A-Z]{2})*";
        if (input.isEmpty() || input.matches(pattern)){
            System.out.println("match!");
            return true;
        } else {
            System.out.println("no match!");
            return false;
        }
    }

    //get plugboard String length by counting commas
    public int getLength(String input){
        int commaCount = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == ',') commaCount++;
        }
        return commaCount + 1;
    }

    //check for duplicate letters in plugboard String
    public Boolean hasDuplicates(String input){
        String inputWithoutCommas = input.replace(",","");
        Boolean result = inputWithoutCommas.length() != inputWithoutCommas.chars().distinct().count();
        return result;
    }
    
}
