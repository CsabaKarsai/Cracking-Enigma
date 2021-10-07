package src.enigma;

import java.util.HashMap;
import java.util.Map;

public class Rotor extends Wheel implements WheelInterface {

    String rotorType;
    int rotorPosition;
    int ringSetting;
    int turnover;
    HashMap<Integer,Integer> mappingForward;
    HashMap<Integer,Integer> mappingBackward;
    
    public Rotor(String rotorType, int rotorPosition, int ringSetting){
        this.rotorType = rotorType;
        this.rotorPosition = rotorPosition;
        this.ringSetting = ringSetting;
        if (rotorType.equals("I")){
            this.mappingForward = rotorI;
            this.turnover = 18;
        }
        if (rotorType.equals("II")){
            this.mappingForward = rotorII;
            this.turnover = 6;
        }
        if (rotorType.equals("III")){
            this.mappingForward = rotorIII;
            this.turnover = 23;
        }
        if (rotorType.equals("IV")){
            this.mappingForward = rotorIV;
            this.turnover = 11;
        }
        if (rotorType.equals("V")){
            this.mappingForward = rotorV;
            this.turnover = 1;
        }
        this.mappingBackward = swapKeysValues();
    }

    @Override
    public int encodeForward(int input){
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
    public int encodeBackward(int input){
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

    public void setRotorPosition(int position){
        this.rotorPosition = position;
    }

    public int getRotorPosition(){
        return this.rotorPosition;
    }

    public int getTurnover(){
        return this.turnover;
    }

    public void turn(){
        int positionBeforeTurn = getRotorPosition();
        int positionAfterTurn = (positionBeforeTurn + 1) % 26;
        if (positionAfterTurn == 0) {
            positionAfterTurn += 26;
        }
        setRotorPosition(positionAfterTurn);
    }
    
}
