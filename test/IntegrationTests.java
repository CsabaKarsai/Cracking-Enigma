package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import src.enigma.Enigma;
public class IntegrationTests {

    @Test
    public void testEnigmaEncodeSingleLetter(){
        Enigma enigma = new Enigma();
        HashMap<Integer,Integer> plugboard = enigma.generatePlugboard("AD,CN,ET,FL,GI,JV,KZ,PU,QY,WX");
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
        Enigma enigma = new Enigma();
        HashMap<Integer,Integer> plugboard = enigma.generatePlugboard("AD,CN,ET,FL,GI,JV,KZ,PU,QY,WX");
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

        plugboard = enigma.generatePlugboard("BG,UI,TL,AF,CN");
        enigma.setPlugboard(plugboard);
        enigma.setRightRotor("V", 17, 11);
        enigma.setMiddleRotor("II", 4, 20);
        enigma.setLeftRotor("I", 9, 14);
        enigma.setReflector("B");
        assertEquals("DJUTG", enigma.encodeString("SHFUY"));
    }

}
