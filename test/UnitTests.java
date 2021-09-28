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
    public void testRotorTurn(){
        Rotor rotor = new Rotor("I", 1, 1);
        rotor.turn();
        assertEquals(2, rotor.getRotorPosition());

        rotor = new Rotor("I", 25, 1);
        rotor.turn();
        assertEquals(26, rotor.getRotorPosition());

        rotor.turn();
        assertEquals(1, rotor.getRotorPosition());
    }
    
    @Test
    public void testRotorSwapKeysValues(){
        Rotor rotorI = new Rotor("I", 1, 1);
        HashMap<Integer,Integer> correctlySwappedMap = new HashMap<Integer,Integer>(
            Map.ofEntries(
                entry(5, 1),
                entry(11, 2),
                entry(13, 3),
                entry(6, 4),
                entry(12, 5),
                entry(7, 6),
                entry(4, 7),
                entry(17, 8),
                entry(22, 9),
                entry(26, 10),
                entry(14, 11),
                entry(20, 12),
                entry(15, 13),
                entry(23, 14),
                entry(25, 15),
                entry(8, 16),
                entry(24, 17),
                entry(21, 18),
                entry(19, 19),
                entry(16, 20),
                entry(1, 21),
                entry(9, 22),
                entry(2, 23),
                entry(18, 24),
                entry(3, 25),
                entry(10, 26)
            )
        );
        assertEquals(correctlySwappedMap, rotorI.swapKeysValues());
    }
    
    @Test
    public void testRotorIEncodeForward(){
        //input: A = 1, output: E = 5
        Rotor rotorI = new Rotor("I", 1, 1);
        assertEquals(5, rotorI.encodeForward(1));

        //input: A = 1, output: J = 10
        rotorI = new Rotor("I", 2, 1);
        assertEquals(10, rotorI.encodeForward(1));

        //input: A = 1, output: K = 11
        rotorI = new Rotor("I", 1, 2);
        assertEquals(11, rotorI.encodeForward(1));

        //input: A = 1, output: Q = 17
        rotorI = new Rotor("I", 17, 8);
        assertEquals(17, rotorI.encodeForward(1));

        //input: T = 20, output: C = 3
        rotorI = new Rotor("I", 9, 15);
        assertEquals(3, rotorI.encodeForward(20));
    }

    @Test
    public void testRotorIIEncodeForward(){
        //input: A = 1, output: A = 1
        Rotor rotorII = new Rotor("II", 1, 1);
        assertEquals(1, rotorII.encodeForward(1));

        //input: A = 1, output: I = 9
        rotorII = new Rotor("II", 2, 1);
        assertEquals(9, rotorII.encodeForward(1));

        //input: A = 1, output: F = 6
        rotorII = new Rotor("II", 1, 2);
        assertEquals(6, rotorII.encodeForward(1));

        //input: A = 1, output: J = 10
        rotorII = new Rotor("II", 13, 17);
        assertEquals(10, rotorII.encodeForward(1));

        //input: J = 10, output: Q = 17
        rotorII = new Rotor("II", 9, 15);
        assertEquals(17, rotorII.encodeForward(10));
    }

    @Test
    public void testRotorIIIEncodeForward(){
        //input: A = 1, output: B = 2
        Rotor rotorIII = new Rotor("III", 1, 1);
        assertEquals(2, rotorIII.encodeForward(1));

        //input: A = 1, output: C = 3
        rotorIII = new Rotor("III", 2, 1);
        assertEquals(3, rotorIII.encodeForward(1));

        //input: A = 1, output: P = 16
        rotorIII = new Rotor("III", 1, 2);
        assertEquals(16, rotorIII.encodeForward(1));

        //input: A = 1, output: Q = 17
        rotorIII = new Rotor("III", 3, 9);
        assertEquals(17, rotorIII.encodeForward(1));

        //input: U = 21, output: M = 13
        rotorIII = new Rotor("III", 10, 6);
        assertEquals(13, rotorIII.encodeForward(21));
    }

    @Test
    public void testRotorIVEncodeForward(){
        //input: A = 1, output: E = 5
        Rotor rotorIV = new Rotor("IV", 1, 1);
        assertEquals(5, rotorIV.encodeForward(1));

        //input: A = 1, output: R = 18
        rotorIV = new Rotor("IV", 2, 1);
        assertEquals(18, rotorIV.encodeForward(1));

        //input: A = 1, output: C = 3
        rotorIV = new Rotor("IV", 1, 2);
        assertEquals(3, rotorIV.encodeForward(1));

        //input: A = 1, output: B = 2
        rotorIV = new Rotor("IV", 23, 5);
        assertEquals(2, rotorIV.encodeForward(1));

        //input: Y = 25, output: Q = 17
        rotorIV = new Rotor("IV", 12, 7);
        assertEquals(17, rotorIV.encodeForward(25));
    }

    @Test
    public void testRotorVEncodeForward(){
        //input: A = 1, output: V = 22
        Rotor rotorV = new Rotor("V", 1, 1);
        assertEquals(22, rotorV.encodeForward(1));

        //input: A = 1, output: Y = 25
        rotorV = new Rotor("V", 2, 1);
        assertEquals(25, rotorV.encodeForward(1));

        //input: A = 1, output: L = 12
        rotorV = new Rotor("V", 1, 2);
        assertEquals(12, rotorV.encodeForward(1));

        //input: A = 1, output: D = 4
        rotorV = new Rotor("V", 16, 11);
        assertEquals(4, rotorV.encodeForward(1));

        //input: N = 14, output: W = 23
        rotorV = new Rotor("V", 3, 20);
        assertEquals(23, rotorV.encodeForward(14));
    }

    @Test
    public void testReflectorAEncodeForward(){
        //input: G = 7, output: Y = 25
        Reflector reflectorA = new Reflector("A");
        assertEquals(25, reflectorA.encodeForward(7));

        //input: Y = 25, output: G = 7
        assertEquals(7, reflectorA.encodeForward(25));

        //input: H = 8, output: X = 24
        assertEquals(24, reflectorA.encodeForward(8));

        //input: Z = 26, output: D = 4
        assertEquals(4, reflectorA.encodeForward(26));
    }
    
    @Test
    public void testReflectorBEncodeForward(){
        //input: C = 3, output: U = 21
        Reflector reflectorB = new Reflector("B");
        assertEquals(21, reflectorB.encodeForward(3));

        //input: U = 21, output: C = 3
        assertEquals(3, reflectorB.encodeForward(21));

        //input: Q = 17, output: E = 5
        assertEquals(5, reflectorB.encodeForward(17));

        //input: M = 13, output: O = 15
        assertEquals(15, reflectorB.encodeForward(13));
    }

    @Test
    public void testReflectorCEncodeForward(){
        //input: A = 1, output: F = 6
        Reflector reflectorC = new Reflector("C");
        assertEquals(6, reflectorC.encodeForward(1));

        //input: F = 6, output: A = 1
        assertEquals(1, reflectorC.encodeForward(6));

        //input: J = 10, output: D = 4
        assertEquals(4, reflectorC.encodeForward(10));

        //input: S = 19, output: U = 21
        assertEquals(21, reflectorC.encodeForward(19));
    }

    @Test
    public void testPlugboardEncodeForward(){
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
        assertEquals(26, plugboard.encodeForward(1));

        //input: B = 2, output: Y = 25
        assertEquals(25, plugboard.encodeForward(2));

        //input: M = 13, output: M = 13
        assertEquals(13, plugboard.encodeForward(13));

        //input: U = 21, output: F = 6
        assertEquals(6, plugboard.encodeForward(21));
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
