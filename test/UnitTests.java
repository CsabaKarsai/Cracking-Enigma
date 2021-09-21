package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTests {
    
    @Test
    public void simpleTest(){
        int a = 2;
        int b = 3;
        int c = a + b;
        assertEquals(5, c);
    }

}
