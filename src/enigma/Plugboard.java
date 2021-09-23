package src.enigma;

import java.util.HashMap;

public class Plugboard extends Wheel implements WheelInterface {

    HashMap<Integer,Integer> mapping;
    
    public Plugboard(HashMap<Integer,Integer> mapping){
        this.mapping = mapping;
    }
    
    @Override
    public int encode(int input) {
        return this.mapping.get(input);
    }

}
