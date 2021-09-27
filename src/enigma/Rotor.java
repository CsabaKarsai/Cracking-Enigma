package src.enigma;

import java.util.HashMap;
import java.util.Map;

public class Rotor extends Wheel implements WheelInterface {

    String rotorType;
    int rotorPosition;
    int ringSetting;
    HashMap<Integer,Integer> mappingForward;
    HashMap<Integer,Integer> mappingBackward;
    
    public Rotor(String rotorType, int rotorPosition, int ringSetting){
        this.rotorType = rotorType;
        this.rotorPosition = rotorPosition;
        this.ringSetting = ringSetting;
        if (rotorType.equals("I")) this.mappingForward = rotorI;
        if (rotorType.equals("II")) this.mappingForward = rotorII;
        if (rotorType.equals("III")) this.mappingForward = rotorIII;
        if (rotorType.equals("IV")) this.mappingForward = rotorIV;
        if (rotorType.equals("V")) this.mappingForward = rotorV;
        this.mappingBackward = swapKeysValues();
    }

    @Override
    public int encodeForward(int input) {
        System.out.println(this.rotorType);
        System.out.println("input: " + input);
        int shift = (this.ringSetting - this.rotorPosition) % 26;
        if (shift < 0) shift += 26;
        System.out.println("shift: " + shift);
        int toMap = (input - shift) % 26;
        if (toMap <= 0) toMap += 26;
        System.out.println("toMap: " + toMap);
        int mapped = this.mappingForward.get(toMap);
        System.out.println("mapped: " + mapped);
        int output = (mapped + shift) % 26;
        if (output <= 0) output += 26;
        System.out.println("output: " + output);
        return output;
    }

    @Override
    public int encodeBackward(int input) {
        System.out.println(this.rotorType);
        System.out.println("input: " + input);
        int shift = (this.ringSetting - this.rotorPosition) % 26;
        if (shift < 0) shift += 26;
        System.out.println("shift: " + shift);
        int toMap = (input - shift) % 26;
        if (toMap <= 0) toMap += 26;
        System.out.println("toMap: " + toMap);
        int mapped = this.mappingBackward.get(toMap);
        System.out.println("mapped: " + mapped);
        int output = (mapped + shift) % 26;
        if (output <= 0) output += 26;
        System.out.println("output: " + output);
        return output;
    }

    public HashMap<Integer,Integer> swapKeysValues(){
        HashMap<Integer, Integer> swappedHashMap = new HashMap<Integer, Integer>();
        for(Map.Entry<Integer, Integer> entry: this.mappingForward.entrySet()){
            swappedHashMap.put(entry.getValue(), entry.getKey());
        }
        return swappedHashMap;
    }
    
}
