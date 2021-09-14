package enigma;

import java.util.Map;

public abstract class Wheel {
    public int wheelPosition;
    public int ringPosition;
    public int notchPosition;
    public Map<Character,Character> mapping;
}
