package src.enigma;

import java.util.HashMap;

public class Reflector extends Wheel implements WheelInterface {

    String reflectorType;
    HashMap<Integer,Integer> mapping;
    
    public Reflector(String reflectorType){
        this.reflectorType = reflectorType;
        if (reflectorType.equals("A")) setMapping(reflectorA);
        if (reflectorType.equals("B")) setMapping(reflectorB);
        if (reflectorType.equals("C")) setMapping(reflectorC);
    }
    
    @Override
    public int encode(int input) {
        return this.mapping.get(input);
    }

    @Override
    public void setMapping(HashMap<Integer, Integer> mapping) {
        this.mapping = mapping;
    }

    @Override
    public HashMap<Integer, Integer> getMapping() {
        return this.mapping;
    }
    
}
