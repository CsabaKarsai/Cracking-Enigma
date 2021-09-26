package src.UI;

public class Validater {

    //NOTE: check for empty input string when using UI
    
    //check input to match or regex
    public Boolean inputMatchesRegex(String input){
        input = input.toUpperCase();
        System.out.println("input: " + input);
        String pattern = "[A-Z]{2}(,[A-Z]{2})*";
        if (input.matches(pattern)){
            return true;
        } else {
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
        return inputWithoutCommas.length() != inputWithoutCommas.chars().distinct().count();
    }

    //validate user input for plugboard, should be a comma seperated String of 2 english letters
    public Boolean validate(String input){
        if (input.isEmpty() || (inputMatchesRegex(input) && getLength(input) <= 10 && !hasDuplicates(input))){
            return true;
        } else {
            return false;
        }
    }
    
}
