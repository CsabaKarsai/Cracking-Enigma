package src.cracker;

import java.util.HashMap;

import src.enigma.Enigma;

public class Cracker {

    public String crackEnigma(){
        //expriment with decrypting text by looping through rotor positions
        //no need to loop through ringsettings too, changing the ringsetting is equivalent to changing the rotor position
        //i.e. all rotor/ringsetting combinations have a correcposing rotor/ringetting combination with ringsetting = 1
        Enigma enigma = new Enigma();
        HashMap<Integer,Integer> plugboard = enigma.generatePlugboard("AD,CN,ET,FL,GI,JV,KZ,PU,QY,WX");
        enigma.setPlugboard(plugboard);
        enigma.setPlugboard(plugboard);
        enigma.setRightRotor("III", 1, 1);
        enigma.setMiddleRotor("II", 1, 1);
        enigma.setLeftRotor("I", 1, 1);
        enigma.setReflector("B");
        String output = enigma.encodeString("AAAAA");
        System.out.println(output);
        
        String textToDecipher = "Nutzereingabe";
        
        //TODO current_best_ioc = ...
        
        //rotor positions 1 to 26
        int bestRightRotorPosition;
        int bestMiddleRotorPosition;
        int bestLeftRotorPosition;

        //TODO current_best_right_rotor_pod = ...
        //TODO for all plugboard combinations do:
        for(int i = 1; i <= 26; i++) {
            //take default enigma with rotor and ringsettings all at one
            Enigma default_enigma = new Enigma();
            HashMap<Integer,Integer> default_plugboard = enigma.generatePlugboard("AD,CN,ET,FL,GI,JV,KZ,PU,QY,WX");
            default_enigma.setPlugboard(plugboard);
            default_enigma.setRightRotor("III", 1, 1);
            default_enigma.setMiddleRotor("II", 1, 1);
            default_enigma.setLeftRotor("I", 1, 1);
            default_enigma.setReflector("B");
            //set rotor position
            default_enigma.getRightRotor().setRotorPosition(i);
            //let it encode the text
            String default_enigma_output = default_enigma.encodeString(textToDecipher);
            //compute index of coincidence of output
            IndexOfCoincidence ioc = new IndexOfCoincidence(default_enigma_output, "german");
            //check if output better than current best and update best if so
        }
        //same for all rotors
        String s = "test";
        return s;
    }
    
}
