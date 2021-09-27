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
    public int encodeForward(int input) {
        System.out.println(this.reflectorType);
        System.out.println("input: " + input);
        int output = this.mapping.get(input);
        System.out.println("output: " + output);
        return output;
    }

    @Override
    public int encodeBackward(int input) {
        return encodeForward(input);
    }
    
}
