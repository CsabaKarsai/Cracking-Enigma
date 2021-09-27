package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;

import src.UI.UI;
import src.UI.Validater;
import src.enigma.Plugboard;
import src.enigma.Reflector;
import src.enigma.Rotor;

public class UnitTests {
    
    @Test
    public void testRotorIEncode(){
        //input: A = 1, output: E = 5
        Rotor rotorI = new Rotor("I", 1, 1);
        assertEquals(5, rotorI.encode(1));

        //input: A = 1, output: J = 10
        rotorI = new Rotor("I", 2, 1);
        assertEquals(10, rotorI.encode(1));

        //input: A = 1, output: K = 11
        rotorI = new Rotor("I", 1, 2);
        assertEquals(11, rotorI.encode(1));

        //input: A = 1, output: Q = 17
        rotorI = new Rotor("I", 17, 8);
        assertEquals(17, rotorI.encode(1));

        //input: T = 20, output: C = 3
        rotorI = new Rotor("I", 9, 15);
        assertEquals(3, rotorI.encode(20));
    }

    @Test
    public void testRotorIIEncode(){
        //input: A = 1, output: A = 1
        Rotor rotorII = new Rotor("II", 1, 1);
        assertEquals(1, rotorII.encode(1));

        //input: A = 1, output: I = 9
        rotorII = new Rotor("II", 2, 1);
        assertEquals(9, rotorII.encode(1));

        //input: A = 1, output: F = 6
        rotorII = new Rotor("II", 1, 2);
        assertEquals(6, rotorII.encode(1));

        //input: A = 1, output: J = 10
        rotorII = new Rotor("II", 13, 17);
        assertEquals(10, rotorII.encode(1));

        //input: J = 10, output: Q = 17
        rotorII = new Rotor("II", 9, 15);
        assertEquals(17, rotorII.encode(10));
    }

    @Test
    public void testRotorIIIEncode(){
        //input: A = 1, output: B = 2
        Rotor rotorIII = new Rotor("III", 1, 1);
        assertEquals(2, rotorIII.encode(1));

        //input: A = 1, output: C = 3
        rotorIII = new Rotor("III", 2, 1);
        assertEquals(3, rotorIII.encode(1));

        //input: A = 1, output: P = 16
        rotorIII = new Rotor("III", 1, 2);
        assertEquals(16, rotorIII.encode(1));

        //input: A = 1, output: Q = 17
        rotorIII = new Rotor("III", 3, 9);
        assertEquals(17, rotorIII.encode(1));

        //input: U = 21, output: M = 13
        rotorIII = new Rotor("III", 10, 6);
        assertEquals(13, rotorIII.encode(21));
    }

    @Test
    public void testRotorIVEncode(){
        //input: A = 1, output: E = 5
        Rotor rotorIV = new Rotor("IV", 1, 1);
        assertEquals(5, rotorIV.encode(1));

        //input: A = 1, output: R = 18
        rotorIV = new Rotor("IV", 2, 1);
        assertEquals(18, rotorIV.encode(1));

        //input: A = 1, output: C = 3
        rotorIV = new Rotor("IV", 1, 2);
        assertEquals(3, rotorIV.encode(1));

        //input: A = 1, output: B = 2
        rotorIV = new Rotor("IV", 23, 5);
        assertEquals(2, rotorIV.encode(1));

        //input: Y = 25, output: Q = 17
        rotorIV = new Rotor("IV", 12, 7);
        assertEquals(17, rotorIV.encode(25));
    }

    @Test
    public void testRotorVEncode(){
        //input: A = 1, output: V = 22
        Rotor rotorV = new Rotor("V", 1, 1);
        assertEquals(22, rotorV.encode(1));

        //input: A = 1, output: Y = 25
        rotorV = new Rotor("V", 2, 1);
        assertEquals(25, rotorV.encode(1));

        //input: A = 1, output: L = 12
        rotorV = new Rotor("V", 1, 2);
        assertEquals(12, rotorV.encode(1));

        //input: A = 1, output: D = 4
        rotorV = new Rotor("V", 16, 11);
        assertEquals(4, rotorV.encode(1));

        //input: N = 14, output: W = 23
        rotorV = new Rotor("V", 3, 20);
        assertEquals(23, rotorV.encode(14));
    }

    @Test
    public void testReflectorAEncode(){
        //input: G = 7, output: Y = 25
        Reflector reflectorA = new Reflector("A");
        assertEquals(25, reflectorA.encode(7));

        //input: Y = 25, output: G = 7
        assertEquals(7, reflectorA.encode(25));

        //input: H = 8, output: X = 24
        assertEquals(24, reflectorA.encode(8));

        //input: Z = 26, output: D = 4
        assertEquals(4, reflectorA.encode(26));
    }
    
    @Test
    public void testReflectorBEncode(){
        //input: C = 3, output: U = 21
        Reflector reflectorB = new Reflector("B");
        assertEquals(21, reflectorB.encode(3));

        //input: U = 21, output: C = 3
        assertEquals(3, reflectorB.encode(21));

        //input: Q = 17, output: E = 5
        assertEquals(5, reflectorB.encode(17));

        //input: M = 13, output: O = 15
        assertEquals(15, reflectorB.encode(13));
    }

    @Test
    public void testReflectorCEncode(){
        //input: A = 1, output: F = 6
        Reflector reflectorC = new Reflector("C");
        assertEquals(6, reflectorC.encode(1));

        //input: F = 6, output: A = 1
        assertEquals(1, reflectorC.encode(6));

        //input: J = 10, output: D = 4
        assertEquals(4, reflectorC.encode(10));

        //input: S = 19, output: U = 21
        assertEquals(21, reflectorC.encode(19));
    }

    @Test
    public void testPlugboardEncode(){
        HashMap<Integer,Integer> mapping = new HashMap<Integer,Integer>(
            Map.ofEntries(
                entry(1, 26),
                entry(2, 25),
                entry(3, 24),
                entry(4, 23),
                entry(5, 22),
                entry(6, 21),
                entry(7, 20),
                entry(8, 19),
                entry(9, 18),
                entry(10, 17),
                entry(11, 11),
                entry(12, 12),
                entry(13, 13),
                entry(14, 14),
                entry(15, 15),
                entry(16, 16),
                entry(17, 10),
                entry(18, 9),
                entry(19, 8),
                entry(20, 7),
                entry(21, 6),
                entry(22, 5),
                entry(23, 4),
                entry(24, 3),
                entry(25, 2),
                entry(26, 1)
            )
        );

        //input: A = 1, output: Z = 26
        Plugboard plugboard = new Plugboard(mapping);
        assertEquals(26, plugboard.encode(1));

        //input: B = 2, output: Y = 25
        assertEquals(25, plugboard.encode(2));

        //input: M = 13, output: M = 13
        assertEquals(13, plugboard.encode(13));

        //input: U = 21, output: F = 6
        assertEquals(6, plugboard.encode(21));
    }

    @Test
    public void testValidater(){
        Validater validater = new Validater();
        assertEquals(false, validater.validate("test"));
        assertEquals(false, validater.validate("HC, GJ,     iv"));
        assertEquals(false, validater.validate("ZG;gdf2%"));
        assertEquals(false, validater.validate("AB,AB"));
        assertEquals(false, validater.validate("AB,4U"));
        assertEquals(false, validater.validate("AB,CD,EF,GH,IJ,KL,MN,OP,QR,ST,UV"));
        assertEquals(true, validater.validate("AH,DJ,IT,NV"));
        assertEquals(true, validater.validate("AB,CD,EF,GH,IJ,KL,MN,OP,QR,ST"));
        assertEquals(true, validater.validate("ah,du,Wb,iE"));
    }

    @Test
    public void testUI(){
        UI ui = new UI();
        assertEquals("AB", ui.getIthEntry("AB,HD,KJ", 1));
        assertEquals("HD", ui.getIthEntry("AB,HD,KJ", 2));
        assertEquals("KJ", ui.getIthEntry("AB,HD,KJ", 3));
        assertThrows(IndexOutOfBoundsException.class, () -> ui.getIthEntry("AB,HD,KJ", 4));
        assertThrows(IndexOutOfBoundsException.class, () -> ui.getIthEntry("AB,HD,KJ", 0));
        assertThrows(IndexOutOfBoundsException.class, () -> ui.getIthEntry("AB,HD,KJ", -1));
    }

}
