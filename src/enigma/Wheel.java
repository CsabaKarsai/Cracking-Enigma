package src.enigma;

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

    HashMap<Integer,Integer> rotorII = new HashMap<Integer,Integer>(
        Map.ofEntries(
            entry(1, 1),
            entry(2, 10),
            entry(3, 4),
            entry(4, 11),
            entry(5, 19),
            entry(6, 9),
            entry(7, 18),
            entry(8, 21),
            entry(9, 24),
            entry(10, 2),
            entry(11, 12),
            entry(12, 8),
            entry(13, 23),
            entry(14, 20),
            entry(15, 13),
            entry(16, 3),
            entry(17, 17),
            entry(18, 7),
            entry(19, 26),
            entry(20, 14),
            entry(21, 16),
            entry(22, 25),
            entry(23, 6),
            entry(24, 22),
            entry(25, 15),
            entry(26, 5)
        )
    );

    HashMap<Integer,Integer> rotorIII = new HashMap<Integer,Integer>(
        Map.ofEntries(
            entry(1, 2),
            entry(2, 4),
            entry(3, 6),
            entry(4, 8),
            entry(5, 10),
            entry(6, 12),
            entry(7, 3),
            entry(8, 16),
            entry(9, 18),
            entry(10, 20),
            entry(11, 24),
            entry(12, 22),
            entry(13, 26),
            entry(14, 14),
            entry(15, 25),
            entry(16, 5),
            entry(17, 9),
            entry(18, 23),
            entry(19, 7),
            entry(20, 1),
            entry(21, 11),
            entry(22, 13),
            entry(23, 21),
            entry(24, 19),
            entry(25, 17),
            entry(26, 15)
        )
    );

    HashMap<Integer,Integer> rotorIV = new HashMap<Integer,Integer>(
        Map.ofEntries(
            entry(1, 5),
            entry(2, 19),
            entry(3, 15),
            entry(4, 22),
            entry(5, 16),
            entry(6, 26),
            entry(7, 10),
            entry(8, 1),
            entry(9, 25),
            entry(10, 17),
            entry(11, 21),
            entry(12, 9),
            entry(13, 18),
            entry(14, 8),
            entry(15, 24),
            entry(16, 12),
            entry(17, 14),
            entry(18, 6),
            entry(19, 20),
            entry(20, 7),
            entry(21, 11),
            entry(22, 4),
            entry(23, 3),
            entry(24, 13),
            entry(25, 23),
            entry(26, 2)
        )
    );

    HashMap<Integer,Integer> rotorV = new HashMap<Integer,Integer>(
        Map.ofEntries(
            entry(1, 22),
            entry(2, 26),
            entry(3, 2),
            entry(4, 18),
            entry(5, 7),
            entry(6, 9),
            entry(7, 20),
            entry(8, 25),
            entry(9, 21),
            entry(10, 16),
            entry(11, 19),
            entry(12, 4),
            entry(13, 14),
            entry(14, 8),
            entry(15, 12),
            entry(16, 24),
            entry(17, 1),
            entry(18, 23),
            entry(19, 13),
            entry(20, 10),
            entry(21, 17),
            entry(22, 15),
            entry(23, 6),
            entry(24, 5),
            entry(25, 3),
            entry(26, 11)
        )
    );

    HashMap<Integer,Integer> reflectorA = new HashMap<Integer,Integer>(
        Map.ofEntries(
            entry(1, 5),
            entry(2, 10),
            entry(3, 13),
            entry(4, 26),
            entry(5, 1),
            entry(6, 12),
            entry(7, 25),
            entry(8, 24),
            entry(9, 22),
            entry(10, 2),
            entry(11, 23),
            entry(12, 6),
            entry(13, 3),
            entry(14, 18),
            entry(15, 17),
            entry(16, 21),
            entry(17, 15),
            entry(18, 14),
            entry(19, 20),
            entry(20, 19),
            entry(21, 16),
            entry(22, 9),
            entry(23, 11),
            entry(24, 8),
            entry(25, 7),
            entry(26, 4)
        )
    );

    HashMap<Integer,Integer> reflectorB = new HashMap<Integer,Integer>(
        Map.ofEntries(
            entry(1, 25),
            entry(2, 18),
            entry(3, 21),
            entry(4, 8),
            entry(5, 17),
            entry(6, 19),
            entry(7, 12),
            entry(8, 4),
            entry(9, 16),
            entry(10, 24),
            entry(11, 14),
            entry(12, 7),
            entry(13, 15),
            entry(14, 11),
            entry(15, 13),
            entry(16, 9),
            entry(17, 5),
            entry(18, 2),
            entry(19, 6),
            entry(20, 26),
            entry(21, 3),
            entry(22, 23),
            entry(23, 22),
            entry(24, 10),
            entry(25, 1),
            entry(26, 20)
        )
    );

    HashMap<Integer,Integer> reflectorC = new HashMap<Integer,Integer>(
        Map.ofEntries(
            entry(1, 6),
            entry(2, 22),
            entry(3, 16),
            entry(4, 10),
            entry(5, 9),
            entry(6, 1),
            entry(7, 15),
            entry(8, 25),
            entry(9, 5),
            entry(10, 4),
            entry(11, 18),
            entry(12, 26),
            entry(13, 24),
            entry(14, 23),
            entry(15, 7),
            entry(16, 3),
            entry(17, 20),
            entry(18, 11),
            entry(19, 21),
            entry(20, 17),
            entry(21, 19),
            entry(22, 2),
            entry(23, 14),
            entry(24, 13),
            entry(25, 8),
            entry(26, 12)
        )
    );

}
