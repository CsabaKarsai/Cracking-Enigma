package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;
import src.enigma.Enigma;
public class IntegrationTests {

    @Test
    public void testEnigmaEncodeSingleLetter(){
        HashMap<Integer,Integer> plugboardDefault = new HashMap<Integer,Integer>(
            Map.ofEntries(
                entry(1, 1),
                entry(2, 2),
                entry(3, 3),
                entry(4, 4),
                entry(5, 5),
                entry(6, 6),
                entry(7, 7),
                entry(8, 7),
                entry(9, 8),
                entry(10, 10),
                entry(11, 11),
                entry(12, 12),
                entry(13, 13),
                entry(14, 14),
                entry(15, 15),
                entry(16, 16),
                entry(17, 17),
                entry(18, 18),
                entry(19, 19),
                entry(20, 20),
                entry(21, 21),
                entry(22, 22),
                entry(23, 23),
                entry(24, 24),
                entry(25, 25),
                entry(26, 26)
            )
        );

        Enigma enigma = new Enigma();
        enigma.setPlugboard(plugboardDefault);
        enigma.setRightRotor("III", 1, 1);
        enigma.setMiddleRotor("II", 1, 1);
        enigma.setLeftRotor("I", 1, 1);
        enigma.setReflector("B");
        assertEquals('U', enigma.encode('A'));
        
    }

}
