package enigma;

import java.util.HashMap;

public class Rotor extends Wheel implements WheelInterface {

    int rotorPosition;
    int ringSetting;
    String rotorType;
    HashMap<Integer,Integer> mapping;
    
    public Rotor(String rotorType, int rotorPosition, int ringSetting){
        this.rotorType = rotorType;
        if (rotorType.equals("I")) setMapping(rotorI);
        this.rotorPosition = rotorPosition;
        this.ringSetting = ringSetting;
    }

    @Override
    public int encode(int input) {
        //System.out.println("input: " + input);
        int shift = (this.ringSetting - this.rotorPosition) % 26;
        if (shift < 0) shift += 26;
        //System.out.println("shift: " + shift);
        int toMap = (input - shift) % 26;
        if (toMap < 0) toMap += 26;
        if (toMap == 0) toMap = 26;
        //System.out.println("toMap: " + toMap);
        int mapped = this.mapping.get(toMap);
        //System.out.println("mapped: " + mapped);
        int output = (mapped + shift) % 26;
        if (output < 0) output += 26;
        //System.out.println("output: " + output);
        return output;
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
