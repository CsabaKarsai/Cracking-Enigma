package src.enigma;

import java.util.HashMap;

public class Reflector extends Wheel implements WheelInterface {

    String reflectorType;
    HashMap<Integer,Integer> mapping;
    
    public Reflector(String reflectorType){
        this.reflectorType = reflectorType;
        if (reflectorType.equals("A")) this.mapping = reflectorA;
        if (reflectorType.equals("B")) this.mapping = reflectorB;
        if (reflectorType.equals("C")) this.mapping = reflectorC;
    }
    
    @Override
    public int encode(int input) {
        return this.mapping.get(input);
    }
    
}
