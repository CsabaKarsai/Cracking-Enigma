package src.cracker;

import java.lang.Math;

public class IndexOfCoincidence implements ScoreInterface {
    
    String name;
    Double value;
    String language;
    Double expected_score_english = 1.73;
    Double expected_score_german = 2.05;
    
    public IndexOfCoincidence(String text, String language){
        this.name = "Index of Coincidence";
        this.value = calculate(text);
        this.language = language;
        if (language.equals("english")){
            this.language = language;
        }
        if (language.equals("german")){
            this.language = language;
        }
    }
    
    //calculate index of coincidence for given string
    @Override
    public double calculate(String text) {
        text = text.replaceAll(" ", "");
        char[] text_char_arr = text.toCharArray();
        //count occurrences for each char in the string
        //occurences[0] is occurences of 'A', occurences [1] is occurences of 'B', etc.
        int[] occurences = new int[26];
        for (char character : text_char_arr) {
            if (character == ' '){
                continue;
            }
            int index_from_char = toInt(character) - 1;
            occurences[index_from_char]++;
        }
        int text_length = text_char_arr.length;
        double total = 0.0;
        for (int n_occurences : occurences) {
            total += n_occurences * (n_occurences - 1);
        }
        double result = total / (text_length * (text_length - 1) * 26);
        return result;
    }

    public int toInt(char letter){
        return Character.getNumericValue(letter) - 9;
    }

    public boolean isBetterThan(IndexOfCoincidence score){
        //Assumes same language for both score and itself
        //calculate difference to optimum according to score for language
        if (getLanguage().equals("english")) {
            double difference_to_expected_this = Math.abs(this.getValue() - this.expected_score_english);
            double difference_to_expected_other = Math.abs(score.getValue() - score.expected_score_english);
            return (difference_to_expected_this < difference_to_expected_other);
        }
        if (getLanguage().equals("german")) {
            double difference_to_expected_this = Math.abs(this.getValue() - this.expected_score_german);
            double difference_to_expected_other = Math.abs(score.getValue() - score.expected_score_german);
            return (difference_to_expected_this < difference_to_expected_other);
        }
        return false;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public void setValue(Double value) {
        this.value = value;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getName() {
        return this.name;
    }

}