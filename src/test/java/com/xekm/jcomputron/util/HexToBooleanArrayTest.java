/**
 * jcomputron
 *
 * Author:
 *   mike
 *
 * Component:
 *   com.xekm.jcomputron.util
 *
 * Public class:
 *   HexToBooleanArrayTest.java
 *
 * Overview:
 *   (What is this class about?)
 *
 * Development history:
 *   Sep 21, 2012 - mike - Created
 */

package com.xekm.jcomputron.util;

import com.xekm.jcomputron.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HexToBooleanArrayTest {

    @Test
    public void testHexCharToBooleanArray() {
        boolean[] hex0 = new boolean[]{false, false, false, false};
        boolean[] hex1 = new boolean[]{false, false, false, true};
        boolean[] hex2 = new boolean[]{false, false, true, false};
        boolean[] hex3 = new boolean[]{false, false, true, true};
        boolean[] hex4 = new boolean[]{false, true, false, false};
        boolean[] hex5 = new boolean[]{false, true, false, true};
        boolean[] hex6 = new boolean[]{false, true, true, false};
        boolean[] hex7 = new boolean[]{false, true, true, true};
        boolean[] hex8 = new boolean[]{true, false, false, false};
        boolean[] hex9 = new boolean[]{true, false, false, true};
        boolean[] hexA = new boolean[]{true, false, true, false};
        boolean[] hexB = new boolean[]{true, false, true, true};
        boolean[] hexC = new boolean[]{true, true, false, false};
        boolean[] hexD = new boolean[]{true, true, false, true};
        boolean[] hexE = new boolean[]{true, true, true, false};
        boolean[] hexF = new boolean[]{true, true, true, true};

        Assert.assertTrue(Arrays.equals(hex0, Util.hexToBool('0')));
        Assert.assertTrue(Arrays.equals(hex1, Util.hexToBool('1')));
        Assert.assertTrue(Arrays.equals(hex2, Util.hexToBool('2')));
        Assert.assertTrue(Arrays.equals(hex3, Util.hexToBool('3')));
        Assert.assertTrue(Arrays.equals(hex4, Util.hexToBool('4')));
        Assert.assertTrue(Arrays.equals(hex5, Util.hexToBool('5')));
        Assert.assertTrue(Arrays.equals(hex6, Util.hexToBool('6')));
        Assert.assertTrue(Arrays.equals(hex7, Util.hexToBool('7')));
        Assert.assertTrue(Arrays.equals(hex8, Util.hexToBool('8')));
        Assert.assertTrue(Arrays.equals(hex9, Util.hexToBool('9')));
        Assert.assertTrue(Arrays.equals(hexA, Util.hexToBool('A')));
        Assert.assertTrue(Arrays.equals(hexB, Util.hexToBool('B')));
        Assert.assertTrue(Arrays.equals(hexC, Util.hexToBool('C')));
        Assert.assertTrue(Arrays.equals(hexD, Util.hexToBool('D')));
        Assert.assertTrue(Arrays.equals(hexE, Util.hexToBool('E')));
        Assert.assertTrue(Arrays.equals(hexF, Util.hexToBool('F')));

    }

    public void testBoolToHex() {
        boolean[] test1 = Util.hexToBool('A');
        boolean[] test2 = Util.hexToBool('4');

        Assert.assertEquals('A', Util.boolToHex(test1));
        Assert.assertEquals('4', Util.boolToHex(test2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoolToHexException() {
        Util.boolToHex(new boolean[5]);
    }


    @Test
    public void testHexEncodedByte() {

        boolean[] aa = {true, false, true, false, true, false, true, false};
        boolean[] b55 = {false, true, false, true, false, true, false, true};

        Assert.assertTrue(Arrays.equals(aa, Util.hexByteToBooleanArray("aa")));
        Assert.assertTrue(Arrays.equals(aa, Util.hexByteToBooleanArray("AA")));
        Assert.assertTrue(Arrays.equals(b55, Util.hexByteToBooleanArray("55")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadHexCharacter() {
        Util.hexToBool('z');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHexStringTooLong() {
        Util.hexByteToBooleanArray("ABB");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalHexinHexString() {
        Util.hexByteToBooleanArray("AQ");
    }
}
