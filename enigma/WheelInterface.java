package enigma;

import java.util.HashMap;

public interface WheelInterface {
    public int encode(int input);
    public void setMapping(HashMap<Integer,Integer> mapping);
    public HashMap<Integer,Integer> getMapping();
}