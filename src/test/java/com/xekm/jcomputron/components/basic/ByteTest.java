/**
 * User: mike
 * Date: 9/19/12
 * jUnit test class for com.xekm.jcomputron.components.basic.Byte
 */
package com.xekm.jcomputron.components.basic;

import com.xekm.jcomputron.components.basic.Byte;
import org.junit.*;

import java.util.Arrays;

public class ByteTest {
    @Test
    public void testByteArraySetByArray() {
        System.out.println("Testing if setting the array by another array sets it correctly.");
        boolean[] b = new boolean[] {false, false, true, false, false, false, false, true};
        Byte theByte = new Byte(b);
        Assert.assertTrue(Arrays.equals(b, theByte.getByteArray()));
    }

    @Test
    public void testByteArraySetByIndividualBits() {
        System.out.println("Testing if setting the array by individual bits sets it correctly.");
        boolean[] b = new boolean[] {false, false, false, true, false, false, true, false};
        Byte theByte = new Byte(false, false, false, true, false, false, true, false);
        Assert.assertTrue(Arrays.equals(b, theByte.getByteArray()));
    }

    @Test
    public void testByteArraySetByEmptyConstructor() {
        System.out.println("Testing if creating a new array sets all values to false.");
        boolean[] b = new boolean[] {false, false, false, false, false, false, false, false};
        Byte theByte = new Byte();
        Assert.assertTrue(Arrays.equals(b, theByte.getByteArray()));
    }

    @Test
    public void testByteArrayClonedCorrectly() {
        System.out.println("Testing if creating a Byte by array clones the array correctly.");
        boolean[] b = new boolean[] {true, true, true, true, false, false, false, false};
        Byte theByte = new Byte(b);
        b[0] = false;
        b[4] = false;
        Assert.assertFalse(Arrays.equals(b, theByte.getByteArray()));
    }

    @Test(expected=IllegalArgumentException.class)
         public void testByteTooLong() {
        System.out.println("Making sure that long arrays passed in get an exception thrown.");
        boolean[] b = new boolean[] {false, false, false, false, false, false, false, false, false};
        Byte theByte = new Byte(b);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testByteTooShort() {
        System.out.println("Making sure that short arrays passed in get an exception thrown.");
        boolean[] b = new boolean[] {false, false, false, false, false, false};
        com.xekm.jcomputron.components.basic.Byte theByte = new Byte(b);
    }
}
