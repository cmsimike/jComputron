/**
 * jcomputron
 *
 * Author:
 *   mike
 *
 * Component:
 *   com.xekm.jcomputron
 *
 * Public class:
 *   Util.java
 *
 * Overview:
 *   (What is this class about?)
 *
 * Development history:
 *   Sep 21, 2012 - mike - Created
 */

package com.xekm.jcomputron;

import com.xekm.jcomputron.components.basic.Byte;

import java.util.Arrays;

public final class Util {
    private Util() {
    }

    /**
     * Returns a hexadecimal String in the form this machine likes.
     *
     * @param i an int between 0-255
     * @return A hex string between 00-FF
     */
    public static String intToHex(int i) {
        if(i > 255 || i < 0) {
            throw new IllegalArgumentException(i + " outside of range");
        }

        String s = Integer.toHexString(i);
        if(s.length() < 2) {
            s = "0" + s;
        }

        return s.toUpperCase();
    }
    /*
    For now, assumed to only return 0-F
    Sorry future Mike. I was lazy now.
     */
    public static char boolToHex(boolean[] nibble) {
        char[] hex = {'0', '1','2','3','4','5','6','7','8','9','A', 'B', 'C', 'D', 'E', 'F'};

        for (char c : hex) {
            if(Arrays.equals(nibble, Util.hexToBool(c))) {
                return c;
            }
        }

        throw new IllegalArgumentException("Not a Nibble");
    }

    /**
     * Takes a valid hex digit and converts it into a bool array[4].
     *
     * @param hex
     * @return
     */
    public static boolean[] hexToBool(char hex) {
        hex = Character.toUpperCase(hex);
        switch (hex) {
            case '0':
                return new boolean[]{false, false, false, false};
            case '1':
                return new boolean[]{false, false, false, true};
            case '2':
                return new boolean[]{false, false, true, false};
            case '3':
                return new boolean[]{false, false, true, true};
            case '4':
                return new boolean[]{false, true, false, false};
            case '5':
                return new boolean[]{false, true, false, true};
            case '6':
                return new boolean[]{false, true, true, false};
            case '7':
                return new boolean[]{false, true, true, true};
            case '8':
                return new boolean[]{true, false, false, false};
            case '9':
                return new boolean[]{true, false, false, true};
            case 'A':
                return new boolean[]{true, false, true, false};
            case 'B':
                return new boolean[]{true, false, true, true};
            case 'C':
                return new boolean[]{true, true, false, false};
            case 'D':
                return new boolean[]{true, true, false, true};
            case 'E':
                return new boolean[]{true, true, true, false};
            case 'F':
                return new boolean[]{true, true, true, true};
            default:
                throw new IllegalArgumentException(hex
                        + " is not a correct hex value.");
        }
    }

    /**
     * Takes a 2 digit hex String, converts it into a boolean array[8].
     *
     * @param hex
     * @return
     */
    public static boolean[] hexByteToBooleanArray(String hex) {
        if (hex.length() != 2) {
            throw new IllegalArgumentException(
                    "Size not correct. Expecting length = 2, got: " + hex.length());
        }

        return new boolean[]{hexToBool(hex.charAt(0))[0],
                hexToBool(hex.charAt(0))[1], hexToBool(hex.charAt(0))[2],
                hexToBool(hex.charAt(0))[3], hexToBool(hex.charAt(1))[0],
                hexToBool(hex.charAt(1))[1], hexToBool(hex.charAt(1))[2],
                hexToBool(hex.charAt(1))[3],};

    }

    public static Byte getByteFromHexString(String hex) {
        return new Byte(hexByteToBooleanArray(hex));
    }

  /*
   * private boolean[] hexToByteArray(String h, String s) { boolean[] bits =
   * new boolean[8]; int[] d = new int[] { 8, 4, 2, 1 }; for (int j = 0; j <
   * 2; j++) { int input = this.convertOrException(new String[] { h, s }[j]);
   * for (int i = 0; i < 4; i++) { if (input >= d[i]) { input = input - d[i];
   * bits[i + ((j * 4))] = true; } else { bits[i + ((j * 4))] = false; } } }
   * return bits; }
   */
}
