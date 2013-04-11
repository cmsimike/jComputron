/**
 * User: mike
 * Date: 9/19/12
 * jUnit test class for com.xekm.jcomputron.components.basic.Byte
 */

package com.xekm.jcomputron.components.basic;

import com.xekm.jcomputron.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ByteTest {
    @Test
    public void testByteArraySetByArray() {
        boolean[] b = new boolean[]{false, false, true, false, false, false,
                false, true};
        Byte theByte = new Byte(b);
        Assert.assertTrue(Arrays.equals(b, theByte.getByteArray()));
    }

    @Test
    public void testByteArraySetByIndividualBits() {
        boolean[] b = new boolean[]{false, false, false, true, false, false,
                true, false};
        Byte theByte = new Byte(false, false, false, true, false, false, true,
                false);
        Assert.assertTrue(Arrays.equals(b, theByte.getByteArray()));
    }

    @Test
    public void testByteArraySetByEmptyConstructor() {
        boolean[] b = new boolean[]{false, false, false, false, false, false,
                false, false};
        Byte theByte = new Byte();
        Assert.assertTrue(Arrays.equals(b, theByte.getByteArray()));
    }

    @Test
    public void testByteArrayClonedCorrectly() {
        boolean[] b = new boolean[]{true, true, true, true, false, false,
                false, false};
        Byte theByte = new Byte(b);
        b[0] = false;
        b[4] = false;
        Assert.assertFalse(Arrays.equals(b, theByte.getByteArray()));
    }

    @Test
    public void testGetHighOrderNibble() {
        boolean[] b = new boolean[]{true, false, true, true, false, true,
                false, false};
        Byte theByte = new Byte(b);
        boolean test[] = new boolean[] {true, false, true, true};
        Assert.assertTrue(Arrays.equals(test, theByte.getHighOrderNibble()));
    }

    @Test
    public void testGetLowOrderNibble() {
        boolean[] b = new boolean[]{true, false, true, true, false, true,
                false, false};
        Byte theByte = new Byte(b);
        boolean test[] = new boolean[] {false, true, false, false};
        Assert.assertTrue(Arrays.equals(test, theByte.getLowOrderNibble()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testByteTooLong() {
        boolean[] b = new boolean[]{false, false, false, false, false, false,
                false, false, false};
        Byte theByte = new Byte(b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testByteTooShort() {
        boolean[] b = new boolean[]{false, false, false, false, false, false};
        Byte theByte = new Byte(b);
    }


    @Test()
    public void testByteToHex() {
        Byte b = new Byte();
        Assert.assertEquals("00", b.toHex());

        b = new Byte(Util.hexByteToBooleanArray("0D"));
        Assert.assertEquals("0D", b.toHex());

        b = new Byte(Util.hexByteToBooleanArray("FF"));
        Assert.assertEquals("FF", b.toHex());
    }
}
