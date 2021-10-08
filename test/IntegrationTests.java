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

        HashMap<Integer,Integer> plugboard = new HashMap<Integer,Integer>(
            Map.ofEntries(
                entry(1, 4),
                entry(2, 2),
                entry(3, 14),
                entry(4, 1),
                entry(5, 20),
                entry(6, 12),
                entry(7, 9),
                entry(8, 8),
                entry(9, 7),
                entry(10, 22),
                entry(11, 26),
                entry(12, 6),
                entry(13, 13),
                entry(14, 3),
                entry(15, 15),
                entry(16, 21),
                entry(17, 25),
                entry(18, 18),
                entry(19, 19),
                entry(20, 5),
                entry(21, 16),
                entry(22, 10),
                entry(23, 24),
                entry(24, 23),
                entry(25, 17),
                entry(26, 11)
            )
        );

        Enigma enigma = new Enigma();
        enigma.setPlugboard(plugboard);
        enigma.setRightRotor("V", 25, 22);
        enigma.setMiddleRotor("II", 8, 13);
        enigma.setLeftRotor("IV", 20, 10);
        enigma.setReflector("B");
        assertEquals('J', enigma.encodeChar('A'));
        assertEquals('I', enigma.encodeChar('B'));
        assertEquals('E', enigma.encodeChar('C'));
        
    }

    @Test
    public void testEncodeString(){
        HashMap<Integer,Integer> plugboard = new HashMap<Integer,Integer>(
            Map.ofEntries(
                entry(1, 4),
                entry(2, 2),
                entry(3, 14),
                entry(4, 1),
                entry(5, 20),
                entry(6, 12),
                entry(7, 9),
                entry(8, 8),
                entry(9, 7),
                entry(10, 22),
                entry(11, 26),
                entry(12, 6),
                entry(13, 13),
                entry(14, 3),
                entry(15, 15),
                entry(16, 21),
                entry(17, 25),
                entry(18, 18),
                entry(19, 19),
                entry(20, 5),
                entry(21, 16),
                entry(22, 10),
                entry(23, 24),
                entry(24, 23),
                entry(25, 17),
                entry(26, 11)
            )
        );

        Enigma enigma = new Enigma();
        enigma.setPlugboard(plugboard);
        enigma.setRightRotor("III", 1, 1);
        enigma.setMiddleRotor("II", 1, 1);
        enigma.setLeftRotor("I", 1, 1);
        enigma.setReflector("B");
        assertEquals("MDVFG", enigma.encodeString("AAAAA"));

        enigma.setRightRotor("III", 1, 1);
        enigma.setMiddleRotor("II", 1, 1);
        enigma.setLeftRotor("I", 1, 1);
        enigma.setReflector("B");
        assertEquals("MD VF G", enigma.encodeString("AA AA A"));

        enigma.setRightRotor("V", 17, 11);
        enigma.setMiddleRotor("II", 4, 20);
        enigma.setLeftRotor("I", 9, 14);
        enigma.setReflector("B");
        assertEquals("SVXOU", enigma.encodeString("AHFXH"));
    }

}
