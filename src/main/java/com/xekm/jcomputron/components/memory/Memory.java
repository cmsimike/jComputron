/**
 * jcomputron
 *
 * Author:
 *   mike
 *
 * Component:
 *   com.xekm.jcomputron.components.memory
 *
 * Public class:
 *   Memory.java
 *
 * Overview:
 *   Ram for jComputron.
 *
 * Development history:
 *   Sep 21, 2012 - mike - Created
 */

package com.xekm.jcomputron.components.memory;

import com.xekm.jcomputron.Util;
import com.xekm.jcomputron.components.basic.Byte;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    private int TOTAL_BYTES = 256;
    // I should turn the memory into an interface so that I can implement it
    // with a bunch of different data structures. Maybe. List will always be
    // quick though

    private List<Byte> RAM;

    public Memory(String program) {
        this();
        for (int programLoader = 0, i = 0; programLoader < program.length()
                && i < TOTAL_BYTES; programLoader = programLoader + 2, i++) {
            // This is the worst way to do this. I need to clean it up.
            this.RAM.add(
                    i,
                    Util.getByteFromHexString(Character.toString(program.charAt(programLoader))
                            + Character.toString(program.charAt(programLoader + 1))));
        }
    }

    public Memory() {
        this.RAM = new ArrayList<Byte>(TOTAL_BYTES);
        for (int i = 0; i < TOTAL_BYTES; i++) {
            this.RAM.add(i, new Byte());
        }
    }

    /**
     * Gets the contents of memory by address (hex).
     *
     * @param address
     * @return
     */
    public Byte get(String address) {
        System.err.println("Memory address to get contents from: " + address);
        Byte b = this.RAM.get(convertOrException(address)).clone();
        System.err.println( "   Fetched " + b + " from memory.");
        return b;
    }

    public Byte get(Byte b) {
        Byte toReturn = this.get(b.toHex());
        System.err.println("Memory address: " +  b.toHex() + ", retrieved: " + toReturn);
        return toReturn;
    }

    /**
     * Sets a Byte in a specified memory address (hex).
     *
     * @param address
     * @param b
     */
    public void set(String address, Byte b) {
        System.err.println("Setting bit pattern " + b + " into address " + address);
        this.RAM.set(convertOrException(address), b.clone());
    }

    /**
     * Sanity check. We can only address 00-FF memory. Anything more = bad
     * Return an int because we're just using a List for memory.
     *
     * @param hexValue
     * @return
     * @throws IllegalArgumentException if the memory address is outside of
     *                                  [0-255].
     */
    private int convertOrException(String hexValue) {
        int val = Integer.parseInt(hexValue, 16);

        if (val < 0 || val > 255) {
            throw new IllegalArgumentException(
                    "Outside of memory scope. We don't have virtual memory.");
        }
        return val;
    }
}
