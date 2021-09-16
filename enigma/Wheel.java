package enigma;

import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;
public abstract class Wheel {
    
    HashMap<Integer,Integer> rotorI = new HashMap<Integer,Integer>(
        Map.ofEntries(
            entry(1, 5),
            entry(2, 11),
            entry(3, 13),
            entry(4, 6),
            entry(5, 12),
            entry(6, 7),
            entry(7, 4),
            entry(8, 17),
            entry(9, 22),
            entry(10, 26),
            entry(11, 14),
            entry(12, 20),
            entry(13, 15),
            entry(14, 23),
            entry(15, 25),
            entry(16, 8),
            entry(17, 24),
            entry(18, 21),
            entry(19, 19),
            entry(20, 16),
            entry(21, 1),
            entry(22, 9),
            entry(23, 2),
            entry(24, 18),
            entry(25, 3),
            entry(26, 10)
        )
    );


}
