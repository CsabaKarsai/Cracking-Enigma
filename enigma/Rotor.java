package enigma;

import java.util.HashMap;

public class Rotor extends Wheel implements WheelInterface {

    int rotorPosition;
    int ringSetting;
    String rotorType;
    HashMap<Integer,Integer> mapping;
    
    public Rotor(int rotorPosition, int ringSetting, String rotorType){
        this.rotorPosition = rotorPosition;
        this.ringSetting = ringSetting;
        this.rotorType = rotorType;
        if (rotorType.equals("I")) setMapping(rotorI);
    }

    @Override
    public int encode(int input) {
        int shift = (this.ringSetting - this.rotorPosition) % 26;
        int toMap = (input - shift) % 26;
        int mapped = this.mapping.get(toMap);
        int output = (mapped - shift) % 26;
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
